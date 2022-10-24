import {
    ClientConfiguration,
    CredentialsConfiguration,
    EdgeLanguageWeaverClient,
    EdgeTranslateFileRequest,
    Format,
    PdfConverter
} from "@language-weaver/lw-sdk-js";
import {file1, file3} from "../../../samples-utils";

export const translateFileUsingEdge = async clientId => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId);
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const translateFileRequest = new EdgeTranslateFileRequest();
        translateFileRequest.languagePairId = "EngFra_Generic_SRV_TNMV_8_5_x_1";
        // provide a File object
        translateFileRequest.input = file1;
        translateFileRequest.inputFormat = Format.PLAIN;
        // provide list of dictionaries
        // translateFileRequest.addDictionary("DictionaryName1");
        // translateFileRequest.addDictionary("DictionaryName2");
        const translateFileResult = await edgeLanguageWeaverClient.translateFileUsingEdgeParams(translateFileRequest);
        console.log(translateFileResult.fileContent);
    } catch (e) {
        console.log(e);
    }
}

export const translatePdfFileUsingEdge = async clientId => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId);
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const translateFileRequest = new EdgeTranslateFileRequest();
        translateFileRequest.languagePairId = "EngFra_Generic_SRV_TNMV_8_5_x_1";
        translateFileRequest.input = file3;
        translateFileRequest.inputFormat = Format.PDF;
        translateFileRequest.pdfConverter = PdfConverter.STANDARD;

        const translateFileResult = await edgeLanguageWeaverClient.translateFileUsingEdgeParams(translateFileRequest);
        console.log(translateFileResult.fileContent);
    } catch (e) {
        console.log(e);
    }
}