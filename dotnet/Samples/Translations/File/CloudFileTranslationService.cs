using LanguageWeaver.Sdk.Translate.Request.Cloud;
using LanguageWeaver.Sdk.Translate.Result.Cloud;

namespace LanguageWeaver.Sdk.Samples.Translations.File;

public class CloudFileTranslationService
{
    public static void Main()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();
        var translateFileRequest = new CloudTranslateFileRequest
        {
            SourceLanguageId = "eng",
            TargetLanguageId = "fra",
            Model = "generic",
            InputFormat = "plain",
            Dictionaries = new List<string>
            {
                "689f06cf-36ba-4903-a530-da1f7766f478",
                "3d297ee3-0878-4ef7-9ee7-ca14b48e6956"
            },
            // provide full path to the source and output file
            InputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Input", "input1.txt"),
            OutputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Output", "input1-translated.txt")
        };

        CloudTranslationFileResult translateFileResult = lwClient.TranslateFile(translateFileRequest);
        // handle result
    }
}