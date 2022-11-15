import {
    ClientConfiguration,
    CloudLanguageWeaverClient,
    CloudRetrieveFileRequest,
    CredentialsConfiguration
} from "@language-weaver/lw-sdk-js";

export const retrieveFileTranslationUsingCloud = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const request = new CloudRetrieveFileRequest();
        request.requestId = "requestId";
        const translateFileResult = await cloudLanguageWeaverClient.retrieveCloudFileTranslation(request);
        console.log(translateFileResult.fileContent);
    } catch (e) {
        console.log(e);
    }
}