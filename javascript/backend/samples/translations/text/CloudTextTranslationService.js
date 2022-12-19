const {CloudLanguageWeaverClient, CloudTranslateTextRequest, Format} = require("@language-weaver/lw-sdk-js");

const translateText = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const translateTextRequest = new CloudTranslateTextRequest();
        translateTextRequest.sourceLanguageId = "eng";
        translateTextRequest.targetLanguageId = "fra";
        translateTextRequest.model = "generic";
        // provide list of dictionaries
        // translateTextRequest.addDictionary("689f06cf-36ba-4903-a530-da1f7766f478");
        // translateTextRequest.addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");
        translateTextRequest.addInput("The weather is wonderful today!");
        translateTextRequest.addInput("This is a new input that is part of an array translation.");
        translateTextRequest.inputFormat = Format.PLAIN;
        const translateTextResult = await cloudLanguageWeaverClient.translateTextUsingCloudParams(translateTextRequest);

        console.log(translateTextResult.translation);
    } catch (e) {
        console.log(e);
    }
}

const translateTextWithLinguisticOptions = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const translateTextRequest = new CloudTranslateTextRequest();
        translateTextRequest.sourceLanguageId = "fra";
        translateTextRequest.targetLanguageId = "eng";
        translateTextRequest.model = "generic";
        translateTextRequest.addInput("j'aime cette couleur");
        translateTextRequest.inputFormat = Format.PLAIN;

        const linguisticOptions = new Map();
        linguisticOptions.set("Spelling", "UK");
        translateTextRequest.linguisticOptions = linguisticOptions;

        const translateTextResult = await cloudLanguageWeaverClient.translateTextUsingCloudParams(translateTextRequest);

        console.log(translateTextResult.translation);
    } catch (e) {
        console.log(e);
    }
}

translateText();
// translateTextWithLinguisticOptions();