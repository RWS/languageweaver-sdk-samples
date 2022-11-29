package com.languageweaver.sdk.samples.contentInsights;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.contentInsights.cloud.request.CloudContentInsightsRequest;
import com.languageweaver.sdk.contentInsights.cloud.request.CloudGetContentInsightsForTranslationsRequest;
import com.languageweaver.sdk.contentInsights.cloud.result.CloudContentInsightsResult;
import com.languageweaver.sdk.translate.cloud.request.CloudTranslateFileRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class CloudContentInsightsService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            createContentInsights(lwClient);
            createContentInsightsForExistingTranslations(lwClient);
        }
    }

    private static void createContentInsights(CloudLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        CloudContentInsightsRequest contentInsightsRequest = new CloudContentInsightsRequest()
                .setSourceLanguage("eng")
                .setFile(Paths.get("java", "src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath());

        final CloudContentInsightsResult cloudContentInsightsResult = lwClient.getContentInsights(contentInsightsRequest);
        //handle result
    }

    private static void createContentInsightsForExistingTranslations(CloudLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        CloudTranslateFileRequest translateFileRequest = new CloudTranslateFileRequest()
                .setSourceLanguageId("eng")
                .setTargetLanguageId("fra")
                .setModel("generic")
                .setInputFormat(Format.PLAIN)
                // provide full path to the source file
                .setInputFile(Paths.get("java", "src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt")
                .addDictionary("689f06cf-36ba-4903-a530-da1f7766f478")
                .addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");

        CloudGetContentInsightsForTranslationsRequest contentInsightsForTranslationsRequest = new CloudGetContentInsightsForTranslationsRequest()
                .addTranslationId(lwClient.translateFile(translateFileRequest).getTranslationId());

        final CloudContentInsightsResult cloudContentInsightsResult = lwClient.getContentInsightsForTranslations(contentInsightsForTranslationsRequest);
        //handle result
    }
}
