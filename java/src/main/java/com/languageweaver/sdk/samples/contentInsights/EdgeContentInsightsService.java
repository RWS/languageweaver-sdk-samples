package com.languageweaver.sdk.samples.contentInsights;

import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.contentInsights.edge.request.EdgeContentInsightsRequest;
import com.languageweaver.sdk.contentInsights.edge.response.EdgeContentInsightsResult;
import com.languageweaver.sdk.translate.edge.request.EdgeTranslateFileRequest;

import java.io.File;
import java.nio.file.Paths;

public class EdgeContentInsightsService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeTranslateFileRequest translateFileRequest = new EdgeTranslateFileRequest()
                    .setLanguagePairId("EngFra_Generic_SRV_TNMV_8_5_x_1")
                    // provide full path to the source file
                    .setInputFile(Paths.get("src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                    .setOutputFile(Paths.get("src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt")
                    .setInputFormat(Format.PLAIN)
                    .addDictionary("DictionaryName1")
                    .addDictionary("DictionaryName2");

            EdgeContentInsightsRequest edgeContentInsightsRequest = new EdgeContentInsightsRequest()
                    .addTranslationId(lwClient.translateFile(translateFileRequest).getTranslationId());

            final EdgeContentInsightsResult edgeContentInsightsResult = lwClient.getContentInsightsForTranslations(edgeContentInsightsRequest);
            // handle result
        }
    }
}
