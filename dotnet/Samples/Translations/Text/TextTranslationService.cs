using LanguageWeaver.Sdk.Configurations;
using LanguageWeaver.Sdk.Translate.Request;

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
                "The weather is wonderful today!",
                "This is a new input that is part of an array translation."
            },
            InputFormat = "plain",
            Dictionaries = new List<string>
            {
                "689f06cf-36ba-4903-a530-da1f7766f478",
                "3d297ee3-0878-4ef7-9ee7-ca14b48e6956"
            }
        };

        var translateTextResult = lwClient.TranslateText(translateTextRequest);
        Console.WriteLine(translateTextResult.Translation);
    }
}