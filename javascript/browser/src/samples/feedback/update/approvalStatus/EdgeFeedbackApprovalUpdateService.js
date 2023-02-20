import {
    ApprovalStatus,
    ClientConfiguration, CredentialsConfiguration,
    EdgeLanguageWeaverClient,
    EdgeUpdateFeedbackApprovalRequest
} from "@language-weaver/lw-sdk-js";

export const updateEdgeFeedbackApproval = async clientId => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId);
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const updateRequest = new EdgeUpdateFeedbackApprovalRequest();
        updateRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        updateRequest.approvalStatus = ApprovalStatus.APPROVED;
        const feedbackResult = await edgeLanguageWeaverClient.updateEdgeFeedbackApproval(updateRequest);
        console.log(feedbackResult);
    } catch (e) {
        console.log(e);
    }
}