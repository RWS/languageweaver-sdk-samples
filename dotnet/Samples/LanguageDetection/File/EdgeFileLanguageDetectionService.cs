using LanguageWeaver.Sdk.Common.Edge;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.LanguageDetection.Edge.Request;

namespace LanguageWeaver.Sdk.Samples.LanguageDetection.File;

public class EdgeFileLanguageDetectionService
{
    public static void Main()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();
        var edgeFileLanguageDetectionRequest = new EdgeFileLanguageDetectionRequest()
        {
            InputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Input", "input1.txt"),
            InputFormat = Format.Plain,
            Encoding = "UTF-8"
        };

        var edgeLanguageDetectionResult = lwClient.DetectLanguage(edgeFileLanguageDetectionRequest);

        edgeLanguageDetectionResult.Languages
            .ForEach(language => Console.WriteLine(language.Name));
    }
}