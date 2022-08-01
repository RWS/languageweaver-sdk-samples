using LanguageWeaver.Sdk.Translate.Request.Cloud;

namespace LanguageWeaver.Sdk.Samples.Translations.File.Batch;

public class CloudBatchFileTranslationService
{
    public static void Main()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();
        var translateTextRequest = new CloudTranslateBatchFileRequest
        {
            SourceLanguageId = "eng",
            TargetLanguageId = "fra",
            Model = "generic",
            Dictionaries = new List<string>
            {
                "689f06cf-36ba-4903-a530-da1f7766f478",
                "3d297ee3-0878-4ef7-9ee7-ca14b48e6956"
            },
            // provide full path to the input and output folders
            InputBatchFolderPath = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName, 
                    "Resources", "Input"),
            OutputBatchFolderPath = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName, 
                    "Resources", "Output")
        };

        var translationBatchResult = lwClient.TranslateBatchFile(translateTextRequest);
        // handle result
    }
}