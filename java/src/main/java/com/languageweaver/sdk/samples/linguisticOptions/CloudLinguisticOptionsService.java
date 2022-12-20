package com.languageweaver.sdk.samples.linguisticOptions;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.translate.cloud.api.CloudLanguagePair;
import com.languageweaver.sdk.translate.cloud.result.CloudLinguisticOptionsResult;

public class CloudLinguisticOptionsService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            final CloudLinguisticOptionsResult cloudLinguisticOptionsResult = lwClient.getCloudLinguisticOptions(getCloudLanguagePair());

            if (cloudLinguisticOptionsResult.getLinguisticOptions() != null) {
                cloudLinguisticOptionsResult.getLinguisticOptions()
                        .forEach(linguisticOption -> System.out.println(linguisticOption.getName()));
            }
        }
    }

    private static CloudLanguagePair getCloudLanguagePair() {
        return new CloudLanguagePair()
                .setSourceLanguageId("fra")
                .setTargetLanguageId("eng")
                .setModel("generic")
                .setName("fraeng_generic");
    }
}
