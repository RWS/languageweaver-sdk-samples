using LanguageWeaver.Sdk.Common.Cloud;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.Translate.Cloud.Request;
using LanguageWeaver.Sdk.Translate.Cloud.Result;

namespace LanguageWeaver.Sdk.Samples.Translations.Text;

public static class CloudTextTranslationService
{
    public static void Main()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();

        TranslateText(lwClient);
        TranslateTextWithLinguisticOptions(lwClient);
    }

    private static void TranslateText(CloudLanguageWeaverClient lwClient)
    {
        var translateTextRequest = new CloudTranslateTextRequest
        {
            SourceLanguageId = "eng",
            TargetLanguageId = "fra",
            Model = "generic",
            Input = new List<string>
            {
                "The weather is wonderful today!",
                "This is a new input that is part of an array translation."
            },
            InputFormat = Format.Plain,
            Dictionaries = new List<string>()
            {
                "689f06cf-36ba-4903-a530-da1f7766f478",
                "3d297ee3-0878-4ef7-9ee7-ca14b48e6956"
            }
        };

        CloudTranslationTextResult translateTextResult = lwClient.TranslateText(translateTextRequest);
        translateTextResult.Translation.ForEach(Console.WriteLine);
    }

    private static void TranslateTextWithLinguisticOptions(CloudLanguageWeaverClient lwClient)
    {
        CloudTranslateTextRequest translateTextRequest = new CloudTranslateTextRequest()
        {
            SourceLanguageId = "fra",
            TargetLanguageId = "eng",
            Model = "generic",
            Input = new List<string> { "j'aime cette couleur" },
            InputFormat = Format.Plain,
            LinguisticOptions = new Dictionary<string, string>
            {
                { "Spelling", "UK" }
            },
            Dictionaries = new List<string>
            {
                "689f06cf-36ba-4903-a530-da1f7766f478",
                "3d297ee3-0878-4ef7-9ee7-ca14b48e6956"
            }
        };

        var translateTextResult = lwClient.TranslateText(translateTextRequest);
        translateTextResult.Translation.ForEach(Console.WriteLine);
    }
}