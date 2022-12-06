package com.languageweaver.sdk.samples.translations.text;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.translate.common.request.TranslateTextRequest;
import com.languageweaver.sdk.translate.common.result.TranslateTextResult;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TextTranslationService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            translateText(lwClient);
            translateTextWithLinguisticOptions(lwClient);
        }
    }

    private static void translateText(LanguageWeaverClient lwClient) throws IOException, InterruptedException {
        TranslateTextRequest translateTextRequest = new TranslateTextRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("fra")
                .setModel("generic")
                .addInput("The weather is wonderful today!")
                .setInputFormat(Format.PLAIN)
                // provide list of dictionaries
                .addDictionary("dictionaryId or name");
        final TranslateTextResult translateTextResult = lwClient.translateText(translateTextRequest);

        System.out.println(translateTextResult.getTranslation());
    }

    private static void translateTextWithLinguisticOptions(LanguageWeaverClient lwClient) throws IOException, InterruptedException {
        Map<String, String> linguisticOptions = new HashMap<>();
        linguisticOptions.put("Spelling", "US");
        TranslateTextRequest translateTextRequest = new TranslateTextRequest()
                .setSourceLanguageId("fra")
                .setTargetLanguageId("eng")
                .setModel("generic")
                .addInput("j'aime cette couleur")
                .setLinguisticOptions(linguisticOptions)
                .setInputFormat(Format.PLAIN)
                // provide list of dictionaries
                .addDictionary("dictionaryId or name");
        final TranslateTextResult translateTextResult = lwClient.translateText(translateTextRequest);

        System.out.println(translateTextResult.getTranslation());
    }
}
