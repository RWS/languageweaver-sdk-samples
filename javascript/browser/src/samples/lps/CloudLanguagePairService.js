import {ClientConfiguration, CloudLanguageWeaverClient, CredentialsConfiguration} from "@language-weaver/lw-sdk-js";

export const getCloudLanguagePairs = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const languagePairsResult = await cloudLanguageWeaverClient.getCloudLanguagePairs();
        console.log(languagePairsResult.languagePairs);
    } catch (e) {
        console.log(e)
    }
}