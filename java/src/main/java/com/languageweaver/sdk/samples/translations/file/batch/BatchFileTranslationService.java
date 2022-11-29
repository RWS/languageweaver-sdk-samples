package com.languageweaver.sdk.samples.translations.file.batch;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.common.constants.PdfConverter;
import com.languageweaver.sdk.translate.common.request.TranslateBatchFileRequest;

import java.nio.file.Paths;

public class BatchFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            TranslateBatchFileRequest translateFileRequest = new TranslateBatchFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .setPdfConverter(PdfConverter.STANDARD)
                    // provide list of dictionaries
                    .addDictionary("dictionaryId or name")
                    // provide full path to the input and output folders
                    .setInputBatchFolderPath(Paths.get("java","src", "main", "resources", "input").toFile().getAbsolutePath())
                    .setOutputBatchFolderPath(Paths.get("java","src", "main", "resources", "output").toFile().getAbsolutePath());

            lwClient.translateBatchFile(translateFileRequest);
        }
    }
}
