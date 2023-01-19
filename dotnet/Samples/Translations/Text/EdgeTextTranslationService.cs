using System.Text;
using LanguageWeaver.Sdk.Common.Edge;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.Translate.Edge.Request;
using LanguageWeaver.Sdk.Translate.Edge.Result;

namespace LanguageWeaver.Sdk.Samples.Translations.Text;

public static class EdgeTextTranslationService
{
    public static void Main()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();

        TranslateText(lwClient);
        TranslateTextWithLinguisticOptions(lwClient);
    }

    private static void TranslateText(EdgeLanguageWeaverClient lwClient)
    {
        var translateTextRequest = new EdgeTranslateTextRequest
        {
            LanguagePairId = "EngFra_Generic_SRV_TNMV_8_5_x_1",
            Input = new List<string>
            {
                "The weather is wonderful today!"
            },
            InputFormat = Format.Plain,
            Dictionaries = new List<string>
            {
                "DictionaryName1",
                "DictionaryName2"
            }
        };

        EdgeTranslationTextResult translateTextResult = lwClient.TranslateText(translateTextRequest);
        Console.WriteLine(translateTextResult.Translation);
    }

    private static void TranslateTextWithLinguisticOptions(EdgeLanguageWeaverClient lwClient)
    {
        Dictionary<string, string> linguisticOptions = new Dictionary<string, string>();
        linguisticOptions.Add("formality", "Formal");

        var translateTextRequest = new EdgeTranslateTextRequest()
        {
            LanguagePairId = "EngJpn_Generic_SRV_TNMV_8_5_x_6",
            Input = new List<string> { "It was a long journey, so I'm really tired now" },
            LinguisticOptions = linguisticOptions,
            InputFormat = Format.Plain,
            Dictionaries = new List<string>
            {
                "DictionaryName1",
                "DictionaryName2"
            }
        };

        EdgeTranslationTextResult translateTextResult = lwClient.TranslateText(translateTextRequest);
        Console.OutputEncoding = Encoding.UTF8;
        Console.WriteLine(translateTextResult.Translation);
    }
}