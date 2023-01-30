using LanguageWeaver.Sdk.Common.Cloud;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.Translate.Cloud.Request;
using LanguageWeaver.Sdk.Translate.Cloud.Result;

namespace LanguageWeaver.Sdk.Samples.Translations.File.Batch;

public class CloudBatchFileTranslationService
{
    public static void Main()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();

        TranslateBatchFile(lwClient);
        TranslateBatchFileWithLinguisticOptions(lwClient);
    }

    private static void TranslateBatchFile(CloudLanguageWeaverClient lwClient)
    {
        var translateBatchFileRequest = new CloudTranslateBatchFileRequest
        {
            SourceLanguageId = "eng",
            TargetLanguageId = "fra",
            Model = "generic",
            PdfConverter = PdfConverter.STANDARD,
            Dictionaries = new List<string>
            {
                "689f06cf-36ba-4903-a530-da1f7766f478",
                "3d297ee3-0878-4ef7-9ee7-ca14b48e6956"
            },
            // provide full path to the input and output folders
            InputBatchFolderPath = Path.Combine(
                Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Input"),
            OutputBatchFolderPath = Path.Combine(
                Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Output")
        };

        CloudTranslationBatchFileResult cloudTranslationBatchFileResult =
            lwClient.TranslateBatchFile(translateBatchFileRequest);
    }

    private static void TranslateBatchFileWithLinguisticOptions(CloudLanguageWeaverClient lwClient)
    {
        var translateBatchFileRequest = new CloudTranslateBatchFileRequest()
        {
            SourceLanguageId = "fra",
            TargetLanguageId = "eng",
            Model = "generic",
            LinguisticOptions = new Dictionary<string, string>
            {
                { "Spelling", "US" }
            },
            Dictionaries = new List<string>
            {
                "689f06cf-36ba-4903-a530-da1f7766f478",
                "3d297ee3-0878-4ef7-9ee7-ca14b48e6956"
            },
            // provide full path to the input and output folders
            InputBatchFolderPath = Path.Combine(
                Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Input"),
            OutputBatchFolderPath = Path.Combine(
                Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Output")
        };

        CloudTranslationBatchFileResult cloudTranslationBatchFileResult =
            lwClient.TranslateBatchFile(translateBatchFileRequest);
    }
}