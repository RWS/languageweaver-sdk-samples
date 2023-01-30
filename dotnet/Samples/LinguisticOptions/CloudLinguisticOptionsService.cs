using LanguageWeaver.Sdk.Common.Cloud;
using LanguageWeaver.Sdk.LinguisticOptions.Cloud.Request;
using LanguageWeaver.Sdk.LinguisticOptions.Cloud.Result;

namespace LanguageWeaver.Sdk.Samples.LinguisticOptions;

public class CloudLinguisticOptionsService
{
    public static void Main()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();

        CloudGetLinguisticOptionsRequest cloudGetLinguisticOptionsRequest = new CloudGetLinguisticOptionsRequest()
        {
            SourceLanguageId = "chi",
            TargetLanguageId = "eng",
            Model = "generic"
        };
        CloudLinguisticOptionsResult cloudLinguisticOptionsResult =
            lwClient.GetCloudLinguisticOptions(cloudGetLinguisticOptionsRequest);
        // handle result
    }
}