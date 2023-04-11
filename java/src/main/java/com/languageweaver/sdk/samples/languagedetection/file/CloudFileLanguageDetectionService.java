package com.languageweaver.sdk.samples.languagedetection.file;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.languagedetection.cloud.request.CloudFileLanguageDetectionRequest;
import com.languageweaver.sdk.languagedetection.cloud.result.CloudLanguageDetectionResult;

import java.nio.file.Paths;

public class CloudFileLanguageDetectionService {
    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudFileLanguageDetectionRequest cloudFileLanguageDetectionRequest = new CloudFileLanguageDetectionRequest()
                    .setInputFile(Paths.get("java", "src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                    .setInputFormat(Format.PLAIN);

            final CloudLanguageDetectionResult cloudLanguageDetectionResult = lwClient.detectLanguage(cloudFileLanguageDetectionRequest);

            if (cloudLanguageDetectionResult.getLanguages() != null) {
                cloudLanguageDetectionResult.getLanguages()
                        .forEach(language -> System.out.println(language.getName()));
            }
        }
    }
}
