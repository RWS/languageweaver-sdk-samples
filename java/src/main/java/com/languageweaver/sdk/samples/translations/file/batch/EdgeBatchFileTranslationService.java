package com.languageweaver.sdk.samples.translations.file.batch;

import com.languageweaver.sdk.common.constants.Formality;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.common.api.LinguisticOptions;
import com.languageweaver.sdk.translate.edge.request.EdgeTranslateBatchFileRequest;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;

public class EdgeBatchFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            edgeLanguageWeaverClientBatchFileTranslation(lwClient);
            edgeLanguageWeaverClientBatchFileTranslationWithLinguisticOptions(lwClient);
        }
    }

    private static void edgeLanguageWeaverClientBatchFileTranslation(EdgeLanguageWeaverClient lwClient) throws ExecutionException, InterruptedException, IOException {
        EdgeTranslateBatchFileRequest translateFileRequest = new EdgeTranslateBatchFileRequest()
                .setLanguagePairId("EngFra_Generic_SRV_TNMV_8_5_x_1")
                // provide full path to the input and output folders
                .setInputBatchFolderPath(Paths.get("src", "main", "resources", "input").toFile().getAbsolutePath())
                .setOutputBatchFolderPath(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath())
                .addDictionary("DictionaryName1")
                .addDictionary("DictionaryName2");

        lwClient.translateBatchFile(translateFileRequest);
    }

    private static void edgeLanguageWeaverClientBatchFileTranslationWithLinguisticOptions(EdgeLanguageWeaverClient lwClient) throws ExecutionException, InterruptedException, IOException {
        EdgeTranslateBatchFileRequest translateFileRequest = new EdgeTranslateBatchFileRequest()
                .setLanguagePairId("EngJpn_Generic_SRV_TNMV_8_5_x_6")
                .setLinguisticOptions(new LinguisticOptions().setFormality(Formality.Formal))
                // provide full path to the input and output folders
                .setInputBatchFolderPath(Paths.get("src", "main", "resources", "input").toFile().getAbsolutePath())
                .setOutputBatchFolderPath(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath())
                .addDictionary("DictionaryName1")
                .addDictionary("DictionaryName2");

        lwClient.translateBatchFile(translateFileRequest);
    }
}