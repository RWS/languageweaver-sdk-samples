package com.languageweaver.sdk.samples.translations.file;

import com.languageweaver.sdk.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.request.edge.EdgeTranslateFileRequest;
import com.languageweaver.sdk.translate.result.edge.EdgeTranslationFileResult;

import java.io.File;
import java.nio.file.Paths;

public class EdgeFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeTranslateFileRequest translateFileRequest = new EdgeTranslateFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    // provide full path to the source file
                    .setInputFile(Paths.get("src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                    .setOutputFile(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt")
                    .setInputFormat("text/plain")
                    .addDictionary("DictionaryName1")
                    .addDictionary("DictionaryName2");

            final EdgeTranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
            // handle result
        }
    }
}
