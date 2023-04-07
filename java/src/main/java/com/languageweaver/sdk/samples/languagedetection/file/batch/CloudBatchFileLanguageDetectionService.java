package com.languageweaver.sdk.samples.languagedetection.file.batch;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.languagedetection.cloud.request.CloudBatchFileLanguageDetectionRequest;
import com.languageweaver.sdk.languagedetection.cloud.result.CloudBatchFileLanguageDetectionResult;
import com.languageweaver.sdk.languagedetection.cloud.result.CloudLanguageDetectionResult;

import java.nio.file.Paths;

public class CloudBatchFileLanguageDetectionService {
    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudBatchFileLanguageDetectionRequest cloudBatchFileLanguageDetectionRequest = new CloudBatchFileLanguageDetectionRequest()
                    .setInputBatchFile(Paths.get("java", "src", "main", "resources", "input").toFile().getAbsolutePath());

            final CloudBatchFileLanguageDetectionResult cloudBatchFileLanguageDetectionResult = lwClient.languageDetectionBatchFile(cloudBatchFileLanguageDetectionRequest);

            for (CloudLanguageDetectionResult cloudLanguageDetectionResult : cloudBatchFileLanguageDetectionResult.getLanguageDetectionBatchFileResult()) {
                if (cloudLanguageDetectionResult.getLanguages() != null) {
                    cloudLanguageDetectionResult.getLanguages()
                            .forEach(language -> System.out.println(language.getName()));
                }
            }
        }
    }
}
