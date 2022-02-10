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
                    .addDictionary("e929ec5e-4f9c-43b1-8b1d-e48742f396d0")
                    .addDictionary("0116ba95-8451-4cb2-ab6a-5e94334434d1");
            final CloudTranslationTextResult translateTextResult = lwClient.translateText(translateTextRequest);

            System.out.println(translateTextResult.getTranslation());
        }
    }
}
