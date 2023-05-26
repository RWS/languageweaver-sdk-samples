import SdkFactory, {
    ClientConfiguration,
    CredentialsConfiguration,
    FileLanguageDetectionRequest,
    Format
} from "@language-weaver/lw-sdk-js";
import {file1} from "../../../samples-utils";

export const detectFileLanguage = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);
        const fileLanguageDetectionRequest = new FileLanguageDetectionRequest();
        fileLanguageDetectionRequest.inputFile = file1;
        fileLanguageDetectionRequest.inputFormat = Format.PLAIN;

        const fileLanguageDetectionResult = await lwClient.detectFileLanguage(fileLanguageDetectionRequest);
        console.log(fileLanguageDetectionResult);
    } catch (e) {
        console.log(e);
    }
}