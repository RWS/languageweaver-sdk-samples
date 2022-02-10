package com.languageweaver.sdk.samples.translations.file;

import com.languageweaver.sdk.CloudLanguageWeaverClient;
import com.languageweaver.sdk.translate.request.cloud.CloudTranslateFileRequest;
import com.languageweaver.sdk.translate.result.cloud.CloudTranslationFileResult;

import java.io.File;
import java.nio.file.Paths;

public class CloudFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudTranslateFileRequest translateFileRequest = new CloudTranslateFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .setInputFormat("plain")
                    // provide full path to the source file
                    .setInputFile(Paths.get("src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                    .setOutputFile(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt")
                    .addDictionary("e929ec5e-4f9c-43b1-8b1d-e48742f396d0")
                    .addDictionary("0116ba95-8451-4cb2-ab6a-5e94334434d1");

            final CloudTranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
            // handle result
        }
    }
}
