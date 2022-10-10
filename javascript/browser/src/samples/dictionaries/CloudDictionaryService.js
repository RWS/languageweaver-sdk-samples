import {ClientConfiguration, CloudLanguageWeaverClient, CredentialsConfiguration} from "@language-weaver/lw-sdk-js";

export const getCloudDictionaries = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const dictionariesResult = await cloudLanguageWeaverClient.getCloudDictionaries(1);
        console.log(dictionariesResult.dictionaries);
    } catch (e) {
        console.log(e);
    }
}