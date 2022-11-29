package com.languageweaver.sdk.samples.translations.file.batch;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.common.constants.PdfConverter;
import com.languageweaver.sdk.translate.cloud.request.CloudTranslateBatchFileRequest;

import java.nio.file.Paths;

public class CloudBatchFileTranslationService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudTranslateBatchFileRequest translateFileRequest = new CloudTranslateBatchFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .setPdfConverter(PdfConverter.ABBYY)
                    .addDictionary("689f06cf-36ba-4903-a530-da1f7766f478")
                    .addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956")
                    // provide full path to the input and output folders
                    .setInputBatchFolderPath(Paths.get("java", "src", "main", "resources", "input").toFile().getAbsolutePath())
                    .setOutputBatchFolderPath(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath());

            lwClient.translateBatchFile(translateFileRequest);
        }
    }
}