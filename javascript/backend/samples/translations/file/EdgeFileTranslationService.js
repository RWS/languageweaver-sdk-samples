const path = require("path");
const {EdgeLanguageWeaverClient, Format, EdgeTranslateFileRequest} = require("@language-weaver/lw-sdk-js");

const translateFile = async () => {
    try {
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const translateFileRequest = new EdgeTranslateFileRequest();
        translateFileRequest.languagePairId = "EngFra_Generic_SRV_TNMV_8_5_x_1";
        // provide full path to the source file
        translateFileRequest.input = path.resolve("resources/input/input1.txt");
        // provide full path to the target directory
        translateFileRequest.outputDir = path.resolve("resources/output");
        translateFileRequest.outputFile = "input1-translated.txt";
        translateFileRequest.inputFormat = Format.PLAIN;
        // provide list of dictionaries
        // translateFileRequest.addDictionary("DictionaryName1");
        // translateFileRequest.addDictionary("DictionaryName2");
        await edgeLanguageWeaverClient.translateFileUsingEdgeParams(translateFileRequest);
    } catch (e) {
        console.log(e);
    }
}

translateFile();