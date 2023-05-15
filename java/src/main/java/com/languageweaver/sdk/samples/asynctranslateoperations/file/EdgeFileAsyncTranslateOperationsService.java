package com.languageweaver.sdk.samples.asynctranslateoperations.file;

import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.edge.request.EdgeTranslateFileRequest;
import com.languageweaver.sdk.translate.edge.result.EdgeAsyncFileTranslationResult;
import com.languageweaver.sdk.translate.edge.result.EdgeStatusTranslationResult;
import com.languageweaver.sdk.translate.edge.result.EdgeTranslationFileResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class EdgeFileAsyncTranslateOperationsService {
    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeAsyncFileTranslationResult edgeAsyncTextTranslationResult = createTranslation(lwClient);
            checkTranslationStatus(lwClient, edgeAsyncTextTranslationResult);
            retrieveTranslatedContent(lwClient, edgeAsyncTextTranslationResult);
        }
    }

    private static EdgeAsyncFileTranslationResult createTranslation(EdgeLanguageWeaverClient lwClient) throws IOException {
        EdgeTranslateFileRequest translateFileRequest = new EdgeTranslateFileRequest()
                .setLanguagePairId("EngFra_Generic_SRV_TNMV_8_5_x_1")
                // provide full path to the source file
                .setInputFile(Paths.get("java", "src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                .setOutputFile(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt")
                .setInputFormat(Format.PLAIN);

        return lwClient.createFileTranslation(translateFileRequest);
    }

    private static void checkTranslationStatus(EdgeLanguageWeaverClient lwClient, EdgeAsyncFileTranslationResult edgeAsyncTextTranslationResult) throws IOException, InterruptedException {
        EdgeStatusTranslationResult edgeStatusTranslationResult = lwClient.checkTranslationStatus(edgeAsyncTextTranslationResult);
        System.out.println("translation state: " + edgeStatusTranslationResult.getState() + "\n" + "translation substate: " + edgeStatusTranslationResult.getSubstate());
    }

    private static void retrieveTranslatedContent(EdgeLanguageWeaverClient lwClient, EdgeAsyncFileTranslationResult edgeAsyncTextTranslationResult) throws IOException, InterruptedException {
        EdgeTranslationFileResult edgeTranslationTextResult = lwClient.retrieveFileTranslatedContent(edgeAsyncTextTranslationResult);
        // handle result
    }
}
