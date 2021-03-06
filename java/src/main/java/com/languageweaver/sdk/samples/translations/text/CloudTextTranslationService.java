package com.languageweaver.sdk.samples.translations.text;

import com.languageweaver.sdk.CloudLanguageWeaverClient;
import com.languageweaver.sdk.translate.request.cloud.CloudTranslateTextRequest;
import com.languageweaver.sdk.translate.result.cloud.CloudTranslationTextResult;

public class CloudTextTranslationService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudTranslateTextRequest translateTextRequest = new CloudTranslateTextRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .addInput("The weather is wonderful today!")
                    .addInput("This is a new input that is part of an array translation.")
                    .setInputFormat("plain")
                    .addDictionary("689f06cf-36ba-4903-a530-da1f7766f478")
                    .addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");
            final CloudTranslationTextResult translateTextResult = lwClient.translateText(translateTextRequest);

            System.out.println(translateTextResult.getTranslation());
        }
    }
}
