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
}