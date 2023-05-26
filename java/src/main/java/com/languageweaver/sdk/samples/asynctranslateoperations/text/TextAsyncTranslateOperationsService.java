package com.languageweaver.sdk.samples.asynctranslateoperations.text;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.common.constants.*;
import com.languageweaver.sdk.translate.common.request.TranslateTextRequest;
import com.languageweaver.sdk.translate.common.result.AsyncTextTranslationResult;
import com.languageweaver.sdk.translate.common.result.TranslateTextResult;
import com.languageweaver.sdk.translate.common.result.TranslationStatusResult;

public class TextAsyncTranslateOperationsService {
    public static void main(String[] args) throws Exception {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(clientConfiguration)) {
            //create translation
            TranslateTextRequest translateTextRequest = new TranslateTextRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .addInput("The weather is wonderful today!")
                    .setInputFormat(Format.PLAIN);

            AsyncTextTranslationResult asyncTextTranslationResult = lwClient.createTextTranslation(translateTextRequest);

            //check status
            TranslationStatusResult translationStatusResult = lwClient.checkTranslationStatus(asyncTextTranslationResult.getRequestId());
            System.out.println("translation status: " + translationStatusResult.getTranslationStatus());

            //retrieve translated content
            TranslationStatusResult statusResponse = null;
            int sleepTime = asyncTextTranslationResult.getInputSize() < 500 ? TranslationConstants.SMALL_INPUT_SLEEP_TIME : TranslationConstants.SLEEP_TIME;
            long startTime = System.currentTimeMillis();


            String status = clientConfiguration.getProduct().equals(Product.CLOUD) ? Statuses.INIT : EdgeStatuses.PREPARING;

            while (isInitStatus(status) || isTranslatingStatus(status) && System.currentTimeMillis() - startTime < TranslationConstants.CHECK_STATUS_TIMEOUT) {
                statusResponse = lwClient.checkTranslationStatus(asyncTextTranslationResult.getRequestId());
                status = statusResponse.getTranslationStatus();
                Thread.sleep(sleepTime);
            }

            TranslateTextResult translateTextResult = lwClient.retrieveTranslatedContent(asyncTextTranslationResult);
            System.out.println("translated content: " + translateTextResult.getTranslation());
        }
    }

    private static boolean isInitStatus(String status) {
        return status.equals(Statuses.INIT) || status.equals(EdgeStatuses.PREPARING);
    }

    private static boolean isTranslatingStatus(String status) {
        return status.equals(Statuses.TRANSLATING) || status.equals(EdgeStatuses.IN_PROGRESS);
    }
}
