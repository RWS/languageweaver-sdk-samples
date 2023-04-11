package com.languageweaver.sdk.samples.languagedetection.file;

import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.languagedetection.edge.request.EdgeFileLanguageDetectionRequest;
import com.languageweaver.sdk.languagedetection.edge.result.EdgeLanguageDetectionResult;

import java.nio.file.Paths;

public class EdgeFileLanguageDetectionService {
    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeFileLanguageDetectionRequest edgeFileLanguageDetectionRequest = new EdgeFileLanguageDetectionRequest()
                    .setInputFile(Paths.get("java", "src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                    .setInputFormat(Format.PLAIN)
                    .setEncoding("UTF-8");

            final EdgeLanguageDetectionResult edgeLanguageDetectionResult = lwClient.detectLanguage(edgeFileLanguageDetectionRequest);

            if (edgeLanguageDetectionResult.getLanguages() != null) {
                edgeLanguageDetectionResult.getLanguages()
                        .forEach(language -> System.out.println(language.getName()));
            }
        }
    }
}
