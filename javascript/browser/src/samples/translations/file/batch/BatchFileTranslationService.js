import SdkFactory, {
    ClientConfiguration,
    CredentialsConfiguration,
    PdfConverter,
    TranslateBatchFileRequest
} from "@language-weaver/lw-sdk-js";
import {file1, file2, file3, file4, file5, file6} from "../../../../samples-utils";

export const translateBatchFile = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);
        const translateFileRequest = new TranslateBatchFileRequest();
        translateFileRequest.sourceLanguageId = "eng";
        translateFileRequest.targetLanguageId = "fra";
        translateFileRequest.model = "generic";
        // provide list of dictionaries
        // translateFileRequest.addDictionary("689f06cf-36ba-4903-a530-da1f7766f478");
        // translateFileRequest.addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");
        // provide list of File objects
        translateFileRequest.input = [file1, file2];
        const translateFileResult = await lwClient.translateBatchFile(translateFileRequest);
        console.log(translateFileResult.translationFileResults);
    } catch (e) {
        console.log(e)
    }
}

export const translatePdfBatchFile = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);
        const translateFileRequest = new TranslateBatchFileRequest();
        translateFileRequest.sourceLanguageId = "eng";
        translateFileRequest.targetLanguageId = "fra";
        translateFileRequest.model = "generic";
        translateFileRequest.pdfConverter = PdfConverter.STANDARD;

        // provide list of File objects
        translateFileRequest.input = [file3, file4];
        const translateFileResult = await lwClient.translateBatchFile(translateFileRequest);
        console.log(translateFileResult.translationFileResults);
    } catch (e) {
        console.log(e)
    }
}
export const translateBatchFileWithLinguisticOptions = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);
        const translateFileRequest = new TranslateBatchFileRequest();
        translateFileRequest.sourceLanguageId = "fra";
        translateFileRequest.targetLanguageId = "eng";
        translateFileRequest.model = "generic";
        translateFileRequest.input = [file5, file6];

        const linguisticOptions = new Map();
        linguisticOptions.set("Spelling", "UK");
        translateFileRequest.linguisticOptions = linguisticOptions;

        const translateFileResult = await lwClient.translateBatchFile(translateFileRequest);
        console.log(translateFileResult.translationFileResults);
    } catch (e) {
        console.log(e)
    }
}
