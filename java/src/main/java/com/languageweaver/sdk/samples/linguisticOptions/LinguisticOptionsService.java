package com.languageweaver.sdk.samples.linguisticOptions;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.translate.common.request.linguisticOptions.GetLinguisticOptionsRequest;
import com.languageweaver.sdk.translate.common.result.linguisticOptions.LinguisticOptionsResult;

public class LinguisticOptionsService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            GetLinguisticOptionsRequest getLinguisticOptionsRequest = new GetLinguisticOptionsRequest()
                    .setSourceLanguageId("chi")
                    .setTargetLanguageId("eng")
                    .setModel("generic");

            final LinguisticOptionsResult linguisticOptionsResult = lwClient.getLinguisticOptions(getLinguisticOptionsRequest);
            // handle result
        }
    }
}
