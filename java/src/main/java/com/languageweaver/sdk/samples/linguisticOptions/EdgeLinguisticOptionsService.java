package com.languageweaver.sdk.samples.linguisticOptions;

import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.common.configurations.CredentialsConfiguration;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.common.api.LanguagePair;
import com.languageweaver.sdk.translate.edge.api.EdgeLanguagePair;
import com.languageweaver.sdk.translate.edge.result.EdgeLinguisticOptionsResult;

public class EdgeLinguisticOptionsService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            final EdgeLinguisticOptionsResult edgeLinguisticOptionsResult = lwClient.getEdgeLinguisticOptions(getEdgeLanguagePair());

            if (edgeLinguisticOptionsResult.getLinguisticOptions() != null) {
                edgeLinguisticOptionsResult.getLinguisticOptions()
                        .forEach(linguisticOption -> System.out.println(linguisticOption.getId()));
            }
        }
    }

    private static EdgeLanguagePair getEdgeLanguagePair() {
        return new EdgeLanguagePair()
                .setSourceLanguageId("chi")
                .setTargetLanguageId("eng")
                .setLanguagePairId("ChiEng_Generic_Cloud");
    }
}
