const SdkFactory = require("@language-weaver/lw-sdk-js").default;
const {
    FileLanguageDetectionRequest,
    Format,
    ClientConfiguration,
} = require("@language-weaver/lw-sdk-js");
const path = require("path");
const detectFileLanguage = async () => {
    try{
        const lwClient = await SdkFactory.getLanguageWeaverClient(new ClientConfiguration());
        const fileLanguageDetectionRequest = new FileLanguageDetectionRequest();
        fileLanguageDetectionRequest.inputFile = path.resolve("resources/input/input1.txt");
        fileLanguageDetectionRequest.inputFormat = Format.PLAIN;

        const fileLanguageDetectionResult = await lwClient.detectFileLanguage(fileLanguageDetectionRequest);
        console.log(fileLanguageDetectionResult);

    } catch (e) {
        console.log(e);
    }
}

detectFileLanguage();