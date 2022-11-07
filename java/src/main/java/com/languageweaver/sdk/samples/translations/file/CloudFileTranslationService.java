package com.languageweaver.sdk.samples.translations.file;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.common.constants.Spelling;
import com.languageweaver.sdk.translate.cloud.request.CloudTranslateFileRequest;
import com.languageweaver.sdk.translate.cloud.result.CloudTranslationFileResult;
import com.languageweaver.sdk.translate.common.api.LinguisticOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class CloudFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            cloudLanguageWeaverClientFileTranslation(lwClient);
            cloudLanguageWeaverClientFileTranslationWithLinguisticOptions(lwClient);
        }
    }

    private static void cloudLanguageWeaverClientFileTranslation(CloudLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        CloudTranslateFileRequest translateFileRequest = new CloudTranslateFileRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("fra")
                .setModel("generic")
                .setInputFormat("plain")
                // provide full path to the source file
                .setInputFile(Paths.get("src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt")
                .addDictionary("689f06cf-36ba-4903-a530-da1f7766f478")
                .addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");

        final CloudTranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
        // handle result
    }

    private static void cloudLanguageWeaverClientFileTranslationWithLinguisticOptions(CloudLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        CloudTranslateFileRequest translateFileRequest = new CloudTranslateFileRequest()
                .setSourceLanguageId("fra")
                .setTargetLanguageId("eng")
                .setModel("generic")
                .setInputFormat("plain")
                .setLinguisticOptions(new LinguisticOptions().setSpelling(Spelling.UK))
                // provide full path to the source file
                .setInputFile(Paths.get("src", "main", "resources", "input", "input_linguistic_options_1.txt").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-linguistic-options-translated.txt")
                .addDictionary("689f06cf-36ba-4903-a530-da1f7766f478")
                .addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");

        final CloudTranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
        // handle result
    }
}
