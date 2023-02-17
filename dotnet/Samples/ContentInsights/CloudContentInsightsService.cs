using LanguageWeaver.Sdk.Common.Cloud;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.ContentInsights.Cloud.Request;
using LanguageWeaver.Sdk.ContentInsights.Cloud.Result;
using LanguageWeaver.Sdk.Translate.Cloud.Request;

namespace LanguageWeaver.Sdk.Samples.ContentInsights;

public class CloudContentInsightsService
{
    public static void Main()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();
        CreateContentInsights(lwClient);
        CreateContentInsightsForExistingTranslations(lwClient);
    }

    private static void CreateContentInsights(CloudLanguageWeaverClient lwClient)
    {
        CloudFileContentInsightsRequest cloudContentInsightsRequest = new CloudFileContentInsightsRequest()
        {
            SourceLanguage = "eng",
            FilePath = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Input", "input1.txt")
        };

        CloudContentInsightsResult cloudContentInsightsResult =
            lwClient.GetContentInsights(cloudContentInsightsRequest);
        // handle result
    }

    private static void CreateContentInsightsForExistingTranslations(CloudLanguageWeaverClient lwClient)
    {
        CloudTranslateFileRequest translateFileRequest = new CloudTranslateFileRequest()
        {
            SourceLanguageId = "eng",
            TargetLanguageId = "fra",
            Model = "generic",
            InputFormat = Format.Plain,
            InputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Input", "input1.txt"),
            OutputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Output", "input1-translated.txt")
        };

        var cloudTranslationFileResult = lwClient.TranslateFile(translateFileRequest);
        CloudContentInsightsRequest contentInsightsForTranslationsRequest =
            new CloudContentInsightsRequest().AddTranslationId(cloudTranslationFileResult.TranslationId);

        CloudContentInsightsResult cloudContentInsightsResult =
            lwClient.GetContentInsightsForTranslations(contentInsightsForTranslationsRequest);
        // handle result
    }
}