const path = require("path");
const {EdgeLanguageWeaverClient, Format, EdgeTranslateFileRequest, PdfConverter} = require("@language-weaver/lw-sdk-js");

const translateFile = async () => {
    try {
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const translateFileRequest = new EdgeTranslateFileRequest();
        translateFileRequest.languagePairId = "EngFra_Generic_SRV_TNMV_8_5_x_1";
        // provide full path to the source file
        translateFileRequest.input = path.resolve("resources/input/input1.txt");
        // provide full path to the target directory
        translateFileRequest.outputDir = path.resolve("resources/output");
        translateFileRequest.outputFile = "input1-translated.txt";
        translateFileRequest.inputFormat = Format.PLAIN;
        // provide list of dictionaries
        // translateFileRequest.addDictionary("DictionaryName1");
        // translateFileRequest.addDictionary("DictionaryName2");
        await edgeLanguageWeaverClient.translateFileUsingEdgeParams(translateFileRequest);
    } catch (e) {
        console.log(e);
    }
}

const translatePdfFile = async () => {
    try {
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const translateFileRequest = new EdgeTranslateFileRequest();
        translateFileRequest.languagePairId = "EngFra_Generic_SRV_TNMV_8_5_x_1";
        translateFileRequest.input = path.resolve("resources/input_pdf/input1.pdf");
        // provide full path to the target directory
        translateFileRequest.outputDir = path.resolve("resources/output");
        translateFileRequest.outputFile = "input1-translated.docx";
        translateFileRequest.inputFormat = Format.PDF;
        translateFileRequest.pdfConverter = PdfConverter.STANDARD;
        await edgeLanguageWeaverClient.translateFileUsingEdgeParams(translateFileRequest);
    } catch (e) {
        console.log(e);
    }
}

const translateFileWithLinguisticOptions = async () => {
    try {
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const translateFileRequest = new EdgeTranslateFileRequest();
        translateFileRequest.languagePairId = "FraEng_Generic_Cloud";
        // provide full path to the source file
        translateFileRequest.input = path.resolve("resources/input_linguistic_options/input1.txt");
        // provide full path to the target directory
        translateFileRequest.outputDir = path.resolve("resources/output");
        translateFileRequest.outputFile = "input1-translated.txt";
        translateFileRequest.inputFormat = Format.PLAIN;

        const linguisticOptions = new Map();
        linguisticOptions.set("Spelling", "UK");
        translateFileRequest.linguisticOptions = linguisticOptions;

        await edgeLanguageWeaverClient.translateFileUsingEdgeParams(translateFileRequest);
    } catch (e) {
        console.log(e);
    }
}

translateFile();
// translatePdfFile();
// translateFileWithLinguisticOptions();