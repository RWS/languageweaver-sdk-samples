package com.languageweaver.sdk.samples.asynctranslateoperations.file;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.common.constants.Statuses;
import com.languageweaver.sdk.common.constants.TranslationConstants;
import com.languageweaver.sdk.translate.cloud.request.CloudTranslateFileRequest;
import com.languageweaver.sdk.translate.cloud.result.CloudAsyncFileTranslationResult;
import com.languageweaver.sdk.translate.cloud.result.CloudTranslationFileResult;
import com.languageweaver.sdk.translate.cloud.result.CloudTranslationStatusResult;
import com.languageweaver.sdk.translate.common.result.TranslationStatusResult;

import java.io.File;
import java.nio.file.Paths;

import static com.languageweaver.sdk.common.constants.TranslationConstants.SLEEP_TIME;
import static com.languageweaver.sdk.common.constants.TranslationConstants.SMALL_INPUT_SLEEP_TIME;

public class CloudFileAsyncTranslateOperationsService {
    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            //create translation
            CloudTranslateFileRequest translateFileRequest = new CloudTranslateFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .setInputFormat(Format.PLAIN)
                    // provide full path to the source file
                    .setInputFile(Paths.get("java", "src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                    .setOutputFile(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt");

            CloudAsyncFileTranslationResult cloudAsyncFileTranslationResult = lwClient.createFileTranslation(translateFileRequest);

            //check status
            CloudTranslationStatusResult cloudTranslationStatusResult = lwClient.checkCloudTranslationStatus(cloudAsyncFileTranslationResult.getRequestId());
            System.out.println("translation status: " + cloudTranslationStatusResult.getTranslationStatus());

            //retrieve translated content
            TranslationStatusResult statusResponse = null;
            int sleepTime = cloudAsyncFileTranslationResult.getInputSize() < 500 ? SMALL_INPUT_SLEEP_TIME : SLEEP_TIME;
            long startTime = System.currentTimeMillis();

            String status = Statuses.INIT;

            while ((status.equals(Statuses.INIT) || status.equals(Statuses.TRANSLATING)) && System.currentTimeMillis() - startTime < TranslationConstants.CHECK_STATUS_TIMEOUT) {
                statusResponse = lwClient.checkTranslationStatus(cloudAsyncFileTranslationResult.getRequestId());
                status = statusResponse.getTranslationStatus();
                Thread.sleep(sleepTime);
            }

            CloudTranslationFileResult cloudTranslationFileResult = lwClient.retrieveTranslatedContent(cloudAsyncFileTranslationResult);
            // handle result
        }
    }
}
