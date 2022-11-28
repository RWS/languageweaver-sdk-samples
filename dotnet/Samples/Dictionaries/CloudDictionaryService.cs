using LanguageWeaver.Sdk.Common.Cloud;
using LanguageWeaver.Sdk.Translate.Cloud.Result;

namespace LanguageWeaver.Sdk.Samples.Dictionaries;

public static class CloudDictionaryService
{
    public static readonly int PAGE_NUMBER = 1;
    public static readonly int PAGE_SIZE = 100;

    public static void Main()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();
        CloudDictionariesResult dictionariesResult = lwClient.GetCloudDictionaries(PAGE_NUMBER, PAGE_SIZE);

        dictionariesResult.Dictionaries
            .ForEach(dictionary => Console.WriteLine(dictionary.DictionaryId));
    }
}