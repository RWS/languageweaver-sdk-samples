const path = require("path");
const {CloudLanguageWeaverClient, CloudRetrieveFileRequest} = require("@language-weaver/lw-sdk-js");

const retrieveFileTranslationUsingCloud = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const request = new CloudRetrieveFileRequest();
        request.translationId = "translationId";
        request.outputDir = path.resolve("resources/output");
        request.outputFile = "input1-translated.txt";
        const translateFileResult = await cloudLanguageWeaverClient.retrieveCloudFileTranslation(request);
        console.log(translateFileResult.fileContent);
    } catch (e) {
        console.log(e);
    }
}

retrieveFileTranslationUsingCloud();