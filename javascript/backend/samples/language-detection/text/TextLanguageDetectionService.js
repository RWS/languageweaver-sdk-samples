const SdkFactory = require("@language-weaver/lw-sdk-js").default;
const {
    TextLanguageDetectionRequest,
    Format,
    ClientConfiguration,
} = require("@language-weaver/lw-sdk-js");
const detectTextLanguage = async () => {
    try{
        const lwClient = await SdkFactory.getLanguageWeaverClient(new ClientConfiguration());
        const textLanguageDetectionRequest = new TextLanguageDetectionRequest();
        textLanguageDetectionRequest.input = "A mountain is generally steeper than a hill";
        textLanguageDetectionRequest.inputFormat = Format.PLAIN;

        const textLanguageDetectionResult = await lwClient.detectTextLanguage(textLanguageDetectionRequest);
        console.log(textLanguageDetectionResult);
    } catch (e) {
        console.log(e);
    }
}

detectTextLanguage();