package com.languageweaver.sdk.samples.translations.file;

import com.languageweaver.sdk.LanguageWeaverClient;
import com.languageweaver.sdk.SdkFactory;
import com.languageweaver.sdk.configurations.ClientConfiguration;
import com.languageweaver.sdk.translate.request.TranslateFileRequest;
import com.languageweaver.sdk.translate.result.TranslationFileResult;

import java.io.File;
import java.nio.file.Paths;

public class FileTranslationService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            TranslateFileRequest translateFileRequest = new TranslateFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    // provide list of dictionaries
//                  .addDictionary("689f06cf-36ba-4903-a530-da1f7766f478")
//                  .addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");
                    .setInputFormat("plain")
                    // provide full path to the source file
                    .setInputFile(Paths.get("java", "src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                    .setOutputFile(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt");

            final TranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
            // handle result if outputFile not specified
        }
    }
}
