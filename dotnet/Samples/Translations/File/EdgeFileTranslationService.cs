using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.Translate.Request.Edge;
using LanguageWeaver.Sdk.Translate.Result.Edge;

namespace LanguageWeaver.Sdk.Samples.Translations.File;

public class EdgeFileTranslationService
{
    public static void Main()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();

        EdgeLanguageWeaverClientFileTranslation(lwClient);
        EdgeLanguageWeaverClientFileTranslationWithPdfConverter(lwClient);
    }

    private static void EdgeLanguageWeaverClientFileTranslation(EdgeLanguageWeaverClient lwClient)
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

    private static void EdgeLanguageWeaverClientFileTranslationWithPdfConverter(EdgeLanguageWeaverClient lwClient)
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
}