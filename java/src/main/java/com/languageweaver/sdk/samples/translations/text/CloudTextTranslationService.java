package com.languageweaver.sdk.samples.translations.text;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.translate.cloud.request.CloudTranslateTextRequest;
import com.languageweaver.sdk.translate.cloud.result.CloudTranslationTextResult;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CloudTextTranslationService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            translateText(lwClient);
            translateTextWithLinguisticOptions(lwClient);
        }
    }

    private static void translateText(CloudLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        CloudTranslateTextRequest translateTextRequest = new CloudTranslateTextRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("fra")
                .setModel("generic")
                .addInput("The weather is wonderful today!")
                .addInput("This is a new input that is part of an array translation.")
                .setInputFormat(Format.PLAIN)
                .addDictionary("689f06cf-36ba-4903-a530-da1f7766f478")
                .addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");
        final CloudTranslationTextResult translateTextResult = lwClient.translateText(translateTextRequest);

        System.out.println(translateTextResult.getTranslation());
    }

    private static void translateTextWithLinguisticOptions(CloudLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        Map<String, String> linguisticOptions = new HashMap<>();
        linguisticOptions.put("Spelling", "UK");
        CloudTranslateTextRequest translateTextRequest = new CloudTranslateTextRequest()
                .setSourceLanguageId("fra")
                .setTargetLanguageId("eng")
                .setModel("generic")
                .addInput("j'aime cette couleur")
                .setInputFormat(Format.PLAIN)
                .setLinguisticOptions(linguisticOptions)
                .addDictionary("689f06cf-36ba-4903-a530-da1f7766f478")
                .addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");
        final CloudTranslationTextResult translateTextResult = lwClient.translateText(translateTextRequest);

        System.out.println(translateTextResult.getTranslation());
    }
}
