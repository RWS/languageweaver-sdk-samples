package com.languageweaver.sdk.samples.translations.text;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.translate.common.request.TranslateTextRequest;
import com.languageweaver.sdk.translate.common.result.TranslateTextResult;

public class TextTranslationService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
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
    }
}
