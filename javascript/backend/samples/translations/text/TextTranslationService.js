const SdkFactory = require("@language-weaver/lw-sdk-js").default;
const {ClientConfiguration, Format, TranslateTextRequest} = require("@language-weaver/lw-sdk-js");

const translateText = async () => {
    try {
        const lwClient = await SdkFactory.getLanguageWeaverClient(new ClientConfiguration());
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

translateText();