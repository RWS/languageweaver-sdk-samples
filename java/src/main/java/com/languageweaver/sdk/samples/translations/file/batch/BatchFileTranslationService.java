package com.languageweaver.sdk.samples.translations.file.batch;

import com.languageweaver.sdk.LanguageWeaverClient;
import com.languageweaver.sdk.SdkFactory;
import com.languageweaver.sdk.configurations.ClientConfiguration;
import com.languageweaver.sdk.translate.request.TranslateBatchFileRequest;

import java.nio.file.Paths;

public class BatchFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            TranslateBatchFileRequest translateFileRequest = new TranslateBatchFileRequest()
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
