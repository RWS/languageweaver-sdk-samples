const path = require("path");
const {EdgeLanguageWeaverClient, EdgeTranslateBatchFileRequest} = require("@language-weaver/lw-sdk-js");

const translateBatchFile = async () => {
    try {
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const translateFileRequest = new EdgeTranslateBatchFileRequest();
        translateFileRequest.languagePairId = "EngFra_Generic_SRV_TNMV_8_5_x_1";
        // provide full path to the input and output folders
        translateFileRequest.input = path.resolve("resources/input");
        translateFileRequest.outputDir = path.resolve("resources/output");
        // provide list of dictionaries
        // translateFileRequest.addDictionary("DictionaryName1");
        // translateFileRequest.addDictionary("DictionaryName2");
        await edgeLanguageWeaverClient.translateBatchFileUsingEdgeParams(translateFileRequest);
    } catch (e) {
        console.log(e);
    }
}

translateBatchFile();