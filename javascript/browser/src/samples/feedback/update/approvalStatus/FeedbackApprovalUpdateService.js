import SdkFactory, {
    ApprovalStatus,
    ClientConfiguration, CredentialsConfiguration,
    UpdateFeedbackApprovalRequest
} from "@language-weaver/lw-sdk-js";

export const updateFeedbackApproval = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);
        const updateRequest = new UpdateFeedbackApprovalRequest();
        updateRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        updateRequest.approvalStatus = ApprovalStatus.APPROVED;
        const feedbackResult = await lwClient.updateFeedbackApproval(updateRequest);
        console.log(feedbackResult);
    } catch (e) {
        console.log(e);
    }
}