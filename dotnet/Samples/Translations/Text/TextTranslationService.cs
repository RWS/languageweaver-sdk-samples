using LanguageWeaver.Sdk.Configurations;
using LanguageWeaver.Sdk.Translate.Request;
using LanguageWeaver.Sdk.Translate.Result;

namespace LanguageWeaver.Sdk.Samples.Translations.Text;

public class TextTranslationService
{
    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());
        var translateTextRequest = new TranslateTextRequest
        {
            SourceLanguageId = "eng",
            TargetLanguageId = "fra",
            Model = "generic",
            Input = new List<string>
            {
                "The weather is wonderful today!"
            },
            InputFormat = "plain",
            Dictionaries = new List<string>
            {
                // provide list of dictionaries
            }
        };

        TranslateTextResult translateTextResult = lwClient.TranslateText(translateTextRequest);
        Console.WriteLine(translateTextResult.Translation);
    }
}