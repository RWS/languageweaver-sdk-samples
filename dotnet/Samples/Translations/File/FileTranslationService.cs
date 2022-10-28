﻿using LanguageWeaver.Sdk.Configurations;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.Translate.Request;
using LanguageWeaver.Sdk.Translate.Result;

namespace LanguageWeaver.Sdk.Samples.Translations.File;

public class FileTranslationService
{
    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());
        SdkFactoryFileTranslation(lwClient);
        SdkFactoryFileTranslationWithPdfConverter(lwClient);
    }

    private static void SdkFactoryFileTranslation(ILanguageWeaverClient lwClient)
    {
        var translateFileRequest = new TranslateFileRequest
        {
            SourceLanguageId = "eng",
            TargetLanguageId = "fra",
            Model = "generic",
            InputFormat = Format.Plain,
            Dictionaries = new List<string>
            {
                // provide list of dictionaries
            },
            // provide full path to the source and output file
            InputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Input", "input1.txt"),
            OutputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Output", "input1-translated.txt")
        };

        TranslationFileResult translateFileResult = lwClient.TranslateFile(translateFileRequest);
        // handle result
    }

    private static void SdkFactoryFileTranslationWithPdfConverter(ILanguageWeaverClient lwClient)
    {
        var translateFileRequest = new TranslateFileRequest
        {
            SourceLanguageId = "eng",
            TargetLanguageId = "fra",
            Model = "generic",
            InputFormat = Format.Pdf,
            PdfConverter = PdfConverter.ABBYY,
            Dictionaries = new List<string>
            {
                // provide list of dictionaries
            },
            // provide full path to the source and output file
            InputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Input", "input1.pdf"),
            OutputFile = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName,
                "Resources", "Output", "input1-translated.docx")
        };

        TranslationFileResult translateFileResult = lwClient.TranslateFile(translateFileRequest);
        // handle result
    }
}