const path = require("path");
const {CloudLanguageWeaverClient, CloudTranslateFileRequest, Format, PdfConverter} = require("@language-weaver/lw-sdk-js");

const translateFile = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const translateFileRequest = new CloudTranslateFileRequest();
        translateFileRequest.sourceLanguageId = "eng";
        translateFileRequest.targetLanguageId = "fra";
        translateFileRequest.model = "generic";
        translateFileRequest.inputFormat = Format.PLAIN;
        // provide list of dictionaries
        // translateFileRequest.addDictionary("689f06cf-36ba-4903-a530-da1f7766f478");
        // translateFileRequest.addDictionary("3d297ee3-0878-4ef7-9ee7-ca14b48e6956");
        // provide full path to the source file
        translateFileRequest.input = path.resolve("resources/input/input1.txt");
        // provide full path to the target directory
        translateFileRequest.outputDir = path.resolve("resources/output");
        translateFileRequest.outputFile = "input1-translated.txt";
        await cloudLanguageWeaverClient.translateFileUsingCloudParams(translateFileRequest);
    } catch (e) {
        console.log(e);
    }
}

const translatePdfFile = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const translateFileRequest = new CloudTranslateFileRequest();
        translateFileRequest.sourceLanguageId = "eng";
        translateFileRequest.targetLanguageId = "fra";
        translateFileRequest.model = "generic";
        translateFileRequest.inputFormat = Format.PDF;
        translateFileRequest.input = path.resolve("resources/input_pdf/input1.pdf");
        translateFileRequest.pdfConverter = PdfConverter.STANDARD;
        // provide full path to the target directory
        translateFileRequest.outputDir = path.resolve("resources/output");
        translateFileRequest.outputFile = "input1-translated.docx";
        await cloudLanguageWeaverClient.translateFileUsingCloudParams(translateFileRequest);
    } catch (e) {
        console.log(e);
    }
}

const translateFileWithLinguisticOptions = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const translateFileRequest = new CloudTranslateFileRequest();
        translateFileRequest.sourceLanguageId = "fra";
        translateFileRequest.targetLanguageId = "eng";
        translateFileRequest.model = "generic";
        translateFileRequest.inputFormat = Format.PLAIN;
        // provide full path to the source file
        translateFileRequest.input = path.resolve("resources/input_linguistic_options/input1.txt");
        // provide full path to the target directory
        translateFileRequest.outputDir = path.resolve("resources/output");
        translateFileRequest.outputFile = "input1-translated.txt";

        const linguisticOptions = new Map();
        linguisticOptions.set("Spelling", "UK");
        translateFileRequest.linguisticOptions = linguisticOptions;

        await cloudLanguageWeaverClient.translateFileUsingCloudParams(translateFileRequest);
    } catch (e) {
        console.log(e);
    }
}


translateFile();
// translatePdfFile();
// translateFileWithLinguisticOptions();