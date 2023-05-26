const {
    CloudLanguageWeaverClient,
    CloudFileLanguageDetectionRequest,
    Format,
} = require("@language-weaver/lw-sdk-js");
const path = require("path");
const detectCloudFileLanguage = async () => {
    try{
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const cloudFileLanguageDetectionRequest = new CloudFileLanguageDetectionRequest();
        cloudFileLanguageDetectionRequest.inputFile = path.resolve("resources/input/input1.txt");
        cloudFileLanguageDetectionRequest.inputFormat = Format.PLAIN;

        const cloudFileLanguageDetectionResult = await cloudLanguageWeaverClient.detectCloudFileLanguage(cloudFileLanguageDetectionRequest);
        console.log(cloudFileLanguageDetectionResult);
    } catch (e) {
        console.log(e);
    }
}

detectCloudFileLanguage();