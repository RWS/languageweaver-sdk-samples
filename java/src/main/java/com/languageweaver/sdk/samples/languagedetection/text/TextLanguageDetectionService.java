package com.languageweaver.sdk.samples.languagedetection.text;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.languagedetection.common.request.TextLanguageDetectionRequest;
import com.languageweaver.sdk.languagedetection.common.result.LanguageDetectionResult;

public class TextLanguageDetectionService {
    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            TextLanguageDetectionRequest textLanguageDetectionRequest = new TextLanguageDetectionRequest()
                    .setInput("A mountain is generally steeper than a hill")
                    .setInputFormat(Format.PLAIN);

            final LanguageDetectionResult languageDetectionResult = lwClient.languageDetectionText(textLanguageDetectionRequest);

            if (languageDetectionResult.getLanguages() != null) {
                languageDetectionResult.getLanguages()
                        .forEach(language -> System.out.println(language.getName()));
            }
        }
    }
}
