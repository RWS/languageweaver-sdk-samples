import {
    ClientConfiguration,
    CredentialsConfiguration,
    EdgeContentInsightsForTranslationRequest,
    EdgeLanguageWeaverClient
} from "@language-weaver/lw-sdk-js";

export const getContentInsightsForTranslationsUsingEdge = async (clientId) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId);
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const contentInsightsForTranslationsRequest = new EdgeContentInsightsForTranslationRequest();
        contentInsightsForTranslationsRequest.translationId = "translationId";

        const contentInsightsResult = await edgeLanguageWeaverClient.getEdgeContentInsightsResultForTranslation(contentInsightsForTranslationsRequest);
        console.log(contentInsightsResult);
    } catch (e) {
        console.log(e);
    }
}
