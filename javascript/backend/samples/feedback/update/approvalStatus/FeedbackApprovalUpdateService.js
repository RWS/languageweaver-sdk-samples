const SdkFactory = require("@language-weaver/lw-sdk-js").default;
const {ClientConfiguration, UpdateFeedbackApprovalRequest, ApprovalStatus} = require("@language-weaver/lw-sdk-js");

const updateFeedbackApproval = async () => {
    try {
        const lwClient = await SdkFactory.getLanguageWeaverClient(new ClientConfiguration());
        const updateRequest = new UpdateFeedbackApprovalRequest();
        updateRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        updateRequest.approvalStatus = ApprovalStatus.APPROVED;
        const feedbackResult = await lwClient.updateFeedbackApproval(updateRequest);
        console.log(feedbackResult);
    } catch (e) {
        console.log(e);
    }
}

updateFeedbackApproval();