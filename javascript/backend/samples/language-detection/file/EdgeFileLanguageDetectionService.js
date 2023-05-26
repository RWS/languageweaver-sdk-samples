const {
    EdgeLanguageWeaverClient,
    EdgeFileLanguageDetectionRequest,
    Format,
} = require("@language-weaver/lw-sdk-js");
const path = require("path");
const detectEdgeFileLanguage = async () => {
    try{
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const edgeFileLanguageDetectionRequest = new EdgeFileLanguageDetectionRequest();
        edgeFileLanguageDetectionRequest.inputFile = path.resolve("resources/input/input1.txt");
        edgeFileLanguageDetectionRequest.inputFormat = Format.PLAIN;

        const edgeFileLanguageDetectionResult = await edgeLanguageWeaverClient.detectEdgeFileLanguage(edgeFileLanguageDetectionRequest);
        console.log(edgeFileLanguageDetectionResult);
    } catch (e) {
        console.log(e);
    }
}

detectEdgeFileLanguage();