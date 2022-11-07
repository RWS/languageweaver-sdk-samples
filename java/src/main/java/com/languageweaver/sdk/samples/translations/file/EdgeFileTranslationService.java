package com.languageweaver.sdk.samples.translations.file;

import com.languageweaver.sdk.common.constants.Formality;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.common.api.LinguisticOptions;
import com.languageweaver.sdk.translate.edge.request.EdgeTranslateFileRequest;
import com.languageweaver.sdk.translate.edge.result.EdgeTranslationFileResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class EdgeFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            edgeLanguageWeaverClientFileTranslation(lwClient);
            edgeLanguageWeaverClientFileTranslationWithLinguisticOptions(lwClient);
        }
    }

    private static void edgeLanguageWeaverClientFileTranslation(EdgeLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        EdgeTranslateFileRequest translateFileRequest = new EdgeTranslateFileRequest()
                .setLanguagePairId("EngFra_Generic_SRV_TNMV_8_5_x_1")
                // provide full path to the source file
                .setInputFile(Paths.get("src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt")
                .setInputFormat("text/plain")
                .addDictionary("DictionaryName1")
                .addDictionary("DictionaryName2");

        final EdgeTranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
        // handle result
    }

    private static void edgeLanguageWeaverClientFileTranslationWithLinguisticOptions(EdgeLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        EdgeTranslateFileRequest translateFileRequest = new EdgeTranslateFileRequest()
                .setLanguagePairId("EngJpn_Generic_SRV_TNMV_8_5_x_6")
                // provide full path to the source file
                .setInputFile(Paths.get("src", "main", "resources", "input", "input_linguistic_options_2.txt").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input2-linguistic-options-translated.txt")
                .setLinguisticOptions(new LinguisticOptions().setFormality(Formality.Informal))
                .setInputFormat("text/plain")
                .addDictionary("DictionaryName1")
                .addDictionary("DictionaryName2");

        final EdgeTranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
        // handle result
    }
}
