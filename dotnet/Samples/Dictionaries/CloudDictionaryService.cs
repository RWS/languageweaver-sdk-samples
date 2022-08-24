using LanguageWeaver.Sdk.Translate.Result.Cloud;

namespace LanguageWeaver.Sdk.Samples.Dictionaries;

public static class CloudDictionaryService
{
    public static void Main()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();
        CloudDictionariesResult dictionariesResult = lwClient.GetCloudDictionaries();

        dictionariesResult.Dictionaries
            .ForEach(dictionary => Console.WriteLine(dictionary.DictionaryId));
    }
}