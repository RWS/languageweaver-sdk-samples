import SdkFactory, {
    ClientConfiguration,
    ContentInsightsRequest,
    CredentialsConfiguration
} from "@language-weaver/lw-sdk-js";

export const getContentInsightsForTranslations = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);

        const contentInsightsRequest = new ContentInsightsRequest();
        contentInsightsRequest.addTranslationId("translationId");

        const contentInsightsResult = await lwClient.getContentInsightsForTranslations(contentInsightsRequest);
        console.log(contentInsightsResult);
    } catch (e) {
        console.log(e);
    }
}