import {
    ClientConfiguration,
    CredentialsConfiguration,
    EdgeContentInsightsRequest,
    EdgeLanguageWeaverClient
} from "@language-weaver/lw-sdk-js";

export const getContentInsightsForTranslationsUsingEdge = async (clientId) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId);
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const edgeContentInsightsRequest = new EdgeContentInsightsRequest();
        edgeContentInsightsRequest.translationId = "translationId";

        const contentInsightsResult = await edgeLanguageWeaverClient.getEdgeContentInsightsResultForTranslation(edgeContentInsightsRequest);
        console.log(contentInsightsResult);
    } catch (e) {
        console.log(e);
    }
}
