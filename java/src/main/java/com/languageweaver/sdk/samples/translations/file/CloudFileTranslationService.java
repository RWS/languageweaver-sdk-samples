package com.languageweaver.sdk.samples.translations.file;

import com.languageweaver.sdk.CloudLanguageWeaverClient;
import com.languageweaver.sdk.translate.request.cloud.CloudTranslateFileRequest;
import com.languageweaver.sdk.translate.result.cloud.CloudTranslationFileResult;

public class CloudFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudTranslateFileRequest translateFileRequest = new CloudTranslateFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .setInputFile("input.txt")
                    .setInputFormat("plain")
                    .addDictionary("e929ec5e-4f9c-43b1-8b1d-e48742f396d0");
            final CloudTranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
            // handle result
        }
    }
}
