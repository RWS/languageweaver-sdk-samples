package com.languageweaver.sdk.samples.asynctranslateoperations.file;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.common.constants.Statuses;
import com.languageweaver.sdk.common.constants.TranslationConstants;
import com.languageweaver.sdk.translate.common.request.TranslateFileRequest;
import com.languageweaver.sdk.translate.common.result.AsyncFileTranslationResult;
import com.languageweaver.sdk.translate.common.result.TranslationFileResult;
import com.languageweaver.sdk.translate.common.result.TranslationStatusResult;

import java.io.File;
import java.nio.file.Paths;

public class FileAsyncTranslateOperationsService {
    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
           //create translation
            TranslateFileRequest translateFileRequest = new TranslateFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    // provide full path to the source file
                    .setInputFile(Paths.get("java", "src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                    .setOutputFile(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt")
                    .setInputFormat(Format.PLAIN);

            AsyncFileTranslationResult asyncFileTranslationResult = lwClient.createFileTranslation(translateFileRequest);

            //check status
            TranslationStatusResult translationStatusResult = lwClient.checkTranslationStatus(asyncFileTranslationResult.getRequestId());
            System.out.println("translation status: " + translationStatusResult.getTranslationStatus());

            //retrieve translated content
            TranslationStatusResult statusResponse = null;
            int sleepTime = asyncFileTranslationResult.getInputSize() < 500 ? TranslationConstants.SMALL_INPUT_SLEEP_TIME : TranslationConstants.SLEEP_TIME;
            long startTime = System.currentTimeMillis();

            String status = Statuses.INIT;
            while ((status.equals(Statuses.INIT) || status.equals(Statuses.TRANSLATING)) && System.currentTimeMillis() - startTime < TranslationConstants.CHECK_STATUS_TIMEOUT) {
                statusResponse = lwClient.checkTranslationStatus(asyncFileTranslationResult.getRequestId());
                status = statusResponse.getTranslationStatus();
                Thread.sleep(sleepTime);
            }

            TranslationFileResult translationFileResult = lwClient.retrieveTranslatedContent(asyncFileTranslationResult);
            // handle result
        }
    }
}
