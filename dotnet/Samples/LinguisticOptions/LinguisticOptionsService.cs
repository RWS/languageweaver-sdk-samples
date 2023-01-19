using LanguageWeaver.Sdk.Common;
using LanguageWeaver.Sdk.Configurations;
using LanguageWeaver.Sdk.Translate.Common.Request.LinguisticOptions;
using LanguageWeaver.Sdk.Translate.Common.Result.LinguisticOptions;

namespace LanguageWeaver.Sdk.Samples.LinguisticOptions;

public class LinguisticOptionsService
{
    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());

        GetLinguisticOptionsRequest getLinguisticOptionsRequest = new GetLinguisticOptionsRequest()
        {
            SourceLanguageId = "chi",
            TargetLanguageId = "eng",
            Model = "generic"
        };

        LinguisticOptionsResult linguisticOptionsResult = lwClient.GetLinguisticOptions(getLinguisticOptionsRequest);
        //handle result
    }
}