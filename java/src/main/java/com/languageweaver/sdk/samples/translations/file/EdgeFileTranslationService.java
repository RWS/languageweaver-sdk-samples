package com.languageweaver.sdk.samples.translations.file;

import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.common.constants.PdfConverter;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.edge.request.EdgeTranslateFileRequest;
import com.languageweaver.sdk.translate.edge.result.EdgeTranslationFileResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class EdgeFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            translateFile(lwClient);
            translateFileWithPdfConverter(lwClient);
            translateFileWithLinguisticOptions(lwClient);
        }
    }

    private static void translateFile(EdgeLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        EdgeTranslateFileRequest translateFileRequest = new EdgeTranslateFileRequest()
                .setLanguagePairId("EngFra_Generic_SRV_TNMV_8_5_x_1")
                // provide full path to the source file
                .setInputFile(Paths.get("java", "src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt")
                .setInputFormat(Format.PLAIN)
                .addDictionary("DictionaryName1")
                .addDictionary("DictionaryName2");

        final EdgeTranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
        // handle result
    }

    private static void translateFileWithPdfConverter(EdgeLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        EdgeTranslateFileRequest translateFileRequest = new EdgeTranslateFileRequest()
                .setLanguagePairId("EngFra_Generic_SRV_TNMV_8_5_x_1")
                // provide full path to the source file
                .setInputFile(Paths.get("java", "src", "main", "resources", "input", "input1.pdf").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.docx")
                .setInputFormat(Format.PDF)
                .setPdfConverter(PdfConverter.STANDARD)
                .addDictionary("DictionaryName1")
                .addDictionary("DictionaryName2");

        final EdgeTranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
        // handle result
    }

    private static void translateFileWithLinguisticOptions(EdgeLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        Map<String, String> linguisticOptions = new HashMap<>();
        linguisticOptions.put("formality", "Informal");
        EdgeTranslateFileRequest translateFileRequest = new EdgeTranslateFileRequest()
                .setLanguagePairId("EngJpn_Generic_SRV_TNMV_8_5_x_6")
                // provide full path to the source file
                .setInputFile(Paths.get("java", "src", "main", "resources", "input", "input4.txt").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input4-translated.txt")
                .setLinguisticOptions(linguisticOptions)
                .setInputFormat(Format.PLAIN)
                .addDictionary("DictionaryName1")
                .addDictionary("DictionaryName2");

        final EdgeTranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
        // handle result
    }
}
