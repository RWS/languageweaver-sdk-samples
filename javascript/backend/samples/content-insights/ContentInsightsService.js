const SdkFactory = require("@language-weaver/lw-sdk-js").default;
const {
    ClientConfiguration,
    ContentInsightsForTranslationRequest
} = require("@language-weaver/lw-sdk-js");

const getContentInsightsForTranslations = async () => {
    try {
        const lwClient = await SdkFactory.getLanguageWeaverClient(new ClientConfiguration());
        const contentInsightsForTranslationsRequest = new ContentInsightsForTranslationRequest();
        contentInsightsForTranslationsRequest.addTranslationId("translationId");

        const contentInsightsResult = await lwClient.getContentInsightsForTranslations(contentInsightsForTranslationsRequest);
        console.log(contentInsightsResult);
    } catch (e) {
        console.log(e);
    }
}

getContentInsightsForTranslations();