﻿using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.Translate.Request.Edge;

namespace LanguageWeaver.Sdk.Samples.Translations.File;

public class EdgeFileTranslationService
{
    public static void Main()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();
        var translateFileRequest = new EdgeTranslateFileRequest
        {
            LanguagePairId = "EngFra_Generic_SRV_TNMV_8_5_x_1",
            InputFormat = "application/pdf",
            PdfConverter = PdfConverter.STANDARD,
            Dictionaries = new List<string>
            {
                "DictionaryName1",
                "DictionaryName2"
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