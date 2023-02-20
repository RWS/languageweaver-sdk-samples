const {EdgeLanguageWeaverClient, ApprovalStatus, EdgeUpdateFeedbackApprovalRequest} = require("@language-weaver/lw-sdk-js");

const updateFeedbackApproval = async () => {
    try {
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const updateRequest = new EdgeUpdateFeedbackApprovalRequest();
        updateRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        updateRequest.approvalStatus = ApprovalStatus.APPROVED;
        const feedbackResult = await edgeLanguageWeaverClient.updateEdgeFeedbackApproval(updateRequest);
        console.log(feedbackResult);
    } catch (e) {
        console.log(e);
    }
}

updateFeedbackApproval();