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
                    .setInputFormat("plain/text")
                    .addDictionary("DictionaryName1")
                    .addDictionary("DictionaryName2");
            final EdgeTranslationTextResult translateTextResult = lwClient.translateText(translateTextRequest);

            System.out.println(translateTextResult.getTranslation());
        }
    }
}
