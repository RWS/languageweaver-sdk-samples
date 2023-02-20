using LanguageWeaver.Sdk.Common;
using LanguageWeaver.Sdk.Configurations;
using LanguageWeaver.Sdk.Dictionaries.Common.Result;

namespace LanguageWeaver.Sdk.Samples.Dictionaries;

public static class DictionaryService
{
    public static readonly int PAGE_NUMBER = 1;
    public static readonly int PAGE_SIZE = 100;

    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());
        DictionariesResult dictionariesResult = lwClient.GetDictionaries(PAGE_NUMBER, PAGE_SIZE);

        dictionariesResult.Dictionaries
            .ForEach(dictionary => Console.WriteLine(dictionary.Id));
    }
}