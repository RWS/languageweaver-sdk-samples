namespace LanguageWeaver.Sdk.Samples.Lps;

public static class CloudLanguagePairService
{
    public static void Main()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();
        var languagePairsResult = lwClient.GetCloudLanguagePairs();

        languagePairsResult.LanguagePairs
            .ForEach(languagePair => Console.WriteLine(languagePair.Name));
    }
}