package com.languageweaver.sdk.samples.lps;

import com.languageweaver.sdk.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.result.edge.EdgeLanguagePairsResult;

public class EdgeLanguagePairService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            final EdgeLanguagePairsResult languagePairsResult = lwClient.getEdgeLanguagePairs();
            // handle result
        }
    }

}
