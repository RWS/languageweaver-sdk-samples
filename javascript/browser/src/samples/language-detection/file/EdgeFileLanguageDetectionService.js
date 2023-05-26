import {
    ClientConfiguration,
    CredentialsConfiguration,
    EdgeFileLanguageDetectionRequest,
    EdgeLanguageWeaverClient,
    Format
} from "@language-weaver/lw-sdk-js";
import {file1} from "../../../samples-utils";

export const detectEdgeFileLanguage = async (clientId) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId);
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const edgeFileLanguageDetectionRequest = new EdgeFileLanguageDetectionRequest();
        edgeFileLanguageDetectionRequest.inputFile = file1;
        edgeFileLanguageDetectionRequest.inputFormat = Format.PLAIN;

        const edgeFileLanguageDetectionResult = await edgeLanguageWeaverClient.detectEdgeFileLanguage(edgeFileLanguageDetectionRequest);
        console.log(edgeFileLanguageDetectionResult);
    } catch (e) {
        console.log(e);
    }
}