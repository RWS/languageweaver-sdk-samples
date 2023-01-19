using LanguageWeaver.Sdk.Common.Edge;
using LanguageWeaver.Sdk.Translate.Edge.Request.LinguisticOptions;
using LanguageWeaver.Sdk.Translate.Edge.Result.LinguisticOptions;

namespace LanguageWeaver.Sdk.Samples.LinguisticOptions;

public class EdgeLinguisticOptionsService
{
    public static void Main()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();

        EdgeGetLinguisticOptionsRequest edgeGetLinguisticOptionsRequest = new EdgeGetLinguisticOptionsRequest()
        {
            SourceLanguageId = "chi",
            TargetLanguageId = "eng",
            Model = "Generic"
//            Platform = "SRV",
//            Technology = "TNMV"
        };

        EdgeLinguisticOptionsResult edgeLinguisticOptionsResult =
            lwClient.GetEdgeLinguisticOptions(edgeGetLinguisticOptionsRequest);
        // handle result
    }
}