package com.languageweaver.sdk.samples.asynctranslateoperations.text;

import com.languageweaver.sdk.common.constants.EdgeStatuses;
import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.common.result.TranslationStatusResult;
import com.languageweaver.sdk.translate.edge.request.EdgeTranslateTextRequest;
import com.languageweaver.sdk.translate.edge.result.EdgeAsyncTextTranslationResult;
import com.languageweaver.sdk.translate.edge.result.EdgeStatusTranslationResult;
import com.languageweaver.sdk.translate.edge.result.EdgeTranslationTextResult;

import static com.languageweaver.sdk.common.constants.TranslationConstants.*;

public class EdgeTextAsyncTranslateOperationsService {
    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            //create translation
            EdgeTranslateTextRequest edgeTranslateTextRequest = new EdgeTranslateTextRequest()
                    .setLanguagePairId("EngFra_Generic_SRV_TNMV_8_5_x_1")
                    .addInput("The weather is wonderful today!")
                    .setInputFormat(Format.PLAIN);

            EdgeAsyncTextTranslationResult edgeAsyncTextTranslationResult = lwClient.createTextTranslation(edgeTranslateTextRequest);

            //check status
            EdgeStatusTranslationResult edgeStatusTranslationResult = lwClient.checkEdgeTranslationStatus(edgeAsyncTextTranslationResult.getTranslationId());
            System.out.println("translation state: " + edgeStatusTranslationResult.getState() + "\n" + "translation substate: " + edgeStatusTranslationResult.getSubstate());

            //retrieve translated content
            TranslationStatusResult statusResponse = null;
            int sleepTime = edgeAsyncTextTranslationResult.getInputSize() < 500 ? SMALL_INPUT_SLEEP_TIME : SLEEP_TIME;
            long startTime = System.currentTimeMillis();

            String status = EdgeStatuses.PREPARING;

            while ((status.equals(EdgeStatuses.PREPARING) || status.equals(EdgeStatuses.IN_PROGRESS)) && System.currentTimeMillis() - startTime < CHECK_STATUS_TIMEOUT) {
                statusResponse = lwClient.checkTranslationStatus(edgeAsyncTextTranslationResult.getTranslationId());
                status = statusResponse.getTranslationStatus();
                Thread.sleep(sleepTime);
            }

            EdgeTranslationTextResult edgeTranslationTextResult = lwClient.retrieveTranslatedContent(edgeAsyncTextTranslationResult);
            System.out.println("translated content: " + edgeTranslationTextResult.getTranslation());
        }
    }
}
