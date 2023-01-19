using LanguageWeaver.Sdk.Common.Edge;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.Translate.Edge.Request;

namespace LanguageWeaver.Sdk.Samples.Translations.File.Batch;

public class EdgeBatchFileTranslationService
{
    public static void Main()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();

        TranslateBatchFile(lwClient);
        TranslateBatchFileWithLinguisticOptions(lwClient);
    }

    private static void TranslateBatchFile(EdgeLanguageWeaverClient lwClient)
    {
        var translateBatchFileRequest = new EdgeTranslateBatchFileRequest
        {
            LanguagePairId = "EngFra_Generic_SRV_TNMV_8_5_x_1",
            PdfConverter = PdfConverter.ABBYY,
            Dictionaries = new List<string>
            {
                "DictionaryName1",
                "DictionaryName2"
            },
            // provide full path to the input and output folders
            InputBatchFolderPath = Path.Combine(
                Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Input"),
            OutputBatchFolderPath = Path.Combine(
                Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Output")
        };

        lwClient.TranslateBatchFile(translateBatchFileRequest);
    }

    private static void TranslateBatchFileWithLinguisticOptions(EdgeLanguageWeaverClient lwClient)
    {
        Dictionary<string, string> linguisticOptions = new Dictionary<string, string>();
        linguisticOptions.Add("formality", "Informal");

        var translateBatchFileRequest = new EdgeTranslateBatchFileRequest()
        {
            LanguagePairId = "EngJpn_Generic_SRV_TNMV_8_5_x_6",
            LinguisticOptions = linguisticOptions,
            Dictionaries = new List<string>
            {
                "DictionaryName1",
                "DictionaryName2"
            },
            // provide full path to the input and output folders
            InputBatchFolderPath = Path.Combine(
                Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Input"),
            OutputBatchFolderPath = Path.Combine(
                Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Output"),
        };

        lwClient.TranslateBatchFile(translateBatchFileRequest);
    }
}