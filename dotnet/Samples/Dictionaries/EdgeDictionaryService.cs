using LanguageWeaver.Sdk.Translate.Result.Edge;

namespace LanguageWeaver.Sdk.Samples.Dictionaries;

public static class EdgeDictionaryService
{
    public static void Main()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();
        EdgeDictionariesResult dictionariesResult = lwClient.GetEdgeDictionaries();

        dictionariesResult.Dictionaries
            .ForEach(dictionary => Console.WriteLine(dictionary.DictionaryId));
    }
}