using LanguageWeaver.Sdk.Common.Edge;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.ContentInsights.Edge.Request;
using LanguageWeaver.Sdk.ContentInsights.Edge.Result;
using LanguageWeaver.Sdk.Translate.Edge.Request;

namespace LanguageWeaver.Sdk.Samples.ContentInsights;

public class EdgeContentInsightsService
{
    public static void Main()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();

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

        var edgeTranslationFileResult = lwClient.TranslateFile(translateFileRequest);
        EdgeContentInsightsRequest edgeContentInsightsRequest =
            new EdgeContentInsightsRequest()
            {
                TranslationId = edgeTranslationFileResult.TranslationId
            };

        EdgeContentInsightsResult edgeContentInsightsResult =
            lwClient.GetContentInsightsForTranslations(edgeContentInsightsRequest);
        // handle result
    }
}