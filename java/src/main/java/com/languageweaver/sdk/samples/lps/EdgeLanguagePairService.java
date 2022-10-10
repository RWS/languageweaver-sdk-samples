package com.languageweaver.sdk.samples.lps;

import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.edge.result.EdgeLanguagePairsResult;

public class EdgeLanguagePairService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            final EdgeLanguagePairsResult languagePairsResult = lwClient.getEdgeLanguagePairs();

            if (languagePairsResult.getLanguagePairs() != null) {
                languagePairsResult.getLanguagePairs()
                        .forEach(languagePair -> System.out.println(languagePair.getLanguagePairId()));
            }
        }
    }

}
