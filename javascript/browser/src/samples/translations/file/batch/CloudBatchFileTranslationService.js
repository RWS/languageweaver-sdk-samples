import {
    ClientConfiguration,
    CloudLanguageWeaverClient,
    CloudTranslateBatchFileRequest,
    CredentialsConfiguration, PdfConverter
} from "@language-weaver/lw-sdk-js";
import {file1, file2, file3, file4} from "../../../../samples-utils";

export const translateBatchFileUsingCloud = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const translateFileRequest = new CloudTranslateBatchFileRequest();
        translateFileRequest.sourceLanguageId = "eng";
        translateFileRequest.targetLanguageId = "fra";
        translateFileRequest.model = "generic";
        // provide list of dictionaries
        // translateFileRequest.addDictionary("689f06cf-36ba-4903-a530-da1f7766f478");
        // translateFileRequest.addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");
        // provide list of File objects
        translateFileRequest.input = [file1, file2];
        const translateFileResult = await cloudLanguageWeaverClient.translateBatchFileUsingCloudParams(translateFileRequest);
        console.log(translateFileResult.translationFileResults);
    } catch (e) {
        console.log(e);
    }
}

export const translatePdfBatchFileUsingCloud = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const translateFileRequest = new CloudTranslateBatchFileRequest();
        translateFileRequest.sourceLanguageId = "eng";
        translateFileRequest.targetLanguageId = "fra";
        translateFileRequest.model = "generic";
        translateFileRequest.pdfConverter = PdfConverter.STANDARD;

        // provide list of File objects
        translateFileRequest.input = [file3, file4];
        const translateFileResult = await cloudLanguageWeaverClient.translateBatchFileUsingCloudParams(translateFileRequest);
        console.log(translateFileResult.translationFileResults);
    } catch (e) {
        console.log(e);
    }
}