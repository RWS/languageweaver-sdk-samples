const {
    CloudLanguageWeaverClient,
    CloudTextLanguageDetectionRequest,
    Format,
} = require("@language-weaver/lw-sdk-js");
const detectCloudTextLanguage = async () => {
    try{
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const cloudTextLanguageDetectionRequest = new CloudTextLanguageDetectionRequest();
        cloudTextLanguageDetectionRequest.input = "A mountain is generally steeper than a hill";
        cloudTextLanguageDetectionRequest.inputFormat = Format.PLAIN;

        const cloudTextLanguageDetectionResult = await cloudLanguageWeaverClient.detectCloudTextLanguage(cloudTextLanguageDetectionRequest);
        console.log(cloudTextLanguageDetectionResult);
    } catch (e) {
        console.log(e);
    }
}

detectCloudTextLanguage();