using LanguageWeaver.Sdk.Common;
using LanguageWeaver.Sdk.Configurations;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.Translate.Common.Request;
using LanguageWeaver.Sdk.Translate.Common.Result;

namespace LanguageWeaver.Sdk.Samples.Translations.Text;

public class TextTranslationService
{
    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());

        TranslateText(lwClient);
        TranslateTextWithLinguisticOptions(lwClient);
    }

    private static void TranslateText(ILanguageWeaverClient lwClient)
    {
        var translateTextRequest = new TranslateTextRequest
        {
            SourceLanguageId = "eng",
            TargetLanguageId = "fra",
            Model = "generic",
            Input = new List<string>
            {
                "The weather is wonderful today!"
            },
            InputFormat = Format.Plain,
            Dictionaries = new List<string>
            {
                // provide list of dictionaries
            }
        };

        TranslateTextResult translateTextResult = lwClient.TranslateText(translateTextRequest);
        Console.WriteLine(translateTextResult.Translation);
    }

    private static void TranslateTextWithLinguisticOptions(ILanguageWeaverClient lwClient)
    {
        Dictionary<string, string> linguisticOptions = new Dictionary<string, string>();
        linguisticOptions.Add("Spelling", "UK");

        var translateTextRequest = new TranslateTextRequest()
        {
            SourceLanguageId = "fra",
            TargetLanguageId = "eng",
            Model = "generic",
            Input = new List<string> { "j'aime cette couleur" },
            LinguisticOptions = linguisticOptions,
            Dictionaries = new List<string>
            {
                // provide list of dictionaries
            },
            InputFormat = Format.Plain
        };

        var translateTextResult = lwClient.TranslateText(translateTextRequest);
        Console.WriteLine(translateTextResult.Translation);
    }
}