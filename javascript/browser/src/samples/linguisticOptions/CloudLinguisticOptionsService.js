import {
    ClientConfiguration,
    CloudGetLinguisticOptionsRequest,
    CloudLanguageWeaverClient,
    CredentialsConfiguration
} from "@language-weaver/lw-sdk-js";

export const getCloudLinguisticOptions = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const request = new CloudGetLinguisticOptionsRequest();
        request.sourceLanguageId = "chi";
        request.targetLanguageId = "eng";
        request.model = "generic";
        const linguisticOptionsResult = await cloudLanguageWeaverClient.getCloudLinguisticOptions(request);
        console.log(linguisticOptionsResult.linguisticOptions);
    } catch (e) {
        console.log(e)
    }
}