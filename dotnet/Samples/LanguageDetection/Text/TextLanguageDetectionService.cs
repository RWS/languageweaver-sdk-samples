using LanguageWeaver.Sdk.Common;
using LanguageWeaver.Sdk.Configurations;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.LanguageDetection.Common.Request;

namespace LanguageWeaver.Sdk.Samples.LanguageDetection.Text;

public class LanguageDetectionService
{
    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());
        var textLanguageDetectionRequest = new TextLanguageDetectionRequest()
        {
            Input = "A mountain is generally steeper than a hill",
            InputFormat = Format.Plain
        };

        var languageDetectionResult = lwClient.DetectLanguage(textLanguageDetectionRequest);

        languageDetectionResult.Languages
            .ForEach(language => Console.WriteLine(language.Name));
    }
}