using LanguageWeaver.Sdk.Common.Cloud;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.LanguageDetection.Cloud.Request;

namespace LanguageWeaver.Sdk.Samples.LanguageDetection.Text;

public class CloudLanguageDetectionService
{
    public static void Main()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();

        var cloudTextLanguageDetectionRequest = new CloudTextLanguageDetectionRequest()
        {
            Input = "A mountain is generally steeper than a hill",
            InputFormat = Format.Plain
        };

        var cloudLanguageDetectionResult = lwClient.DetectLanguage(cloudTextLanguageDetectionRequest);

        cloudLanguageDetectionResult.Languages
            .ForEach(language => Console.WriteLine(language.Name));
    }
}