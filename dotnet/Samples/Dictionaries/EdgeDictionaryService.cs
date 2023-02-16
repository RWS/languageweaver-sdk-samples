using LanguageWeaver.Sdk.Common.Edge;
using LanguageWeaver.Sdk.Dictionaries.Edge.Result;

namespace LanguageWeaver.Sdk.Samples.Dictionaries;

public static class EdgeDictionaryService
{
    public static readonly int PAGE_NUMBER = 1;
    public static readonly int PAGE_SIZE = 100;

    public static void Main()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();
        EdgeDictionariesResult dictionariesResult = lwClient.GetEdgeDictionaries(PAGE_NUMBER, PAGE_SIZE);

        dictionariesResult.Dictionaries
            .ForEach(dictionary => Console.WriteLine(dictionary.DictionaryId));
    }
}