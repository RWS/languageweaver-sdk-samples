package com.languageweaver.sdk.samples.translations.file.batch;

import com.languageweaver.sdk.common.constants.PdfConverter;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.edge.request.EdgeTranslateBatchFileRequest;

import java.nio.file.Paths;

public class EdgeBatchFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
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
    }
}