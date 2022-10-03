package com.languageweaver.sdk.samples.translations.text;

import com.languageweaver.sdk.common.constants.InputFormat;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.edge.request.EdgeTranslateTextRequest;
import com.languageweaver.sdk.translate.edge.result.EdgeTranslationTextResult;

public class EdgeTextTranslationService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeTranslateTextRequest translateTextRequest = new EdgeTranslateTextRequest()
                    .setLanguagePairId("EngFra_Generic_SRV_TNMV_8_5_x_1")
                    .addInput("The weather is wonderful today!")
                    .setInputFormat(InputFormat.PLAIN)
                    .addDictionary("DictionaryName1")
                    .addDictionary("DictionaryName2");
            final EdgeTranslationTextResult translateTextResult = lwClient.translateText(translateTextRequest);

            System.out.println(translateTextResult.getTranslation());
        }
    }
}
