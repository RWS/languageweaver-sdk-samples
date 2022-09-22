import {ClientConfiguration, CredentialsConfiguration, EdgeLanguageWeaverClient} from "@language-weaver/lw-sdk-js";

export const getEdgeLanguagePairs = async clientId => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId);
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const languagePairsResult = await edgeLanguageWeaverClient.getEdgeLanguagePairs();
        console.log(languagePairsResult.languagePairs);
    } catch (e) {
        console.log(e);
    }
}