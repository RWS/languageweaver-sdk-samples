package com.languageweaver.sdk.samples.translations.file.batch;

import com.languageweaver.sdk.CloudLanguageWeaverClient;
import com.languageweaver.sdk.translate.request.cloud.CloudTranslateBatchFileRequest;

public class CloudBatchFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudTranslateBatchFileRequest translateFileRequest = new CloudTranslateBatchFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .setInputBatchFolderPath("pathToInputBatchDirectory")
                    .setOutputBatchFolderPath("pathToOutputBatchDirectory");
            lwClient.translateBatchFile(translateFileRequest);
        }
    }
}
