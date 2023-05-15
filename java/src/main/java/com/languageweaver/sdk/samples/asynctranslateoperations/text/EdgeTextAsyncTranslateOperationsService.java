package com.languageweaver.sdk.samples.asynctranslateoperations.text;

import com.languageweaver.sdk.common.constants.Format;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.edge.request.EdgeTranslateTextRequest;
import com.languageweaver.sdk.translate.edge.result.EdgeAsyncTextTranslationResult;
import com.languageweaver.sdk.translate.edge.result.EdgeStatusTranslationResult;
import com.languageweaver.sdk.translate.edge.result.EdgeTranslationTextResult;

import java.io.IOException;

public class EdgeTextAsyncTranslateOperationsService {
    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeAsyncTextTranslationResult edgeAsyncTextTranslationResult = createTranslation(lwClient);
            checkTranslationStatus(lwClient, edgeAsyncTextTranslationResult);
            retrieveTranslatedContent(lwClient, edgeAsyncTextTranslationResult);
        }
    }

    private static EdgeAsyncTextTranslationResult createTranslation(EdgeLanguageWeaverClient lwClient) throws IOException {
        EdgeTranslateTextRequest edgeTranslateTextRequest = new EdgeTranslateTextRequest()
                .setLanguagePairId("EngFra_Generic_SRV_TNMV_8_5_x_1")
                .addInput("The weather is wonderful today!")
                .setInputFormat(Format.PLAIN);

        return lwClient.createTextTranslation(edgeTranslateTextRequest);
    }

    private static void checkTranslationStatus(EdgeLanguageWeaverClient lwClient, EdgeAsyncTextTranslationResult edgeAsyncTextTranslationResult) throws IOException, InterruptedException {
        EdgeStatusTranslationResult edgeStatusTranslationResult = lwClient.checkTranslationStatus(edgeAsyncTextTranslationResult);
        System.out.println("translation state: " + edgeStatusTranslationResult.getState() + "\n" + "translation substate: " + edgeStatusTranslationResult.getSubstate());
    }

    private static void retrieveTranslatedContent(EdgeLanguageWeaverClient lwClient, EdgeAsyncTextTranslationResult edgeAsyncTextTranslationResult) throws IOException, InterruptedException {
        EdgeTranslationTextResult edgeTranslationTextResult = lwClient.retrieveTextTranslatedContent(edgeAsyncTextTranslationResult);
        System.out.println("translated content: " + edgeTranslationTextResult.getTranslation());
    }
}
