package com.languageweaver.sdk.samples.translations.file;

import com.languageweaver.sdk.LanguageWeaverClient;
import com.languageweaver.sdk.SdkFactory;
import com.languageweaver.sdk.configurations.ClientConfiguration;
import com.languageweaver.sdk.translate.request.TranslateFileRequest;
import com.languageweaver.sdk.translate.result.TranslationFileResult;

public class FileTranslationService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            TranslateFileRequest translateFileRequest = new TranslateFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .setInputFile("input.txt")
                    .setInputFormat("plain")
                    .addDictionary("e929ec5e-4f9c-43b1-8b1d-e48742f396d0");
            final TranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
            // handle result
        }
    }
}
