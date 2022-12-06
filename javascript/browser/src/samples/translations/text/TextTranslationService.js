import SdkFactory, {
    ClientConfiguration,
    CredentialsConfiguration,
    Format,
    TranslateTextRequest
} from "@language-weaver/lw-sdk-js";

export const translateText = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);
        const translateTextRequest = new TranslateTextRequest();
        translateTextRequest.sourceLanguageId = "eng";
        translateTextRequest.targetLanguageId = "fra";
        translateTextRequest.model = "generic";
        // provide list of dictionaries
        // translateTextRequest.addDictionary("dictionaryId or name");
        translateTextRequest.addInput("The weather is wonderful today!");
        translateTextRequest.inputFormat = Format.PLAIN;
        const translateTextResult = await lwClient.translateText(translateTextRequest);

        console.log(translateTextResult.translation);
    } catch (e) {
        console.log(e);
    }
}