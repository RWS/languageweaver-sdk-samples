package com.languageweaver.sdk.samples.asynctranslateoperations.text;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.translate.common.request.TranslateTextRequest;
import com.languageweaver.sdk.translate.common.result.AsyncTextTranslationResult;
import com.languageweaver.sdk.translate.common.result.TranslateTextResult;
import com.languageweaver.sdk.translate.common.result.TranslationStatusResult;

import java.io.IOException;

public class TextAsyncTranslateOperationsService {
    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            AsyncTextTranslationResult asyncTextTranslationResult = createTranslation(lwClient);
            checkTranslationStatus(lwClient, asyncTextTranslationResult);
            retrieveTranslatedContent(lwClient, asyncTextTranslationResult);
        }
    }

    private static AsyncTextTranslationResult createTranslation(LanguageWeaverClient lwClient) throws IOException {
        TranslateTextRequest translateTextRequest = new TranslateTextRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("fra")
                .setModel("generic")
                .addInput("The weather is wonderful today!")
                .setInputFormat(Format.PLAIN);

        return lwClient.createTextTranslation(translateTextRequest);
    }

    private static void checkTranslationStatus(LanguageWeaverClient lwClient, AsyncTextTranslationResult asyncTextTranslationResult) throws IOException, InterruptedException {
        TranslationStatusResult translationStatusResult = lwClient.checkTranslationStatus(asyncTextTranslationResult);
        System.out.println("translation status: " + translationStatusResult.getTranslationStatus());
    }

    private static void retrieveTranslatedContent(LanguageWeaverClient lwClient, AsyncTextTranslationResult asyncTextTranslationResult) throws IOException, InterruptedException {
        TranslateTextResult translateTextResult = lwClient.retrieveTextTranslatedContent(asyncTextTranslationResult);
        System.out.println("translated content: " + translateTextResult.getTranslation());
    }
}
