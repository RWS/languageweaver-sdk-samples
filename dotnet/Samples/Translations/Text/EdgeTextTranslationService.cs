using LanguageWeaver.Sdk.Translate.Request.Edge;

namespace LanguageWeaver.Sdk.Samples.Translations.Text;

public static class EdgeTextTranslationService
{
    public static void Main()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();
        var translateTextRequest = new EdgeTranslateTextRequest
        {
            LanguagePairId = "EngFra_Generic_SRV_TNMV_8_5_x_1",
            Input = new List<string>
            {
                "The weather is wonderful today!"
            },
            InputFormat = "text/plain",
            Dictionaries = new List<string>
            {
                "DictionaryName1",
                "DictionaryName2"
            }
        };

        var translateTextResult = lwClient.TranslateText(translateTextRequest);
        Console.WriteLine(translateTextResult.Translation);
    }
}