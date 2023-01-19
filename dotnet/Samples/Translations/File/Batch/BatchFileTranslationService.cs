using LanguageWeaver.Sdk.Common;
using LanguageWeaver.Sdk.Configurations;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.Translate.Common.Request;

namespace LanguageWeaver.Sdk.Samples.Translations.File.Batch;

public class BatchFileTranslationService
{
    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());

        TranslateBatchFile(lwClient);
        TranslateBatchFileWithLinguisticOptions(lwClient);
    }

    private static void TranslateBatchFile(ILanguageWeaverClient lwClient)
    {
        var translateBatchFileRequest = new TranslateBatchFileRequest
        {
            SourceLanguageId = "eng",
            TargetLanguageId = "fra",
            PdfConverter = PdfConverter.STANDARD,
            Model = "generic",
            Dictionaries = new List<string>
            {
                // provide list of dictionaries
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

    private static void TranslateBatchFileWithLinguisticOptions(ILanguageWeaverClient lwClient)
    {
        Dictionary<string, string> linguisticOptions = new Dictionary<string, string>();
        linguisticOptions.Add("Spelling", "US");

        var translateBatchFileRequest = new TranslateBatchFileRequest()
        {
            SourceLanguageId = "fra",
            TargetLanguageId = "eng",
            Model = "generic",
            LinguisticOptions = linguisticOptions,
            Dictionaries = new List<string>
            {
                // provide list of dictionaries
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
}