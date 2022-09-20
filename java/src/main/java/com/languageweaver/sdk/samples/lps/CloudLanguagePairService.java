package com.languageweaver.sdk.samples.lps;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.feedback.cloud.result.CloudLanguagePairsResult;

public class CloudLanguagePairService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            final CloudLanguagePairsResult languagePairsResult = lwClient.getCloudLanguagePairs();

            if (languagePairsResult.getLanguagePairs() != null) {
                languagePairsResult.getLanguagePairs()
                        .forEach(languagePair -> System.out.println(languagePair.getName()));
            }
        }
    }
}
