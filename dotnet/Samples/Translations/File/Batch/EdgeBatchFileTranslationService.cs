using LanguageWeaver.Sdk.Translate.Request.Edge;

namespace LanguageWeaver.Sdk.Samples.Translations.File.Batch;

public class EdgeBatchFileTranslationService
{
    public static void Main()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();
        var translateBatchFileRequest = new EdgeTranslateBatchFileRequest
        {
            LanguagePairId = "EngFra_Generic_SRV_TNMV_8_5_x_1",
            Dictionaries = new List<string>
            {
                "DictionaryName1",
                "DictionaryName2"
            },
            // provide full path to the input and output folders
            InputBatchFolderPath = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName, 
                "Resources", "Input"),
            OutputBatchFolderPath = Path.Combine(Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName, 
                "Resources", "Output")
        };

        lwClient.TranslateBatchFile(translateBatchFileRequest);
    }
}