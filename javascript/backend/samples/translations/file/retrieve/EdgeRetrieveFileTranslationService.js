const path = require("path");
const {EdgeLanguageWeaverClient, EdgeRetrieveFileRequest, Format} = require("@language-weaver/lw-sdk-js");

const retrieveFileTranslationUsingEdge = async () => {
    try {
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const request = new EdgeRetrieveFileRequest();
        request.translationId = "translationId";
        request.outputDir = path.resolve("resources/output");
        request.outputFile = "input1-translated.txt";
        request.outputFormat = Format.PLAIN;
        const translateFileResult = await edgeLanguageWeaverClient.retrieveEdgeFileTranslation(request);
        console.log(translateFileResult.fileContent);
    } catch (e) {
        console.log(e);
    }
}

retrieveFileTranslationUsingEdge();