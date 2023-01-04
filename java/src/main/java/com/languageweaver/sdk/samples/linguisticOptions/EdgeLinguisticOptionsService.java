package com.languageweaver.sdk.samples.linguisticOptions;

import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.edge.request.linguisticOptions.EdgeGetLinguisticOptionsRequest;
import com.languageweaver.sdk.translate.edge.result.linguisticOptions.EdgeLinguisticOptionsResult;

public class EdgeLinguisticOptionsService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeGetLinguisticOptionsRequest edgeGetLinguisticOptionsRequest = new EdgeGetLinguisticOptionsRequest()
                    .setSourceLanguageId("chi")
                    .setTargetLanguageId("eng")
                    .setModel("Generic");
//                   .setPlatform("SRV")
//                   .setTechnology("TNMV")

            final EdgeLinguisticOptionsResult edgeLinguisticOptionsResult = lwClient.getEdgeLinguisticOptions(edgeGetLinguisticOptionsRequest);
            // handle result
        }
    }

}
