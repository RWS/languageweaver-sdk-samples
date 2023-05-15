package com.languageweaver.sdk.samples.asynctranslateoperations.file;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.translate.cloud.request.CloudTranslateFileRequest;
import com.languageweaver.sdk.translate.cloud.result.CloudAsyncFileTranslationResult;
import com.languageweaver.sdk.translate.cloud.result.CloudTranslationFileResult;
import com.languageweaver.sdk.translate.cloud.result.CloudTranslationStatusResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class CloudFileAsyncTranslateOperationsService {
    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudAsyncFileTranslationResult cloudAsyncTextTranslationResult = createTranslation(lwClient);
            checkTranslationStatus(lwClient, cloudAsyncTextTranslationResult);
            retrieveTranslatedContent(lwClient, cloudAsyncTextTranslationResult);
        }
    }

    private static CloudAsyncFileTranslationResult createTranslation(CloudLanguageWeaverClient lwClient) throws IOException {
        CloudTranslateFileRequest translateFileRequest = new CloudTranslateFileRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("fra")
                .setModel("generic")
                .setInputFormat(Format.PLAIN)
                // provide full path to the source file
                .setInputFile(Paths.get("java", "src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt");

        return lwClient.createFileTranslation(translateFileRequest);
    }

    private static void checkTranslationStatus(CloudLanguageWeaverClient lwClient, CloudAsyncFileTranslationResult cloudAsyncTextTranslationResult) throws IOException, InterruptedException {
        CloudTranslationStatusResult cloudTranslationStatusResult = lwClient.checkTranslationStatus(cloudAsyncTextTranslationResult);
        System.out.println("translation status: " + cloudTranslationStatusResult.getTranslationStatus());
    }

    private static void retrieveTranslatedContent(CloudLanguageWeaverClient lwClient, CloudAsyncFileTranslationResult cloudAsyncTextTranslationResult) throws IOException, InterruptedException {
        CloudTranslationFileResult cloudTranslationTextResult = lwClient.retrieveFileTranslatedContent(cloudAsyncTextTranslationResult);
        // handle result
    }
}
