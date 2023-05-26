import {
    ClientConfiguration,
    CredentialsConfiguration,
    EdgeLanguageWeaverClient,
    EdgeTextLanguageDetectionRequest,
    Format
} from "@language-weaver/lw-sdk-js";

export const detectEdgeTextLanguage = async (clientId) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId);
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const edgeTextLanguageDetectionRequest = new EdgeTextLanguageDetectionRequest();
        edgeTextLanguageDetectionRequest.input = "A mountain is generally steeper than a hill";
        edgeTextLanguageDetectionRequest.inputFormat = Format.PLAIN;

        const edgeTextLanguageDetectionResult = await edgeLanguageWeaverClient.detectEdgeTextLanguage(edgeTextLanguageDetectionRequest);
        console.log(edgeTextLanguageDetectionResult);
    } catch (e) {
        console.log(e);
    }
}