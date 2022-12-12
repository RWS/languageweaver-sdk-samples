package com.languageweaver.sdk.samples.linguisticOptions;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.translate.common.api.LanguagePair;
import com.languageweaver.sdk.translate.common.result.LinguisticOptionsResult;

public class LinguisticOptionsService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            final LinguisticOptionsResult linguisticOptionsResult = lwClient.getLinguisticOptions(getLanguagePair());

            if (linguisticOptionsResult.getLinguisticOptions() != null) {
                linguisticOptionsResult.getLinguisticOptions()
                        .forEach(languagePair -> System.out.println(languagePair.getId()));
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
