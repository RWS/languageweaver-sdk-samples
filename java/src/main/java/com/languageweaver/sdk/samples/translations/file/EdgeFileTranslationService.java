package com.languageweaver.sdk.samples.translations.file;

import com.languageweaver.sdk.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.request.edge.EdgeTranslateFileRequest;
import com.languageweaver.sdk.translate.result.edge.EdgeTranslationFileResult;

public class EdgeFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeTranslateFileRequest translateFileRequest = new EdgeTranslateFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .setInputFile("input.txt")
                    .setInputFormat("plain")
                    .addDictionary("e929ec5e-4f9c-43b1-8b1d-e48742f396d0");
            final EdgeTranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
            // handle result
        }
    }
}
