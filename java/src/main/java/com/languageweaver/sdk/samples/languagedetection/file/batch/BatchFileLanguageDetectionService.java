package com.languageweaver.sdk.samples.languagedetection.file.batch;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.languagedetection.common.request.BatchFileLanguageDetectionRequest;
import com.languageweaver.sdk.languagedetection.common.result.BatchFileLanguageDetectionResult;
import com.languageweaver.sdk.languagedetection.common.result.LanguageDetectionResult;

import java.nio.file.Paths;

public class BatchFileLanguageDetectionService {
    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            BatchFileLanguageDetectionRequest batchFileLanguageDetectionRequest = new BatchFileLanguageDetectionRequest()
                    .setInputBatchFile(Paths.get("java", "src", "main", "resources", "input").toFile().getAbsolutePath());

            final BatchFileLanguageDetectionResult batchFileLanguageDetectionResult = lwClient.languageDetectionBatchFile(batchFileLanguageDetectionRequest);

            for (LanguageDetectionResult languageDetectionResult : batchFileLanguageDetectionResult.getLanguageDetectionBatchFileResult()) {
                if (languageDetectionResult.getLanguages() != null) {
                    languageDetectionResult.getLanguages()
                            .forEach(language -> System.out.println(language.getName()));
                }
            }
        }
    }
}
