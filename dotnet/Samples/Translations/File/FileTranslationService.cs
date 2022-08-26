using LanguageWeaver.Sdk.Configurations;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.Translate.Request;

namespace LanguageWeaver.Sdk.Samples.Translations.File;

public class FileTranslationService
{
    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());
        var translateFileRequest = new TranslateFileRequest
        {
            SourceLanguageId = "eng",
            TargetLanguageId = "fra",
            Model = "generic",
            PdfConverter = PdfConverter.ABBYY,
            InputFormat = "pdf",
            Dictionaries = new List<string>
            {
               // provide list of dictionaries
            },
            // provide full path to the source and output file
           InputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                           "Resources", "Input", "input.pdf"), 
           OutputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                           "Resources", "Output", "input-translated.docx")
        };

        var translateFileResult = lwClient.TranslateFile(translateFileRequest);
        // handle result
    }
}