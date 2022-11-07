package com.languageweaver.sdk.samples.translations.text;

import com.languageweaver.sdk.common.constants.Formality;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.common.api.LinguisticOptions;
import com.languageweaver.sdk.translate.edge.request.EdgeTranslateTextRequest;
import com.languageweaver.sdk.translate.edge.result.EdgeTranslationTextResult;

import java.io.IOException;

public class EdgeTextTranslationService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            edgeLanguageWeaverClientTextTranslation(lwClient);
            edgeLanguageWeaverClientTextTranslationWithLinguisticOptions(lwClient);

        }
    }

    private static void edgeLanguageWeaverClientTextTranslation(EdgeLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        EdgeTranslateTextRequest translateTextRequest = new EdgeTranslateTextRequest()
                .setLanguagePairId("EngFra_Generic_SRV_TNMV_8_5_x_1")
                .addInput("The weather is wonderful today!")
                .setInputFormat("text/plain")
                .addDictionary("DictionaryName1")
                .addDictionary("DictionaryName2");
        final EdgeTranslationTextResult translateTextResult = lwClient.translateText(translateTextRequest);

        System.out.println(translateTextResult.getTranslation());
    }

    private static void edgeLanguageWeaverClientTextTranslationWithLinguisticOptions(EdgeLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        EdgeTranslateTextRequest translateTextRequest = new EdgeTranslateTextRequest()
                .setLanguagePairId("EngJpn_Generic_SRV_TNMV_8_5_x_6")
                .addInput("So,this is your house")
                .setLinguisticOptions(new LinguisticOptions().setFormality(Formality.Formal))
                .setInputFormat("text/plain")
                .addDictionary("DictionaryName1")
                .addDictionary("DictionaryName2");
        final EdgeTranslationTextResult translateTextResult = lwClient.translateText(translateTextRequest);

        System.out.println(translateTextResult.getTranslation());
    }
}
