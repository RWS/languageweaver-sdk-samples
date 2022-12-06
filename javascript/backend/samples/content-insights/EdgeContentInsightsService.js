const {
    EdgeContentInsightsForTranslationRequest,
    EdgeLanguageWeaverClient
} = require("@language-weaver/lw-sdk-js");

const getContentInsightsForTranslations = async () => {
    try {
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const contentInsightsForTranslationsRequest = new EdgeContentInsightsForTranslationRequest();
        contentInsightsForTranslationsRequest.translationId = "translationId";

        const contentInsightsResult = await edgeLanguageWeaverClient.getEdgeContentInsightsResultForTranslation(contentInsightsForTranslationsRequest);
        console.log(contentInsightsResult);
    } catch (e) {
        console.log(e);
    }
}

getContentInsightsForTranslations();