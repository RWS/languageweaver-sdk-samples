using LanguageWeaver.Sdk.Common;
using LanguageWeaver.Sdk.Configurations;
using LanguageWeaver.Sdk.Translate.Common.Result;

namespace LanguageWeaver.Sdk.Samples.Lps;

public static class LanguagePairService
{
    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());
        LanguagePairsResult languagePairsResult = lwClient.GetLanguagePairs();

        languagePairsResult.LanguagePairs
            .ForEach(languagePair => Console.WriteLine(languagePair.Name));
    }
}