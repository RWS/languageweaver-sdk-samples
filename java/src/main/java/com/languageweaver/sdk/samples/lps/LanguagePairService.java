package com.languageweaver.sdk.samples.lps;

import com.languageweaver.sdk.LanguageWeaverClient;
import com.languageweaver.sdk.SdkFactory;
import com.languageweaver.sdk.configurations.ClientConfiguration;
import com.languageweaver.sdk.translate.result.LanguagePairsResult;

public class LanguagePairService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            final LanguagePairsResult languagePairsResult = lwClient.getLanguagePairs();
            // handle result
        }
    }
}
