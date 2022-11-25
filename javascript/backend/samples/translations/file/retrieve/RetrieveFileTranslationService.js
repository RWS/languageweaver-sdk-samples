const path = require("path");
const SdkFactory = require("@language-weaver/lw-sdk-js").default;
const {ClientConfiguration, RetrieveFileRequest} = require("@language-weaver/lw-sdk-js");

const retrieveFileTranslation = async () => {
    try {
        const lwClient = await SdkFactory.getLanguageWeaverClient(new ClientConfiguration());
        const request = new RetrieveFileRequest();
        request.requestId = "requestId";
        request.outputDir = path.resolve("resources/output");
        request.outputFile = "input1-translated.txt";
        const translateFileResult = await lwClient.retrieveFileTranslation(request);
        console.log(translateFileResult.fileContent);
    } catch (e) {
        console.log(e);
    }
}

retrieveFileTranslation();