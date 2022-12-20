const path = require("path");
const {CloudLanguageWeaverClient, CloudTranslateBatchFileRequest, PdfConverter} = require("@language-weaver/lw-sdk-js");

const translateBatchFile = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const translateFileRequest = new CloudTranslateBatchFileRequest();
        translateFileRequest.sourceLanguageId = "eng";
        translateFileRequest.targetLanguageId = "fra";
        translateFileRequest.model = "generic";
        // provide list of dictionaries
        // translateFileRequest.addDictionary("689f06cf-36ba-4903-a530-da1f7766f478");
        // translateFileRequest.addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");
        // provide full path to the input and output folders
        translateFileRequest.input = path.resolve("resources/input");
        translateFileRequest.outputDir = path.resolve("resources/output");
        await cloudLanguageWeaverClient.translateBatchFileUsingCloudParams(translateFileRequest);
    } catch (e) {
        console.log(e);
    }
}

const translatePdfBatchFile = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const translateFileRequest = new CloudTranslateBatchFileRequest();
        translateFileRequest.sourceLanguageId = "eng";
        translateFileRequest.targetLanguageId = "fra";
        translateFileRequest.model = "generic";
        translateFileRequest.pdfConverter = PdfConverter.STANDARD;
        // provide full path to the input and output folders
        translateFileRequest.input = path.resolve("resources/input_pdf");
        translateFileRequest.outputDir = path.resolve("resources/output");
        await cloudLanguageWeaverClient.translateBatchFileUsingCloudParams(translateFileRequest);
    } catch (e) {
        console.log(e);
    }
}

const translateBatchFileWithLinguisticOptions = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const translateFileRequest = new CloudTranslateBatchFileRequest();
        translateFileRequest.sourceLanguageId = "fra";
        translateFileRequest.targetLanguageId = "eng";
        translateFileRequest.model = "generic";
        // provide full path to the input and output folders
        translateFileRequest.input = path.resolve("resources/input_linguistic_options");
        translateFileRequest.outputDir = path.resolve("resources/output");

        const linguisticOptions = new Map();
        linguisticOptions.set("Spelling", "UK");
        translateFileRequest.linguisticOptions = linguisticOptions;

        await cloudLanguageWeaverClient.translateBatchFileUsingCloudParams(translateFileRequest);
    } catch (e) {
        console.log(e);
    }
}

translateBatchFile();
// translatePdfBatchFile();
// translateBatchFileWithLinguisticOptions();