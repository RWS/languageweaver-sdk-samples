import SdkFactory, {
    ClientConfiguration,
    CredentialsConfiguration,
    Format,
    TextLanguageDetectionRequest,
} from "@language-weaver/lw-sdk-js";

export const detectTextLanguage = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);
        const textLanguageDetectionRequest = new TextLanguageDetectionRequest();
        textLanguageDetectionRequest.input = "A mountain is generally steeper than a hill";
        textLanguageDetectionRequest.inputFormat = Format.PLAIN;

        const textLanguageDetectionResult = await lwClient.detectTextLanguage(textLanguageDetectionRequest);
        console.log(textLanguageDetectionResult);
    } catch (e) {
        console.log(e);
    }
}