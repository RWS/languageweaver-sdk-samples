const {ApprovalStatus, CloudLanguageWeaverClient, CloudUpdateFeedbackApprovalRequest} = require("@language-weaver/lw-sdk-js");

const updateFeedbackApproval = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const updateRequest = new CloudUpdateFeedbackApprovalRequest();
        updateRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        updateRequest.approvalStatus = ApprovalStatus.APPROVED;
        const feedbackResult = await cloudLanguageWeaverClient.updateCloudFeedbackApproval(updateRequest);
        console.log(feedbackResult);
    } catch (e) {
        console.log(e);
    }
}

updateFeedbackApproval();