package com.languageweaver.sdk.samples.translations.file.batch;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.common.constants.PdfConverter;
import com.languageweaver.sdk.translate.common.request.TranslateBatchFileRequest;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class BatchFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            translateBatchFile(lwClient);
            translateBatchFileWithLinguisticOptions(lwClient);
        }
    }

    private static void translateBatchFile(LanguageWeaverClient lwClient) throws IOException, InterruptedException, ExecutionException {
        TranslateBatchFileRequest translateFileRequest = new TranslateBatchFileRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("fra")
                .setModel("generic")
                .setPdfConverter(PdfConverter.STANDARD)
                // provide list of dictionaries
                .addDictionary("dictionaryId or name")
                // provide full path to the input and output folders
                .setInputBatchFolderPath(Paths.get("java", "src", "main", "resources", "input").toFile().getAbsolutePath())
                .setOutputBatchFolderPath(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath());

        lwClient.translateBatchFile(translateFileRequest);
    }

    private static void translateBatchFileWithLinguisticOptions(LanguageWeaverClient lwClient) throws IOException, InterruptedException, ExecutionException {
        Map<String, String> linguisticOptions = new HashMap<>();
        linguisticOptions.put("Spelling", "US");
        TranslateBatchFileRequest translateFileRequest = new TranslateBatchFileRequest()
                .setSourceLanguageId("fra")
                .setTargetLanguageId("eng")
                .setModel("generic")
                // provide list of dictionaries
                .addDictionary("dictionaryId or name")
                .setLinguisticOptions(linguisticOptions)
                // provide full path to the input and output folders
                .setInputBatchFolderPath(Paths.get("java", "src", "main", "resources", "input").toFile().getAbsolutePath())
                .setOutputBatchFolderPath(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath());

        lwClient.translateBatchFile(translateFileRequest);
    }
}
