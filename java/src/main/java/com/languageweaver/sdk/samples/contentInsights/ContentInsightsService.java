package com.languageweaver.sdk.samples.contentInsights;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.contentInsights.common.api.ContentInsightsResult;
import com.languageweaver.sdk.translate.common.request.TranslateFileRequest;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContentInsightsService {
    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {

            TranslateFileRequest translateFileRequest = new TranslateFileRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    // provide full path to the source file
                    .setInputFile(Paths.get("src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                    .setOutputFile(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt")
                    .setInputFormat("plain")
                    .addDictionary("689f06cf-36ba-4903-a530-da1f7766f478")
                    .addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");

            List<String> translationIds = new ArrayList<>();
            translationIds.add(lwClient.translateFile(translateFileRequest).getTranslationId());

            ContentInsightsResult contentInsightsResult = lwClient.createContentInsightsForExistingTranslations(translationIds);
            //handle result
        }
    }

}
