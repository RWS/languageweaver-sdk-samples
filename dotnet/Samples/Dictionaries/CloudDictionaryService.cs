namespace LanguageWeaver.Sdk.Samples.Dictionaries;

public static class CloudDictionaryService
{
    public static void Main()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();
        var dictionariesResult = lwClient.GetCloudDictionaries();

        dictionariesResult.Dictionaries
            .ForEach(dictionary => Console.WriteLine(dictionary.DictionaryId));
    }
}