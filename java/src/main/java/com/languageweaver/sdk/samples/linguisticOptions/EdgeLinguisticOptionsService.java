package com.languageweaver.sdk.samples.linguisticOptions;

import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.common.api.LanguagePair;
import com.languageweaver.sdk.translate.edge.result.EdgeLinguisticOptionsResult;

public class EdgeLinguisticOptionsService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            final EdgeLinguisticOptionsResult edgeLinguisticOptionsResult = lwClient.getEdgeLinguisticOptions(getLanguagePair());

            if (edgeLinguisticOptionsResult.getLinguisticOptions() != null) {
                edgeLinguisticOptionsResult.getLinguisticOptions()
                        .forEach(linguisticOption -> System.out.println(linguisticOption.getId()));
            }
        }
    }

    private static LanguagePair getLanguagePair() {
        return new LanguagePair()
                .setSourceLanguageId("chi")
                .setTargetLanguageId("eng")
                .setModel("generic")
                .setName("ChiEng_Generic_Cloud");
    }
}
