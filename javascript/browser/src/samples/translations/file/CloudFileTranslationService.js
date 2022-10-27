import {
    ClientConfiguration,
    CloudLanguageWeaverClient,
    CloudTranslateFileRequest,
    CredentialsConfiguration, Format
} from "@language-weaver/lw-sdk-js";
import {file1} from "../../../samples-utils";

export const translateFileUsingCloud = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const translateFileRequest = new CloudTranslateFileRequest();
        translateFileRequest.sourceLanguageId = "eng";
        translateFileRequest.targetLanguageId = "fra";
        translateFileRequest.model = "generic";
        translateFileRequest.inputFormat = Format.PLAIN;
        // provide list of dictionaries
        // translateFileRequest.addDictionary("689f06cf-36ba-4903-a530-da1f7766f478");
        // translateFileRequest.addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");
        // provide a File object
        translateFileRequest.input = file1;
        const translateFileResult = await cloudLanguageWeaverClient.translateFileUsingCloudParams(translateFileRequest);
        console.log(translateFileResult.fileContent)
    } catch (e) {
        console.log(e);
    }
}