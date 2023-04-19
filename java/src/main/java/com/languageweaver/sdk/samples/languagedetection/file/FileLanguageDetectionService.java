package com.languageweaver.sdk.samples.languagedetection.file;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.languagedetection.common.request.FileLanguageDetectionRequest;
import com.languageweaver.sdk.languagedetection.common.result.LanguageDetectionResult;

import java.nio.file.Paths;

public class FileLanguageDetectionService {
    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            FileLanguageDetectionRequest fileLanguageDetectionRequest = new FileLanguageDetectionRequest()
                    .setInputFile(Paths.get("java", "src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                    .setInputFormat(Format.PLAIN);

            final LanguageDetectionResult languageDetectionResult = lwClient.detectLanguage(fileLanguageDetectionRequest);

            if (languageDetectionResult.getLanguages() != null) {
                languageDetectionResult.getLanguages()
                        .forEach(language -> System.out.println(language.getName()));
            }
        }
    }
}
