const {EdgeLanguageWeaverClient, EdgeTranslateTextRequest, Format} = require("@language-weaver/lw-sdk-js");

const translateText = async () => {
    try {
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const translateTextRequest = new EdgeTranslateTextRequest();
        translateTextRequest.languagePairId = "EngFra_Generic_SRV_TNMV_8_5_x_1";
        translateTextRequest.addInput("The weather is wonderful today!");
        translateTextRequest.inputFormat = Format.PLAIN;
        // provide list of dictionaries
        // translateTextRequest.addDictionary("DictionaryName1");
        // translateTextRequest.addDictionary("DictionaryName2");
        const translateTextResult = await edgeLanguageWeaverClient.translateTextUsingEdgeParams(translateTextRequest);

        console.log(translateTextResult.translation);
    } catch (e) {
        console.log(e);
    }
}

translateText();