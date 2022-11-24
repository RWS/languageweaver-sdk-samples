const path = require("path");
const SdkFactory = require("@language-weaver/lw-sdk-js").default;
const {ClientConfiguration, Format, TranslateFileRequest, PdfConverter} = require("@language-weaver/lw-sdk-js");

const translateFile = async () => {
    try {
        const lwClient = await SdkFactory.getLanguageWeaverClient(new ClientConfiguration());
        const translateFileRequest = new TranslateFileRequest();
        translateFileRequest.sourceLanguageId = "eng";
        translateFileRequest.targetLanguageId = "fra";
        translateFileRequest.model = "generic";
        // provide list of dictionaries
        // translateFileRequest.addDictionary("dictionaryId or name");
        translateFileRequest.inputFormat = Format.PLAIN;
        // provide full path to the source file
        translateFileRequest.input = path.resolve("resources/input/input1.txt");
        // provide full path to the target directory
        translateFileRequest.outputDir = path.resolve("resources/output");
        translateFileRequest.outputFile = "input1-translated.txt";
        await lwClient.translateFile(translateFileRequest);
    } catch (e) {
        console.log(e);
    }
}

const translatePdfFile = async () => {
    try {
        const lwClient = await SdkFactory.getLanguageWeaverClient(new ClientConfiguration());
        const translateFileRequest = new TranslateFileRequest();
        translateFileRequest.sourceLanguageId = "eng";
        translateFileRequest.targetLanguageId = "fra";
        translateFileRequest.model = "generic";
        translateFileRequest.inputFormat = Format.PDF;
        translateFileRequest.pdfConverter = PdfConverter.STANDARD;
        // provide full path to the source file
        translateFileRequest.input = path.resolve("resources/input_pdf/input1.pdf");
        // provide full path to the target directory
        translateFileRequest.outputDir = path.resolve("resources/output");
        translateFileRequest.outputFile = "input1-translated.docx";
        await lwClient.translateFile(translateFileRequest);
    } catch (e) {
        console.log(e);
    }
}

translateFile();
// translatePdfFile();