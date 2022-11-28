package com.languageweaver.sdk.samples.contentInsights;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.contentInsights.cloud.request.CloudCreateContentInsightsRequest;
import com.languageweaver.sdk.contentInsights.cloud.result.CloudCreateContentInsightsResult;
import com.languageweaver.sdk.translate.cloud.request.CloudTranslateFileRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CloudContentInsightsService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            createContentInsights(lwClient);
            createContentInsightsForExistingTranslations(lwClient);
        }
    }

    private static void createContentInsightsForExistingTranslations(CloudLanguageWeaverClient lwClient) throws IOException, InterruptedException {
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

        List<String> translationIds = new ArrayList<>();
        translationIds.add(lwClient.translateFile(translateFileRequest).getTranslationId());

        final CloudCreateContentInsightsResult cloudContentInsightsResult = lwClient.createCloudContentInsightsForExistingTranslations(translationIds);
        //handle result
    }

    private static void createContentInsights(CloudLanguageWeaverClient lwClient) throws IOException, InterruptedException {
        CloudCreateContentInsightsRequest contentInsightsRequest = new CloudCreateContentInsightsRequest()
                .setSourceLanguage("eng")
                .setFile(Paths.get("src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath());

        final CloudCreateContentInsightsResult cloudContentInsightsResult = lwClient.createContentInsights(contentInsightsRequest);

        //handle result
    }
}
