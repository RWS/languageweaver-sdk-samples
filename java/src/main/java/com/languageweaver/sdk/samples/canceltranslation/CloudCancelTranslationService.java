package com.languageweaver.sdk.samples.canceltranslation;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.translate.cloud.request.CloudCancelTranslationRequest;
import com.languageweaver.sdk.translate.cloud.result.CloudCancelTranslationResult;

public class CloudCancelTranslationService {
    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudCancelTranslationRequest cloudCancelTranslationRequest = new CloudCancelTranslationRequest()
                    .setRequestId("requestId");

            CloudCancelTranslationResult cloudCancelTranslationResult = lwClient.cancelTranslation(cloudCancelTranslationRequest);
            // handle result
        }
    }
}
