package com.languageweaver.sdk.samples.translations.file;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.common.constants.PdfConverter;
import com.languageweaver.sdk.translate.common.request.TranslateFileRequest;
import com.languageweaver.sdk.translate.common.result.TranslationFileResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class FileTranslationService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            translateFile(lwClient);
            translateFileWithPdfConverter(lwClient);
        }
    }

    private static void translateFile(LanguageWeaverClient lwClient) throws IOException, InterruptedException {
        TranslateFileRequest translateFileRequest = new TranslateFileRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("fra")
                .setModel("generic")
                // provide full path to the source file
                .setInputFile(Paths.get("java", "src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt")
                .setInputFormat(Format.PLAIN)
                // provide list of dictionaries
                .addDictionary("dictionaryId or name");

        final TranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
        // handle result if outputFile not specified
    }

    private static void translateFileWithPdfConverter(LanguageWeaverClient lwClient) throws IOException, InterruptedException {
        TranslateFileRequest translateFileRequest = new TranslateFileRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("fra")
                .setModel("generic")
                // provide full path to the source file
                .setInputFile(Paths.get("java", "src", "main", "resources", "input", "input1.pdf").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.docx")
                .setInputFormat(Format.PDF)
                .setPdfConverter(PdfConverter.ABBYY)
                // provide list of dictionaries
                .addDictionary("dictionaryId or name");

        final TranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
        // handle result if outputFile not specified
    }

}
