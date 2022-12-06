const {
    CloudContentInsightsRequest,
    CloudLanguageWeaverClient,
    ContentInsightsForTranslationRequest
} = require("@language-weaver/lw-sdk-js");
const path = require("path");

const getContentInsights = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const contentInsightsRequest = new CloudContentInsightsRequest();
        contentInsightsRequest.sourceLanguage = "eng";
        contentInsightsRequest.files = path.resolve("resources/input/input1.txt");

        const contentInsightsResult = await cloudLanguageWeaverClient.getCloudContentInsights(contentInsightsRequest);
        console.log(contentInsightsResult);
    } catch (e) {
        console.log(e);
    }
}

const getContentInsightsForTranslations = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const contentInsightsForTranslationsRequest = new ContentInsightsForTranslationRequest();
        contentInsightsForTranslationsRequest.addTranslationId("translationId");

        const contentInsightsResult = await cloudLanguageWeaverClient.getCloudContentInsightsForTranslations(contentInsightsForTranslationsRequest);
        console.log(contentInsightsResult);
    } catch (e) {
        console.log(e);
    }
}

getContentInsights();
getContentInsightsForTranslations();