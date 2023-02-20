const {
    CloudLanguageWeaverClient,
    CloudFileContentInsightsRequest,
    CloudContentInsightsRequest,
} = require("@language-weaver/lw-sdk-js");
const path = require("path");

const getContentInsights = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const cloudFileContentInsightsRequest = new CloudFileContentInsightsRequest();
        cloudFileContentInsightsRequest.sourceLanguage = "eng";
        cloudFileContentInsightsRequest.files = path.resolve("resources/input/input1.txt");

        const contentInsightsResult = await cloudLanguageWeaverClient.getCloudContentInsights(cloudFileContentInsightsRequest);
        console.log(contentInsightsResult);
    } catch (e) {
        console.log(e);
    }
}

const getContentInsightsForTranslations = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const cloudContentInsightsRequest = new CloudContentInsightsRequest();
        cloudContentInsightsRequest.addTranslationId("translationId");

        const contentInsightsResult = await cloudLanguageWeaverClient.getCloudContentInsightsForTranslations(cloudContentInsightsRequest);
        console.log(contentInsightsResult);
    } catch (e) {
        console.log(e);
    }
}

getContentInsights();
getContentInsightsForTranslations();