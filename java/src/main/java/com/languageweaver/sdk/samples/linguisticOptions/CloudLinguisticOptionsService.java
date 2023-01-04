package com.languageweaver.sdk.samples.linguisticOptions;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.translate.cloud.request.linguisticOptions.CloudGetLinguisticOptionsRequest;
import com.languageweaver.sdk.translate.cloud.result.linguisticOptions.CloudLinguisticOptionsResult;

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
