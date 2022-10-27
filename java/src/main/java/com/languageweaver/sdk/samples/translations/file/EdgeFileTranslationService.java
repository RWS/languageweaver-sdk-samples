package com.languageweaver.sdk.samples.translations.file;

import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.common.constants.PdfConverter;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.edge.request.EdgeTranslateFileRequest;
import com.languageweaver.sdk.translate.edge.result.EdgeTranslationFileResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class EdgeFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            edgeLanguageWeaverClientTranslateFile(lwClient);
            edgeLanguageWeaverClientTranslateFileWithPdfConverter(lwClient);
        }
    }

    private static void edgeLanguageWeaverClientTranslateFileWithPdfConverter(EdgeLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        EdgeTranslateFileRequest translateFileRequest = new EdgeTranslateFileRequest()
                .setLanguagePairId("EngFra_Generic_SRV_TNMV_8_5_x_1")
                // provide full path to the source file
                .setInputFile(Paths.get("src", "main", "resources", "input", "input1.pdf").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.docx")
                .setInputFormat(Format.PDF)
                .setPdfConverter(PdfConverter.STANDARD)
                .addDictionary("DictionaryName1")
                .addDictionary("DictionaryName2");

        final EdgeTranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
        // handle result
    }

    private static void edgeLanguageWeaverClientTranslateFile(EdgeLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        EdgeTranslateFileRequest translateFileRequest = new EdgeTranslateFileRequest()
                .setLanguagePairId("EngFra_Generic_SRV_TNMV_8_5_x_1")
                // provide full path to the source file
                .setInputFile(Paths.get("src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt")
                .setInputFormat(Format.PLAIN)
                .addDictionary("DictionaryName1")
                .addDictionary("DictionaryName2");

        final EdgeTranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
        // handle result
    }
}
