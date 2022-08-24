using LanguageWeaver.Sdk.Configurations;
using LanguageWeaver.Sdk.Translate.Result;

namespace LanguageWeaver.Sdk.Samples.Dictionaries;

public static class DictionaryService
{
    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());
        DictionariesResult dictionariesResult = lwClient.GetDictionaries();

        dictionariesResult.Dictionaries
            .ForEach(dictionary => Console.WriteLine(dictionary.Id));
    }
}