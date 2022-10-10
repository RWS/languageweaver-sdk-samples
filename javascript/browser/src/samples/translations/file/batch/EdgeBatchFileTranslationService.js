import {
    ClientConfiguration,
    CredentialsConfiguration,
    EdgeLanguageWeaverClient,
    EdgeTranslateBatchFileRequest
} from "@language-weaver/lw-sdk-js";
import {file1, file2} from "../../../../samples-utils";

export const translateBatchFileUsingEdge = async clientId => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId);
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const translateFileRequest = new EdgeTranslateBatchFileRequest();
        translateFileRequest.languagePairId = "EngFra_Generic_SRV_TNMV_8_5_x_1";
        // provide a File object
        translateFileRequest.input = [file1, file2];
        // provide list of dictionaries
        // translateFileRequest.addDictionary("DictionaryName1");
        // translateFileRequest.addDictionary("DictionaryName2");
        const translateFileResult = await edgeLanguageWeaverClient.translateBatchFileUsingEdgeParams(translateFileRequest);
        console.log(translateFileResult.translationFileResults);
    } catch (e) {
        console.log(e);
    }
}