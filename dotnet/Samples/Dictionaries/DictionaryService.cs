using LanguageWeaver.Sdk.Configurations;

namespace LanguageWeaver.Sdk.Samples.Dictionaries;

public static class DictionaryService
{
    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());
        var dictionariesResult = lwClient.GetDictionaries();

        dictionariesResult.Dictionaries
            .ForEach(dictionary => Console.WriteLine(dictionary.Id));
    }
}