using LanguageWeaver.Sdk.Common.Edge;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.LanguageDetection.Edge.Request;

namespace LanguageWeaver.Sdk.Samples.LanguageDetection.Text;

public class EdgeLanguageDetectionService
{
    public static void Main()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();
        var edgeTextLanguageDetectionRequest = new EdgeTextLanguageDetectionRequest()
        {
            Input = "A mountain is generally steeper than a hill",
            InputFormat = Format.Plain,
            Encoding = "UTF-8"
        };

        var edgeLanguageDetectionResult = lwClient.DetectLanguage(edgeTextLanguageDetectionRequest);

        edgeLanguageDetectionResult.Languages
            .ForEach(language => Console.WriteLine(language.Name));
    }
}