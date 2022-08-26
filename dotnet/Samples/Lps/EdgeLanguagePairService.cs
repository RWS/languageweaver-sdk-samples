using LanguageWeaver.Sdk.Translate.Result.Edge;

namespace LanguageWeaver.Sdk.Samples.Lps;

public static class EdgeLanguagePairService
{
    public static void Main()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();
        EdgeLanguagePairsResult languagePairsResult = lwClient.GetEdgeLanguagePairs();

        languagePairsResult.LanguagePairs
            .ForEach(languagePair => Console.WriteLine(languagePair.LanguagePairId));
    }
}