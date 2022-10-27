using LanguageWeaver.Sdk.Translate.Result.Cloud;

namespace LanguageWeaver.Sdk.Samples.Lps;

public static class CloudLanguagePairService
{
    public static void Main()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();
        CloudLanguagePairsResult languagePairsResult = lwClient.GetCloudLanguagePairs();

        languagePairsResult.LanguagePairs
            .ForEach(languagePair => Console.WriteLine(languagePair.Name));
    }
}