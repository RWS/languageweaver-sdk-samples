package com.languageweaver.sdk.samples.asynctranslations.file;

import com.languageweaver.sdk.common.constants.EdgeStatuses;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.common.result.TranslationStatusResult;
import com.languageweaver.sdk.translate.edge.request.EdgeTranslateFileRequest;
import com.languageweaver.sdk.translate.edge.result.EdgeAsyncFileTranslationResult;
import com.languageweaver.sdk.translate.edge.result.EdgeTranslationFileResult;
import com.languageweaver.sdk.translate.edge.result.EdgeTranslationStatusResult;

import java.io.File;
import java.nio.file.Paths;

import static com.languageweaver.sdk.common.constants.TranslationConstants.CHECK_STATUS_TIMEOUT;

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
            EdgeTranslationStatusResult edgeStatusTranslationResult = lwClient.checkEdgeTranslationStatus(edgeAsyncFileTranslationResult.getRequestId());
            System.out.println("translation state: " + edgeStatusTranslationResult.getState() + "\n" + "translation substate: " + edgeStatusTranslationResult.getSubstate());

            //retrieve translated content
            TranslationStatusResult statusResponse;
            int sleepTime = edgeAsyncFileTranslationResult.getOptimalStatusCheckDelay();
            long startTime = System.currentTimeMillis();

            String status = EdgeStatuses.PREPARING;

            while ((status.equals(EdgeStatuses.PREPARING) || status.equals(EdgeStatuses.IN_PROGRESS)) && System.currentTimeMillis() - startTime < CHECK_STATUS_TIMEOUT) {
                statusResponse = lwClient.checkTranslationStatus(edgeAsyncFileTranslationResult.getRequestId());
                status = statusResponse.getTranslationStatus();
                Thread.sleep(sleepTime);
            }

            EdgeTranslationFileResult edgeTranslationFileResultWithOutputFile = lwClient.retrieveTranslatedContent(edgeAsyncFileTranslationResult, translateFileRequest.getOutputFile());
            //handle result

            EdgeTranslationFileResult edgeTranslationFileResultWithoutOutputFile = lwClient.retrieveTranslatedContent(edgeAsyncFileTranslationResult);
            //handle result
        }
    }
}
