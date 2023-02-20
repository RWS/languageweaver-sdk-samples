package com.languageweaver.sdk.samples.translations.file.batch;

import com.languageweaver.sdk.common.constants.PdfConverter;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.edge.request.EdgeTranslateBatchFileRequest;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class EdgeBatchFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            translateBatchFile(lwClient);
            translateBatchFileWithLinguisticOptions(lwClient);
        }
    }

    private static void translateBatchFile(EdgeLanguageWeaverClient lwClient) throws ExecutionException, InterruptedException, IOException {
        EdgeTranslateBatchFileRequest translateFileRequest = new EdgeTranslateBatchFileRequest()
                .setLanguagePairId("EngFra_Generic_SRV_TNMV_8_5_x_1")
                // provide full path to the input and output folders
                .setInputBatchFolderPath(Paths.get("java", "src", "main", "resources", "input").toFile().getAbsolutePath())
                .setOutputBatchFolderPath(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath())
                .setPdfConverter(PdfConverter.STANDARD)
                .addDictionary("DictionaryName1")
                .addDictionary("DictionaryName2");

        lwClient.translateBatchFile(translateFileRequest);
    }

    private static void translateBatchFileWithLinguisticOptions(EdgeLanguageWeaverClient lwClient) throws ExecutionException, InterruptedException, IOException {
        Map<String, String> linguisticOptions = new HashMap<>();
        linguisticOptions.put("formality", "Informal");
        EdgeTranslateBatchFileRequest translateFileRequest = new EdgeTranslateBatchFileRequest()
                .setLanguagePairId("EngJpn_Generic_SRV_TNMV_8_5_x_6")
                // provide full path to the input and output folders
                .setInputBatchFolderPath(Paths.get("java", "src", "main", "resources", "input").toFile().getAbsolutePath())
                .setOutputBatchFolderPath(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath())
                .setLinguisticOptions(linguisticOptions)
                .addDictionary("DictionaryName1")
                .addDictionary("DictionaryName2");

        lwClient.translateBatchFile(translateFileRequest);
    }
}