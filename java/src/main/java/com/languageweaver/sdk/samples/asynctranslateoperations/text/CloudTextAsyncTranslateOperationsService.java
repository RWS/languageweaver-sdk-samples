package com.languageweaver.sdk.samples.asynctranslateoperations.text;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.translate.cloud.request.CloudTranslateTextRequest;
import com.languageweaver.sdk.translate.cloud.result.CloudAsyncTextTranslationResult;
import com.languageweaver.sdk.translate.cloud.result.CloudTranslationStatusResult;
import com.languageweaver.sdk.translate.cloud.result.CloudTranslationTextResult;

import java.io.IOException;

public class CloudTextAsyncTranslateOperationsService {
    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudAsyncTextTranslationResult cloudAsyncTextTranslationResult = createTranslation(lwClient);
            checkTranslationStatus(lwClient, cloudAsyncTextTranslationResult);
            retrieveTranslatedContent(lwClient, cloudAsyncTextTranslationResult);
        }
    }

    private static CloudAsyncTextTranslationResult createTranslation(CloudLanguageWeaverClient lwClient) throws IOException {
        CloudTranslateTextRequest cloudTranslateTextRequest = new CloudTranslateTextRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("fra")
                .setModel("generic")
                .addInput("The weather is wonderful today!")
                .setInputFormat(Format.PLAIN);

        return lwClient.createTextTranslation(cloudTranslateTextRequest);
    }

    private static void checkTranslationStatus(CloudLanguageWeaverClient lwClient, CloudAsyncTextTranslationResult cloudAsyncTextTranslationResult) throws IOException, InterruptedException {
        CloudTranslationStatusResult cloudTranslationStatusResult = lwClient.checkTranslationStatus(cloudAsyncTextTranslationResult);
        System.out.println("translation status: " + cloudTranslationStatusResult.getTranslationStatus());
    }

    private static void retrieveTranslatedContent(CloudLanguageWeaverClient lwClient, CloudAsyncTextTranslationResult cloudAsyncTextTranslationResult) throws IOException, InterruptedException {
        CloudTranslationTextResult cloudTranslationTextResult = lwClient.retrieveTextTranslatedContent(cloudAsyncTextTranslationResult);
        System.out.println("translated content: " + cloudTranslationTextResult.getTranslation().get(0));
    }
}
