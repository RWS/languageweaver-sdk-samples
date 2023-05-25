package com.languageweaver.sdk.samples.asynctranslateoperations.file;

import com.languageweaver.sdk.common.constants.EdgeStatuses;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.common.result.TranslationStatusResult;
import com.languageweaver.sdk.translate.edge.request.EdgeTranslateFileRequest;
import com.languageweaver.sdk.translate.edge.result.EdgeAsyncFileTranslationResult;
import com.languageweaver.sdk.translate.edge.result.EdgeStatusTranslationResult;
import com.languageweaver.sdk.translate.edge.result.EdgeTranslationFileResult;

import java.io.File;
import java.nio.file.Paths;

import static com.languageweaver.sdk.common.constants.TranslationConstants.*;

public class EdgeFileAsyncTranslateOperationsService {
    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            //create translation
            EdgeTranslateFileRequest translateFileRequest = new EdgeTranslateFileRequest()
                    .setLanguagePairId("EngFra_Generic_SRV_TNMV_8_5_x_1")
                    // provide full path to the source file
                    .setInputFile(Paths.get("java", "src", "main", "resources", "input", "input1.txt").toFile().getAbsolutePath())
                    .setOutputFile(Paths.get("java", "src", "main", "resources", "output").toFile().getAbsolutePath() + File.separator + "input1-translated.txt")
                    .setInputFormat(Format.PLAIN);

            EdgeAsyncFileTranslationResult edgeAsyncFileTranslationResult = lwClient.createFileTranslation(translateFileRequest);

            //check status
            EdgeStatusTranslationResult edgeStatusTranslationResult = lwClient.checkEdgeTranslationStatus(edgeAsyncFileTranslationResult.getTranslationId());
            System.out.println("translation state: " + edgeStatusTranslationResult.getState() + "\n" + "translation substate: " + edgeStatusTranslationResult.getSubstate());

            //retrieve translated content
            TranslationStatusResult statusResponse = null;
            int sleepTime = edgeAsyncFileTranslationResult.getInputSize() < 500 ? SMALL_INPUT_SLEEP_TIME : SLEEP_TIME;
            long startTime = System.currentTimeMillis();

            String status = EdgeStatuses.PREPARING;

            while ((status.equals(EdgeStatuses.PREPARING) || status.equals(EdgeStatuses.IN_PROGRESS)) && System.currentTimeMillis() - startTime < CHECK_STATUS_TIMEOUT) {
                statusResponse = lwClient.checkTranslationStatus(edgeAsyncFileTranslationResult.getTranslationId());
                status = statusResponse.getTranslationStatus();
                Thread.sleep(sleepTime);
            }

            EdgeTranslationFileResult edgeTranslationFileResult = lwClient.retrieveTranslatedContent(edgeAsyncFileTranslationResult);
            //handle result
        }
    }
}
