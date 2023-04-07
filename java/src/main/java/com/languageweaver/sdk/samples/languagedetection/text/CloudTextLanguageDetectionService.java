package com.languageweaver.sdk.samples.languagedetection.text;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.languagedetection.cloud.request.CloudTextLanguageDetectionRequest;
import com.languageweaver.sdk.languagedetection.cloud.result.CloudLanguageDetectionResult;


public class CloudTextLanguageDetectionService {
    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudTextLanguageDetectionRequest cloudTextLanguageDetectionRequest = new CloudTextLanguageDetectionRequest()
                    .setInput("A mountain is generally steeper than a hill")
                    .setInputFormat(Format.PLAIN);

            final CloudLanguageDetectionResult cloudLanguageDetectionResult = lwClient.languageDetectionText(cloudTextLanguageDetectionRequest);

            if (cloudLanguageDetectionResult.getLanguages() != null) {
                cloudLanguageDetectionResult.getLanguages()
                        .forEach(language -> System.out.println(language.getName()));
            }
        }
    }
}
