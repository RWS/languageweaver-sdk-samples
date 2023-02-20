import SdkFactory, {
    ClientConfiguration,
    CredentialsConfiguration,
    RetrieveFileRequest
} from "@language-weaver/lw-sdk-js";

export const retrieveFileTranslation = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);
        const request = new RetrieveFileRequest();
        request.translationId = "translationId";
        const translateFileResult = await lwClient.retrieveFileTranslation(request);
        console.log(translateFileResult.fileContent);
    } catch (e) {
        console.log(e);
    }
}