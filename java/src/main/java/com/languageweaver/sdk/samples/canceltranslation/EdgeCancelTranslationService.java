package com.languageweaver.sdk.samples.canceltranslation;

import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.edge.request.EdgeCancelTranslationRequest;
import com.languageweaver.sdk.translate.edge.result.EdgeCancelTranslationResult;

public class EdgeCancelTranslationService {
    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeCancelTranslationRequest edgeCancelTranslationRequest = new EdgeCancelTranslationRequest()
                    .setTranslationId("translationId");

            EdgeCancelTranslationResult edgeCancelTranslationResult = lwClient.cancelTranslation(edgeCancelTranslationRequest);
            // handle result
        }
    }
}
