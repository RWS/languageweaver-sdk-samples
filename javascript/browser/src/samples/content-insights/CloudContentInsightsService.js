import {
    ClientConfiguration,
    CloudContentInsightsRequest,
    CloudLanguageWeaverClient,
    ContentInsightsForTranslationRequest,
    CredentialsConfiguration
} from "@language-weaver/lw-sdk-js";
import {file1} from "../../samples-utils";

export const getContentInsightsUsingCloud = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const contentInsightsRequest = new CloudContentInsightsRequest();
        contentInsightsRequest.sourceLanguage = "eng";
        contentInsightsRequest.files = file1;

        const contentInsightsResult = await cloudLanguageWeaverClient.getCloudContentInsights(contentInsightsRequest);
        console.log(contentInsightsResult);
    } catch (e) {
        console.log(e);
    }
}

export const getContentInsightsForTranslationsUsingCloud = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const contentInsightsForTranslationsRequest = new ContentInsightsForTranslationRequest();
        contentInsightsForTranslationsRequest.addTranslationId("translationId");

        const contentInsightsResult = await cloudLanguageWeaverClient.getCloudContentInsightsForTranslations(contentInsightsForTranslationsRequest);
        console.log(contentInsightsResult);
    } catch (e) {
        console.log(e);
    }
}