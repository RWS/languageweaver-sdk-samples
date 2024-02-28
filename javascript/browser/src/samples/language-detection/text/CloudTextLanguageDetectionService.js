import {
    ClientConfiguration,
    CloudLanguageWeaverClient,
    CloudTextLanguageDetectionRequest,
    CredentialsConfiguration,
    Format
} from "@language-weaver/lw-sdk-js";

export const detectCloudTextLanguage = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const cloudTextLanguageDetectionRequest = new CloudTextLanguageDetectionRequest();
        cloudTextLanguageDetectionRequest.input = "A mountain is generally steeper than a hill";
        cloudTextLanguageDetectionRequest.inputFormat = Format.PLAIN;

        const cloudTextLanguageDetectionResult = await cloudLanguageWeaverClient.detectCloudTextLanguage(cloudTextLanguageDetectionRequest);
        console.log(cloudTextLanguageDetectionResult);
    } catch (e) {
        console.log(e);
    }
}