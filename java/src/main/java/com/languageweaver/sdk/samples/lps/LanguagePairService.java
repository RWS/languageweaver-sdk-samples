package com.languageweaver.sdk.samples.lps;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.languagepairs.common.result.LanguagePairsResult;

public class LanguagePairService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            final LanguagePairsResult languagePairsResult = lwClient.getLanguagePairs();

            if (languagePairsResult.getLanguagePairs() != null) {
                languagePairsResult.getLanguagePairs()
                        .forEach(languagePair -> System.out.println(languagePair.getName()));
            }
        }
    }
}
