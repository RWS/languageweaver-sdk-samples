package com.languageweaver.sdk.samples.translations.text;

import com.languageweaver.sdk.LanguageWeaverClient;
import com.languageweaver.sdk.SdkFactory;
import com.languageweaver.sdk.configurations.ClientConfiguration;
import com.languageweaver.sdk.translate.request.TranslateTextRequest;
import com.languageweaver.sdk.translate.result.TranslateTextResult;

public class TextTranslationService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            TranslateTextRequest translateTextRequest = new TranslateTextRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .addInput("The weather is wonderful today!")
                    .addInput("This is a new input that is part of an array translation.")
                    .setInputFormat("plain")
                    .addDictionary("e929ec5e-4f9c-43b1-8b1d-e48742f396d0");
            final TranslateTextResult translateTextResult = lwClient.translateText(translateTextRequest);

            System.out.println(translateTextResult);
        }
    }
}
