package com.languageweaver.sdk.samples.linguisticoptions;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.linguisticoptions.cloud.request.CloudGetLinguisticOptionsRequest;
import com.languageweaver.sdk.linguisticoptions.cloud.result.CloudLinguisticOptionsResult;

public class CloudLinguisticOptionsService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudGetLinguisticOptionsRequest cloudGetLinguisticOptionsRequest = new CloudGetLinguisticOptionsRequest()
                    .setSourceLanguageId("chi")
                    .setTargetLanguageId("eng")
                    .setModel("generic");

            final CloudLinguisticOptionsResult cloudLinguisticOptionsResult = lwClient.getCloudLinguisticOptions(cloudGetLinguisticOptionsRequest);
            // handle result
        }
    }
}
