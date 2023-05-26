import {
    ClientConfiguration,
    CloudFileLanguageDetectionRequest,
    CloudLanguageWeaverClient, CredentialsConfiguration,
    Format
} from "@language-weaver/lw-sdk-js";
import {file1} from "../../../samples-utils";

export const detectCloudFileLanguage = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const cloudFileLanguageDetectionRequest = new CloudFileLanguageDetectionRequest();
        cloudFileLanguageDetectionRequest.inputFile = file1;
        cloudFileLanguageDetectionRequest.inputFormat = Format.PLAIN;

        const cloudFileLanguageDetectionResult = await cloudLanguageWeaverClient.detectCloudFileLanguage(cloudFileLanguageDetectionRequest);
        console.log(cloudFileLanguageDetectionResult);
    } catch (e) {
        console.log(e);
    }
}