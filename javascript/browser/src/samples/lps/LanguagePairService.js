import SdkFactory, {ClientConfiguration, CredentialsConfiguration} from "@language-weaver/lw-sdk-js";

export const getLanguagePairs = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);
        const languagePairsResult = await lwClient.getLanguagePairs();
        console.log(languagePairsResult.languagePairs);
    } catch (e) {
        console.log(e);
    }
}