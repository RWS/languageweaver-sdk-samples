const {
    EdgeLanguageWeaverClient,
    EdgeContentInsightsRequest
} = require("@language-weaver/lw-sdk-js");

const getContentInsightsForTranslations = async () => {
    try {
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const edgeContentInsightsRequest = new EdgeContentInsightsRequest();
        edgeContentInsightsRequest.translationId = "translationId";

        const contentInsightsResult = await edgeLanguageWeaverClient.getEdgeContentInsightsResultForTranslation(edgeContentInsightsRequest);
        console.log(contentInsightsResult);
    } catch (e) {
        console.log(e);
    }
}

getContentInsightsForTranslations();