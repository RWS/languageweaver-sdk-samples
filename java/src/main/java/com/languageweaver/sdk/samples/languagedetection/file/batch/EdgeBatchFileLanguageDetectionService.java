package com.languageweaver.sdk.samples.languagedetection.file.batch;

import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.languagedetection.edge.request.EdgeBatchFileLanguageDetectionRequest;
import com.languageweaver.sdk.languagedetection.edge.result.EdgeBatchFileLanguageDetectionResult;
import com.languageweaver.sdk.languagedetection.edge.result.EdgeLanguageDetectionResult;

import java.nio.file.Paths;

public class EdgeBatchFileLanguageDetectionService {
    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeBatchFileLanguageDetectionRequest edgeFileLanguageDetectionRequest = new EdgeBatchFileLanguageDetectionRequest()
                    .setInputBatchFile(Paths.get("java", "src", "main", "resources", "input").toFile().getAbsolutePath())
                    .setEncoding("UTF-8");

            final EdgeBatchFileLanguageDetectionResult edgeBatchFileLanguageDetectionResult = lwClient.languageDetectionBatchFile(edgeFileLanguageDetectionRequest);

            for (EdgeLanguageDetectionResult edgeLanguageDetectionResult : edgeBatchFileLanguageDetectionResult.getLanguageDetectionBatchFileResult()) {
                if (edgeLanguageDetectionResult.getLanguages() != null) {
                    edgeLanguageDetectionResult.getLanguages()
                            .forEach(language -> System.out.println(language.getName()));
                }
            }
        }
    }
}
