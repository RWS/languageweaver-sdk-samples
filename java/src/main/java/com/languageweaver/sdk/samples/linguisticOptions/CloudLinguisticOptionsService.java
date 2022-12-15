package com.languageweaver.sdk.samples.linguisticOptions;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.translate.cloud.result.CloudLinguisticOptionsResult;
import com.languageweaver.sdk.translate.common.api.LanguagePair;

public class CloudLinguisticOptionsService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            final CloudLinguisticOptionsResult cloudLinguisticOptionsResult = lwClient.getCloudLinguisticOptions(getLanguagePair());

            if (cloudLinguisticOptionsResult.getLinguisticOptions() != null) {
                cloudLinguisticOptionsResult.getLinguisticOptions()
                        .forEach(linguisticOption -> System.out.println(linguisticOption.getName()));
            }
        }
    }

    private static LanguagePair getLanguagePair() {
        return new LanguagePair()
                .setSourceLanguageId("fra")
                .setTargetLanguageId("eng")
                .setModel("generic")
                .setName("fraeng_generic");
    }
}
