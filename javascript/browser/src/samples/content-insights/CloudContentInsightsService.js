import {
    ClientConfiguration,
    CloudContentInsightsRequest,
    CloudFileContentInsightsRequest,
    CloudLanguageWeaverClient,
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
        const cloudFileContentInsightsRequest = new CloudFileContentInsightsRequest();
        cloudFileContentInsightsRequest.sourceLanguage = "eng";
        cloudFileContentInsightsRequest.files = file1;

        const contentInsightsResult = await cloudLanguageWeaverClient.getCloudContentInsights(cloudFileContentInsightsRequest);
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
        const cloudContentInsightsRequest = new CloudContentInsightsRequest();
        cloudContentInsightsRequest.addTranslationId("translationId");

        const contentInsightsResult = await cloudLanguageWeaverClient.getCloudContentInsightsForTranslations(cloudContentInsightsRequest);
        console.log(contentInsightsResult);
    } catch (e) {
        console.log(e);
    }
}