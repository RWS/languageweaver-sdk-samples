import SdkFactory, {
    ClientConfiguration,
    CredentialsConfiguration,
    GetLinguisticOptionsRequest
} from "@language-weaver/lw-sdk-js";

export const getLinguisticOptions = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);
        const request = new GetLinguisticOptionsRequest();
        request.sourceLanguageId = "chi";
        request.targetLanguageId = "eng";
        request.model = "generic";
        const linguisticOptionsResult = await lwClient.getLinguisticOptions(request);
        console.log(linguisticOptionsResult.linguisticOptions);
    } catch (e) {
        console.log(e);
    }
}