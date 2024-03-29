﻿using LanguageWeaver.Sdk.Common.Edge;
using LanguageWeaver.Sdk.LanguagePairs.Edge.Result;

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