package com.languageweaver.sdk.samples.translations.file;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.common.constants.InputFormat;
import com.languageweaver.sdk.common.constants.PdfConverter;
import com.languageweaver.sdk.translate.cloud.request.CloudTranslateFileRequest;
import com.languageweaver.sdk.translate.cloud.result.CloudTranslationFileResult;

import java.io.File;
import java.nio.file.Paths;

public class CloudFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudTranslateFileRequest translateFileRequest = new CloudTranslateFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .setInputFormat(InputFormat.PDF)
                    .setPdfConverter(PdfConverter.STANDARD)
                    // provide full path to the source file
                    .setInputFile(Paths.get("src", "main", "resources", "input", "input1.pdf").toFile().getAbsolutePath())
                    .setOutputFile(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.docx")
                    .addDictionary("689f06cf-36ba-4903-a530-da1f7766f478")
                    .addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");

            final CloudTranslationFileResult translateFile = lwClient.translateFile(translateFileRequest);
            // handle result
        }
    }
}
