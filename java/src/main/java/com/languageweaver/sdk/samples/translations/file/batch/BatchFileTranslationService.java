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
                    // provide list of dictionaries
//                  .addDictionary("689f06cf-36ba-4903-a530-da1f7766f478")
//                  .addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");
                    // provide full path to the input and output folders
                    .setInputBatchFolderPath(Paths.get("java", "src", "main", "resources", "input").toFile().getAbsolutePath())
                    .setOutputBatchFolderPath(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath());

            lwClient.translateBatchFile(translateFileRequest);
        }
    }
}
