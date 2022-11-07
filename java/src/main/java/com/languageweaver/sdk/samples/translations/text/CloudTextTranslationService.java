package com.languageweaver.sdk.samples.translations.text;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.common.constants.Spelling;
import com.languageweaver.sdk.translate.cloud.request.CloudTranslateTextRequest;
import com.languageweaver.sdk.translate.cloud.result.CloudTranslationTextResult;
import com.languageweaver.sdk.translate.common.api.LinguisticOptions;

import java.io.IOException;

public class CloudTextTranslationService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            cloudLanguageWeaverClientTextTranslation(lwClient);
            cloudLanguageWeaverClientTextTranslationWithLinguisticOptions(lwClient);
        }
    }

    private static void cloudLanguageWeaverClientTextTranslation(CloudLanguageWeaverClient lwClient) throws IOException, InterruptedException {
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

    private static void cloudLanguageWeaverClientTextTranslationWithLinguisticOptions(CloudLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        CloudTranslateTextRequest translateTextRequest = new CloudTranslateTextRequest()
                .setSourceLanguageId("fra")
                .setTargetLanguageId("eng")
                .setModel("generic")
                .addInput("j'aime cette couleur")
                .setInputFormat("plain")
                .setLinguisticOptions(new LinguisticOptions().setSpelling(Spelling.UK))
                .addDictionary("689f06cf-36ba-4903-a530-da1f7766f478")
                .addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");
        final CloudTranslationTextResult translateTextResult = lwClient.translateText(translateTextRequest);

        System.out.println(translateTextResult.getTranslation());
    }

}
