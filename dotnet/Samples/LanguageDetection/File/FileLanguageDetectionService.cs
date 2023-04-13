using LanguageWeaver.Sdk.Common;
using LanguageWeaver.Sdk.Configurations;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.LanguageDetection.Common.Request;

namespace LanguageWeaver.Sdk.Samples.LanguageDetection.File;

public class FileLanguageDetectionService
{
    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());
        var fileLanguageDetectionRequest = new FileLanguageDetectionRequest()
        {
            InputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Input", "input1.txt"),
            InputFormat = Format.Plain
        };

        var languageDetectionResult = lwClient.DetectLanguage(fileLanguageDetectionRequest);

        languageDetectionResult.Languages
            .ForEach(language => Console.WriteLine(language.Name));
    }
}