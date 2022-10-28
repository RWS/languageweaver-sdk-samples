using LanguageWeaver.Sdk.Configurations;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.Translate.Request;

namespace LanguageWeaver.Sdk.Samples.Translations.File.Batch;

public class BatchFileTranslationService
{
    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());
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
}