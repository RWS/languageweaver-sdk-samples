package com.languageweaver.sdk.samples.translations.text;

import com.languageweaver.sdk.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.request.edge.EdgeTranslateTextRequest;
import com.languageweaver.sdk.translate.result.edge.EdgeTranslationTextResult;

public class EdgeTextTranslationService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeTranslateTextRequest translateTextRequest = new EdgeTranslateTextRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .addInput("The weather is wonderful today!")
                    .addInput("This is a new input that is part of an array translation.")
                    .setInputFormat("plain")
                    .addDictionary("e929ec5e-4f9c-43b1-8b1d-e48742f396d0");
            final EdgeTranslationTextResult translateTextResult = lwClient.translateText(translateTextRequest);

            System.out.println(translateTextResult);
        }
    }
}
