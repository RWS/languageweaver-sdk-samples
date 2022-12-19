import {
    ClientConfiguration,
    CredentialsConfiguration,
    EdgeGetLinguisticOptionsRequest,
    EdgeLanguageWeaverClient
} from "@language-weaver/lw-sdk-js";

export const getEdgeLinguisticOptions = async clientId => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId);
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const request = new EdgeGetLinguisticOptionsRequest();
        request.sourceLanguageId = "chi";
        request.targetLanguageId = "eng";
        request.model = "Generic";
        // request.platform = "SRV";
        // request.technology = "TNMV";
        const linguisticOptionsResult = await edgeLanguageWeaverClient.getEdgeLinguisticOptions(request);
        console.log(linguisticOptionsResult.linguisticOptions);
    } catch (e) {
        console.log(e);
    }
}