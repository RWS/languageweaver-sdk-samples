const SdkFactory = require("@language-weaver/lw-sdk-js").default;
const {
    ClientConfiguration,
    ContentInsightsRequest,
} = require("@language-weaver/lw-sdk-js");

const getContentInsightsForTranslations = async () => {
    try {
        const lwClient = await SdkFactory.getLanguageWeaverClient(new ClientConfiguration());
        const contentInsightsRequest = new ContentInsightsRequest();
        contentInsightsRequest.addTranslationId("translationId");

        const contentInsightsResult = await lwClient.getContentInsightsForTranslations(contentInsightsRequest);
        console.log(contentInsightsResult);
    } catch (e) {
        console.log(e);
    }
}

getContentInsightsForTranslations();