package com.languageweaver.sdk.samples.translations.file.batch;

import com.languageweaver.sdk.LanguageWeaverClient;
import com.languageweaver.sdk.SdkFactory;
import com.languageweaver.sdk.configurations.ClientConfiguration;
import com.languageweaver.sdk.translate.request.TranslateBatchFileRequest;

public class BatchFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            TranslateBatchFileRequest translateFileRequest = new TranslateBatchFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .setInputBatchFolderPath("pathToInputBatchDirectory")
                    .setOutputBatchFolderPath("pathToOutputBatchDirectory");
            lwClient.translateBatchFile(translateFileRequest);
        }
    }
}
