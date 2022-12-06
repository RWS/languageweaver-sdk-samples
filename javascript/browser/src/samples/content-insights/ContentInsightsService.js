import SdkFactory, {
    ClientConfiguration,
    ContentInsightsForTranslationRequest,
    CredentialsConfiguration
} from "@language-weaver/lw-sdk-js";

export const getContentInsightsForTranslations = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);

        const contentInsightsForTranslationsRequest = new ContentInsightsForTranslationRequest();
        contentInsightsForTranslationsRequest.addTranslationId("translationId");

        const contentInsightsResult = await lwClient.getContentInsightsForTranslations(contentInsightsForTranslationsRequest);
        console.log(contentInsightsResult);
    } catch (e) {
        console.log(e);
    }
}