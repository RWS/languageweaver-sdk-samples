import {ClientConfiguration, CredentialsConfiguration, EdgeLanguageWeaverClient} from "@language-weaver/lw-sdk-js";

export const getEdgeDictionaries = async clientId => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId);
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const dictionariesResult = await edgeLanguageWeaverClient.getEdgeDictionaries(1);
        console.log(dictionariesResult.dictionaries);
    } catch (e) {
        console.log(e);
    }
}