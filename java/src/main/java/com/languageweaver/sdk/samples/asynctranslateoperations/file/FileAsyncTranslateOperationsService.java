package com.languageweaver.sdk.samples.asynctranslateoperations.file;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.translate.common.request.TranslateFileRequest;
import com.languageweaver.sdk.translate.common.result.AsyncFileTranslationResult;
import com.languageweaver.sdk.translate.common.result.TranslationFileResult;
import com.languageweaver.sdk.translate.common.result.TranslationStatusResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class FileAsyncTranslateOperationsService {
    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            AsyncFileTranslationResult asyncTextTranslationResult = createTextTranslation(lwClient);
            checkTranslationStatus(lwClient, asyncTextTranslationResult);
            retrieveTranslatedContent(lwClient, asyncTextTranslationResult);
        }
    }

    private static AsyncFileTranslationResult createTextTranslation(LanguageWeaverClient lwClient) throws IOException {
        TranslateFileRequest translateFileRequest = new TranslateFileRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("fra")
                .setModel("generic")
                // provide full path to the source file
                .setInputFile(Paths.get("java", "src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt")
                .setInputFormat(Format.PLAIN);

        return lwClient.createFileTranslation(translateFileRequest);
    }

    private static void checkTranslationStatus(LanguageWeaverClient lwClient, AsyncFileTranslationResult asyncFileTranslationResult) throws IOException, InterruptedException {
        TranslationStatusResult translationStatusResult = lwClient.checkTranslationStatus(asyncFileTranslationResult);
        System.out.println("translation status: " + translationStatusResult.getTranslationStatus());
    }

    private static void retrieveTranslatedContent(LanguageWeaverClient lwClient, AsyncFileTranslationResult asyncFileTranslationResult) throws IOException, InterruptedException {
        TranslationFileResult translateTextResult = lwClient.retrieveFileTranslatedContent(asyncFileTranslationResult);
        // handle result
    }
}
