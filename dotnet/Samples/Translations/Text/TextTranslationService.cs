﻿using LanguageWeaver.Sdk.Common;
using LanguageWeaver.Sdk.Configurations;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.Translate.Common.Request;
using LanguageWeaver.Sdk.Translate.Common.Result;

namespace LanguageWeaver.Sdk.Samples.Translations.Text;

public class TextTranslationService
{
    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());
        var translateTextRequest = new TranslateTextRequest
        {
            SourceLanguageId = "eng",
            TargetLanguageId = "fra",
            Model = "generic",
            Input = new List<string>
            {
                "The weather is wonderful today!"
            },
            InputFormat = Format.Plain,
            Dictionaries = new List<string>
            {
                // provide list of dictionaries
            }
        };

        TranslateTextResult translateTextResult = lwClient.TranslateText(translateTextRequest);
        Console.WriteLine(translateTextResult.Translation);
    }
}