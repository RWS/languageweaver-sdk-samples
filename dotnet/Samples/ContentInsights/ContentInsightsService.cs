using LanguageWeaver.Sdk.Common;
using LanguageWeaver.Sdk.Configurations;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.ContentInsights.Common.Request;
using LanguageWeaver.Sdk.ContentInsights.Common.Result;
using LanguageWeaver.Sdk.Translate.Common.Request;

namespace LanguageWeaver.Sdk.Samples.ContentInsights;

public class ContentInsightsService
{
    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());

        var translateFileRequest = new TranslateFileRequest
        {
            SourceLanguageId = "eng",
            TargetLanguageId = "fra",
            Model = "generic",
            InputFormat = Format.Plain,
            Dictionaries = new List<string>
            {
                // provide list of dictionaries
            },
            // provide full path to the source and output file
            InputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Input", "input1.txt"),
            OutputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Output", "input1-translated.txt")
        };

        ContentInsightsRequest contentInsightsRequest =
            new ContentInsightsRequest().AddTranslationId(lwClient.TranslateFile(translateFileRequest).TranslationId);

        ContentInsightsResult contentInsightsResult =
            lwClient.GetContentInsightsForTranslations(contentInsightsRequest);
    }
}