import SdkFactory, {ClientConfiguration, CredentialsConfiguration} from "@language-weaver/lw-sdk-js";

export const getDictionaries = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);
        const dictionariesResult = await lwClient.getDictionaries(1);
        console.log(dictionariesResult.dictionaries);
    } catch (e) {
        console.log(e);
    }
}