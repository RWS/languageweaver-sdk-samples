using LanguageWeaver.Sdk.Common.Cloud;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.LanguageDetection.Cloud.Request;

namespace LanguageWeaver.Sdk.Samples.LanguageDetection.File;

public class CloudFileLanguageDetectionService
{
    public static void Main()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();
        var cloudFileLanguageDetectionRequest = new CloudFileLanguageDetectionRequest()
        {
            InputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Input", "input1.txt"),
            InputFormat = Format.Plain
        };

        var cloudLanguageDetectionResult = lwClient.DetectLanguage(cloudFileLanguageDetectionRequest);

        cloudLanguageDetectionResult.Languages
            .ForEach(language => Console.WriteLine(language.Name));
    }
}