package com.languageweaver.sdk.samples.translations.file.batch;

import com.languageweaver.sdk.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.request.edge.EdgeTranslateBatchFileRequest;

import java.nio.file.Paths;

public class EdgeBatchFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeTranslateBatchFileRequest translateFileRequest = new EdgeTranslateBatchFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    // provide full path to the input and output folders
                    .setInputBatchFolderPath(Paths.get("java", "src", "main", "resources", "input").toFile().getAbsolutePath())
                    .setOutputBatchFolderPath(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath())
                    .addDictionary("DictionaryName1")
                    .addDictionary("DictionaryName2");

            lwClient.translateBatchFile(translateFileRequest);
        }
    }
}