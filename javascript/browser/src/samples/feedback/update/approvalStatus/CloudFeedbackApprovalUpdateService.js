import {
    ApprovalStatus, ClientConfiguration,
    CloudLanguageWeaverClient,
    CloudUpdateFeedbackApprovalRequest, CredentialsConfiguration
} from "@language-weaver/lw-sdk-js";

export const updateCloudFeedbackApproval = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const updateRequest = new CloudUpdateFeedbackApprovalRequest();
        updateRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        updateRequest.approvalStatus = ApprovalStatus.APPROVED;
        const feedbackResult = await cloudLanguageWeaverClient.updateCloudFeedbackApproval(updateRequest);
        console.log(feedbackResult);
    } catch (e) {
        console.log(e);
    }
}