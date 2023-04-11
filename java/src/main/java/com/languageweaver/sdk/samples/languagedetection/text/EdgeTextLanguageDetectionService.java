package com.languageweaver.sdk.samples.languagedetection.text;

import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.languagedetection.edge.request.EdgeTextLanguageDetectionRequest;
import com.languageweaver.sdk.languagedetection.edge.result.EdgeLanguageDetectionResult;

public class EdgeTextLanguageDetectionService {
    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeTextLanguageDetectionRequest edgeTextLanguageDetectionRequest = new EdgeTextLanguageDetectionRequest()
                    .setInput("A mountain is generally steeper than a hill")
                    .setInputFormat(Format.PLAIN)
                    .setEncoding("UTF-8");

            final EdgeLanguageDetectionResult edgeLanguageDetectionResult = lwClient.detectLanguage(edgeTextLanguageDetectionRequest);

            if (edgeLanguageDetectionResult.getLanguages() != null) {
                edgeLanguageDetectionResult.getLanguages()
                        .forEach(language -> System.out.println(language.getName()));
            }
        }
    }
}
