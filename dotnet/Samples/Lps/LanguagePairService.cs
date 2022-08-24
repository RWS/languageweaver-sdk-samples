using LanguageWeaver.Sdk.Configurations;

namespace LanguageWeaver.Sdk.Samples.Lps;

public static class LanguagePairService
{
    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());
        var languagePairsResult = lwClient.GetLanguagePairs();

        languagePairsResult.LanguagePairs
            .ForEach(languagePair => Console.WriteLine(languagePair.Name));
    }
}