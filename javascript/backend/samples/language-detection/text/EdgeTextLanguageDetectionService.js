const {
    EdgeLanguageWeaverClient,
    EdgeTextLanguageDetectionRequest,
    Format,
} = require("@language-weaver/lw-sdk-js");
const detectEdgeTextLanguage = async () => {
    try{
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const edgeTextLanguageDetectionRequest = new EdgeTextLanguageDetectionRequest();
        edgeTextLanguageDetectionRequest.input = "A mountain is generally steeper than a hill";
        edgeTextLanguageDetectionRequest.inputFormat = Format.PLAIN;

        const edgeTextLanguageDetectionResult = await edgeLanguageWeaverClient.detectEdgeTextLanguage(edgeTextLanguageDetectionRequest);
        console.log(edgeTextLanguageDetectionResult);
    } catch (e) {
        console.log(e);
    }
}

detectEdgeTextLanguage();