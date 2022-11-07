package com.languageweaver.sdk.samples.translations.file.batch;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.common.constants.Formality;
import com.languageweaver.sdk.translate.common.api.LinguisticOptions;
import com.languageweaver.sdk.translate.common.request.TranslateBatchFileRequest;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;

public class BatchFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            sdkFactoryBatchFileTranslation(lwClient);
            sdkFactoryBatchFileTranslationWithLinguisticOptions(lwClient);
        }
    }

    private static void sdkFactoryBatchFileTranslation(LanguageWeaverClient lwClient) throws IOException, InterruptedException, ExecutionException {
        TranslateBatchFileRequest translateFileRequest = new TranslateBatchFileRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("fra")
                .setModel("generic")
                // provide list of dictionaries
                .addDictionary("dictionaryId or name")
                // provide full path to the input and output folders
                .setInputBatchFolderPath(Paths.get("src", "main", "resources", "input").toFile().getAbsolutePath())
                .setOutputBatchFolderPath(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath());

        lwClient.translateBatchFile(translateFileRequest);
    }

    private static void sdkFactoryBatchFileTranslationWithLinguisticOptions(LanguageWeaverClient lwClient) throws IOException, InterruptedException, ExecutionException {
        TranslateBatchFileRequest translateFileRequest = new TranslateBatchFileRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("jpn")
                .setModel("generic")
                .setLinguisticOptions(new LinguisticOptions().setFormality(Formality.Informal))
                // provide list of dictionaries
                .addDictionary("dictionaryId or name")
                // provide full path to the input and output folders
                .setInputBatchFolderPath(Paths.get("src", "main", "resources", "input").toFile().getAbsolutePath())
                .setOutputBatchFolderPath(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath());

        lwClient.translateBatchFile(translateFileRequest);
    }
}
