package com.languageweaver.sdk.samples.canceltranslation;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.translate.common.request.CancelTranslationRequest;
import com.languageweaver.sdk.translate.common.result.CancelTranslationResult;

public class CancelTranslationService {
    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            CancelTranslationRequest cancelTranslationRequest = new CancelTranslationRequest()
                    .setRequestId("requestId");

            CancelTranslationResult cancelTranslationResult = lwClient.cancelTranslation(cancelTranslationRequest);
            // handle result
        }
    }
}
