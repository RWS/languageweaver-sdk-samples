package com.languageweaver.sdk.samples.translations.file.batch;

import com.languageweaver.sdk.CloudLanguageWeaverClient;
import com.languageweaver.sdk.translate.request.cloud.CloudTranslateBatchFileRequest;

import java.nio.file.Paths;

public class CloudBatchFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudTranslateBatchFileRequest translateFileRequest = new CloudTranslateBatchFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .addDictionary("e929ec5e-4f9c-43b1-8b1d-e48742f396d0")
                    .addDictionary("0116ba95-8451-4cb2-ab6a-5e94334434d1")
                    .setInputBatchFolderPath(Paths.get("src", "main", "resources", "input").toFile().getAbsolutePath())
                    .setOutputBatchFolderPath(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath());
            lwClient.translateBatchFile(translateFileRequest);
        }
    }
}