import {
    ClientConfiguration,
    CredentialsConfiguration,
    EdgeLanguageWeaverClient,
    EdgeRetrieveFileRequest, Format
} from "@language-weaver/lw-sdk-js";

export const retrieveFileTranslationUsingEdge = async clientId => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId);
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const request = new EdgeRetrieveFileRequest();
        request.requestId = "requestId";
        request.outputFormat = Format.PLAIN;
        const translateFileResult = await edgeLanguageWeaverClient.retrieveEdgeFileTranslation(request);
        console.log(translateFileResult.fileContent);
    } catch (e) {
        console.log(e);
    }
}