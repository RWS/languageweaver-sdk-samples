using LanguageWeaver.Sdk.Common.Edge;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.Translate.Edge.Request;
using LanguageWeaver.Sdk.Translate.Edge.Result;

namespace LanguageWeaver.Sdk.Samples.Translations.File;

public class EdgeFileTranslationService
{
    public static void Main()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();

        TranslateFile(lwClient);
        TranslateFileWithPdfConverter(lwClient);
        TranslateFileWithLinguisticOptions(lwClient);
    }

    private static void TranslateFile(EdgeLanguageWeaverClient lwClient)
    {
        var translateFileRequest = new EdgeTranslateFileRequest
        {
            LanguagePairId = "EngFra_Generic_SRV_TNMV_8_5_x_1",
            InputFormat = Format.Plain,
            Dictionaries = new List<string>
            {
                "DictionaryName1",
                "DictionaryName2"
            },
            // provide full path to the source and output file
            InputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Input", "input1.txt"),
            OutputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Output", "input1-translated.txt")
        };

        EdgeTranslationFileResult translateFileResult = lwClient.TranslateFile(translateFileRequest);
        // handle result
    }

    private static void TranslateFileWithPdfConverter(EdgeLanguageWeaverClient lwClient)
    {
        var translateFileRequest = new EdgeTranslateFileRequest
        {
            LanguagePairId = "EngFra_Generic_SRV_TNMV_8_5_x_1",
            InputFormat = Format.Pdf,
            PdfConverter = PdfConverter.STANDARD,
            Dictionaries = new List<string>
            {
                "DictionaryName1",
                "DictionaryName2"
            },
            // provide full path to the source and output file
            InputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Input", "input1.pdf"),
            OutputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Output", "input1-translated.docx")
        };

        EdgeTranslationFileResult translateFileResult = lwClient.TranslateFile(translateFileRequest);
        // handle result
    }

    private static void TranslateFileWithLinguisticOptions(EdgeLanguageWeaverClient lwClient)
    {
        Dictionary<string, string> linguisticOptions = new Dictionary<string, string>();
        linguisticOptions.Add("formality", "Formal");

        var translateFileRequest = new EdgeTranslateFileRequest()
        {
            LanguagePairId = "EngJpn_Generic_SRV_TNMV_8_5_x_6",
            LinguisticOptions = linguisticOptions,
            Dictionaries = new List<string>
            {
                "DictionaryName1",
                "DictionaryName2"
            },
            InputFormat = Format.Plain,
            // provide full path to the source and output file
            InputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Input", "input1.txt"),
            OutputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Output", "input1-translated.txt")
        };

        EdgeTranslationFileResult translateFileResult = lwClient.TranslateFile(translateFileRequest);
        // handle result
    }
}