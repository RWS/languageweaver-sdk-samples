package com.languageweaver.sdk.samples.translations.text;

import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.edge.request.EdgeTranslateTextRequest;
import com.languageweaver.sdk.translate.edge.result.EdgeTranslationTextResult;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EdgeTextTranslationService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            translateText(lwClient);
            translateTextWithLinguisticOptions(lwClient);
        }
    }

    private static void translateText(EdgeLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        EdgeTranslateTextRequest translateTextRequest = new EdgeTranslateTextRequest()
                .setLanguagePairId("EngFra_Generic_SRV_TNMV_8_5_x_1")
                .addInput("The weather is wonderful today!")
                .setInputFormat(Format.PLAIN)
                .addDictionary("DictionaryName1")
                .addDictionary("DictionaryName2");
        final EdgeTranslationTextResult translateTextResult = lwClient.translateText(translateTextRequest);

        System.out.println(translateTextResult.getTranslation());
    }

    private static void translateTextWithLinguisticOptions(EdgeLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        Map<String, String> linguisticOptions = new HashMap<>();
        linguisticOptions.put("formality", "Informal");
        EdgeTranslateTextRequest translateTextRequest = new EdgeTranslateTextRequest()
                .setLanguagePairId("EngJpn_Generic_SRV_TNMV_8_5_x_6")
                .addInput("It was a long journey, so I'm really tired now")
                .setLinguisticOptions(linguisticOptions)
                .setInputFormat(Format.PLAIN)
                .addDictionary("DictionaryName1")
                .addDictionary("DictionaryName2");
        final EdgeTranslationTextResult translateTextResult = lwClient.translateText(translateTextRequest);

        System.out.println(translateTextResult.getTranslation());
    }
}
