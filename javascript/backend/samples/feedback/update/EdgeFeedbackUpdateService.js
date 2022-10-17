const {EdgeLanguageWeaverClient, EdgeUpdateFeedbackRequest, ApprovalStatus} = require("@language-weaver/lw-sdk-js");

const updateFeedback = async () => {
    try {
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const updateRequest = new EdgeUpdateFeedbackRequest();
        updateRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        updateRequest.suggestedTranslation = "Ceci est un exemple de texte d'entrée.";
        updateRequest.addComment("This is a sample feedback entry for documentation.");
        updateRequest.approvalState = ApprovalStatus.PENDING;
        const feedbackResult = await edgeLanguageWeaverClient.updateEdgeFeedback(updateRequest);
        console.log(feedbackResult)
    } catch (e) {
        console.log(e);
    }
}

updateFeedback();