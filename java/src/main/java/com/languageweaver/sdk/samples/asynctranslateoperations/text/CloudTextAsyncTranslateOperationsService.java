package com.languageweaver.sdk.samples.asynctranslateoperations.text;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.common.constants.Statuses;
import com.languageweaver.sdk.common.constants.TranslationConstants;
import com.languageweaver.sdk.translate.cloud.request.CloudTranslateTextRequest;
import com.languageweaver.sdk.translate.cloud.result.CloudAsyncTextTranslationResult;
import com.languageweaver.sdk.translate.cloud.result.CloudTranslationStatusResult;
import com.languageweaver.sdk.translate.cloud.result.CloudTranslationTextResult;
import com.languageweaver.sdk.translate.common.result.TranslationStatusResult;

import static com.languageweaver.sdk.common.constants.TranslationConstants.SLEEP_TIME;
import static com.languageweaver.sdk.common.constants.TranslationConstants.SMALL_INPUT_SLEEP_TIME;

public class CloudTextAsyncTranslateOperationsService {
    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            //create translation
            CloudTranslateTextRequest cloudTranslateTextRequest = new CloudTranslateTextRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .addInput("The weather is wonderful today!")
                    .setInputFormat(Format.PLAIN);

            CloudAsyncTextTranslationResult cloudAsyncTextTranslationResult = lwClient.createTextTranslation(cloudTranslateTextRequest);

            //check status
            CloudTranslationStatusResult cloudTranslationStatusResult = lwClient.checkCloudTranslationStatus(cloudAsyncTextTranslationResult.getRequestId());
            System.out.println("translation status: " + cloudTranslationStatusResult.getTranslationStatus());

            //retrieve translated content
            TranslationStatusResult statusResponse = null;
            int sleepTime = cloudAsyncTextTranslationResult.getInputSize() < 500 ? SMALL_INPUT_SLEEP_TIME : SLEEP_TIME;
            long startTime = System.currentTimeMillis();

            String status = Statuses.INIT;

            while ((status.equals(Statuses.INIT) || status.equals(Statuses.TRANSLATING)) && System.currentTimeMillis() - startTime < TranslationConstants.CHECK_STATUS_TIMEOUT) {
                statusResponse = lwClient.checkTranslationStatus(cloudAsyncTextTranslationResult.getRequestId());
                status = statusResponse.getTranslationStatus();
                Thread.sleep(sleepTime);
            }

            CloudTranslationTextResult cloudTranslationTextResult = lwClient.retrieveTranslatedContent(cloudAsyncTextTranslationResult);
            System.out.println("translated content: " + cloudTranslationTextResult.getTranslation().get(0));
        }
    }
}
