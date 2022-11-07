package com.languageweaver.sdk.samples.translations.text;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.common.constants.Formality;
import com.languageweaver.sdk.translate.common.api.LinguisticOptions;
import com.languageweaver.sdk.translate.common.request.TranslateTextRequest;
import com.languageweaver.sdk.translate.common.result.TranslateTextResult;

import java.io.IOException;

public class TextTranslationService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            sdkFactoryTextTranslation(lwClient);
            sdkFactoryTextTranslationWithLinguisticOptions(lwClient);
        }
    }

    private static void sdkFactoryTextTranslation(LanguageWeaverClient lwClient) throws IOException, InterruptedException {
        TranslateTextRequest translateTextRequest = new TranslateTextRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("fra")
                .setModel("generic")
                .addInput("The weather is wonderful today!")
                .setInputFormat("plain")
                // provide list of dictionaries
                .addDictionary("dictionaryId or name");
        final TranslateTextResult translateTextResult = lwClient.translateText(translateTextRequest);

        System.out.println(translateTextResult.getTranslation());
    }

    private static void sdkFactoryTextTranslationWithLinguisticOptions(LanguageWeaverClient lwClient) throws IOException, InterruptedException {
        TranslateTextRequest translateTextRequest = new TranslateTextRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("jpn")
                .setModel("generic")
                .addInput("So,this is your house")
                .setInputFormat("plain")
                .setLinguisticOptions(new LinguisticOptions().setFormality(Formality.Informal))
                // provide list of dictionaries
                .addDictionary("dictionaryId or name");
        final TranslateTextResult translateTextResult = lwClient.translateText(translateTextRequest);

        System.out.println(translateTextResult.getTranslation());
    }
}
