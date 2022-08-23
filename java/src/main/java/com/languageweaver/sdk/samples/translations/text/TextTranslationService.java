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
                    // provide list of dictionaries
//                  .addDictionary("689f06cf-36ba-4903-a530-da1f7766f478")
//                  .addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956")
                    .addInput("The weather is wonderful today!")
                    .setInputFormat("plain");

            final TranslateTextResult translateTextResult = lwClient.translateText(translateTextRequest);

            System.out.println(translateTextResult.getTranslation());
        }
    }
}
