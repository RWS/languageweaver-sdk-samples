package com.languageweaver.sdk.samples.translations.file.batch;

import com.languageweaver.sdk.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.request.edge.EdgeTranslateBatchFileRequest;

public class EdgeBatchFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeTranslateBatchFileRequest translateFileRequest = new EdgeTranslateBatchFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .setInputBatchFolderPath("pathToInputBatchDirectory")
                    .setOutputBatchFolderPath("pathToOutputBatchDirectory");
            lwClient.translateBatchFile(translateFileRequest);
        }
    }
}
