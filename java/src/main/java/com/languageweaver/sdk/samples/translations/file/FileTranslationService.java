package com.languageweaver.sdk.samples.translations.file;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.common.constants.Formality;
import com.languageweaver.sdk.translate.common.api.LinguisticOptions;
import com.languageweaver.sdk.translate.common.request.TranslateFileRequest;
import com.languageweaver.sdk.translate.common.result.TranslationFileResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class FileTranslationService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            sdkFactoryFileTranslation(lwClient);
            sdkFactoryFileTranslationWithLinguisticOptions(lwClient);
        }
    }

    private static void sdkFactoryFileTranslation(LanguageWeaverClient lwClient) throws IOException, InterruptedException {
        TranslateFileRequest translateFileRequest = new TranslateFileRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("fra")
                .setModel("generic")
                // provide full path to the source file
                .setInputFile(Paths.get("src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt")
                .setInputFormat("plain")
                // provide list of dictionaries
                .addDictionary("dictionaryId or name");

        final TranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
        // handle result if outputFile not specified
    }

    private static void sdkFactoryFileTranslationWithLinguisticOptions(LanguageWeaverClient lwClient) throws IOException, InterruptedException {
        TranslateFileRequest translateFileRequest = new TranslateFileRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("jpn")
                .setModel("generic")
                .setInputFile(Paths.get("src", "main", "resources", "input", "input_linguistic_options_2.txt").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input2-linguistic-options-translated.txt")
                .setLinguisticOptions(new LinguisticOptions().setFormality(Formality.Informal))
                // provide full path to the source file
                .setInputFormat("plain")
                // provide list of dictionaries
                .addDictionary("dictionaryId or name");

        final TranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
        // handle result if outputFile not specified
    }
}
