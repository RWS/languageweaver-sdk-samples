const {CloudLanguageWeaverClient, CloudUpdateFeedbackRequest, QualityEstimation} = require("@language-weaver/lw-sdk-js");

const updateFeedback = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const updateRequest = new CloudUpdateFeedbackRequest();
        updateRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        updateRequest.suggestedTranslation = "Ceci est un exemple de texte d'entrée.";
        updateRequest.selectedText = "Ceci est";
        updateRequest.rating = 5;
        updateRequest.qualityEstimation = QualityEstimation.GOOD;
        updateRequest.addComment("This is a sample feedback entry for documentation.");
        const feedbackResult = await cloudLanguageWeaverClient.updateCloudFeedback(updateRequest);
        console.log(feedbackResult);
    } catch (e) {
        console.log(e);
    }
}

updateFeedback();