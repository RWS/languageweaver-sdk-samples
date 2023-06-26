package com.languageweaver.sdk.samples.asynctranslations.file;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.common.constants.*;
import com.languageweaver.sdk.translate.common.request.TranslateFileRequest;
import com.languageweaver.sdk.translate.common.result.AsyncFileTranslationResult;
import com.languageweaver.sdk.translate.common.result.TranslationFileResult;
import com.languageweaver.sdk.translate.common.result.TranslationStatusResult;

import java.io.File;
import java.nio.file.Paths;

public class FileAsyncTranslateOperationsService {
    public static void main(String[] args) throws Exception {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(clientConfiguration)) {
            //create translation
            TranslateFileRequest translateFileRequest = new TranslateFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    // provide full path to the source file
                    .setInputFile(Paths.get("src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                    .setOutputFile(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt")
                    .setInputFormat(Format.PLAIN);

            AsyncFileTranslationResult asyncFileTranslationResult = lwClient.createFileTranslation(translateFileRequest);

            //check status
            TranslationStatusResult translationStatusResult = lwClient.checkTranslationStatus(asyncFileTranslationResult.getRequestId());
            System.out.println("translation status: " + translationStatusResult.getTranslationStatus());

            //retrieve translated content
            TranslationStatusResult statusResponse;
            int sleepTime = asyncFileTranslationResult.getOptimalStatusCheckDelay();
            long startTime = System.currentTimeMillis();

            String status = clientConfiguration.getProduct().equals(Product.CLOUD) ? Statuses.INIT : EdgeStatuses.PREPARING;

            while (isInitStatus(status) || isTranslatingStatus(status) && System.currentTimeMillis() - startTime < TranslationConstants.CHECK_STATUS_TIMEOUT) {
                statusResponse = lwClient.checkTranslationStatus(asyncFileTranslationResult.getRequestId());
                status = statusResponse.getTranslationStatus();
                Thread.sleep(sleepTime);
            }

            TranslationFileResult translationFileResultWithOutputFile = lwClient.retrieveTranslatedContent(asyncFileTranslationResult, translateFileRequest.getOutputFile());
            // handle result

            TranslationFileResult translationFileResultWithoutOutputFile = lwClient.retrieveTranslatedContent(asyncFileTranslationResult);
            // handle result
        }
    }

    private static boolean isInitStatus(String status) {
        return status.equals(Statuses.INIT) || status.equals(EdgeStatuses.PREPARING);
    }

    private static boolean isTranslatingStatus(String status) {
        return status.equals(Statuses.TRANSLATING) || status.equals(EdgeStatuses.IN_PROGRESS);
    }
}
