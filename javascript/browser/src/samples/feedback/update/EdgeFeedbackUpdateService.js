import {
    ApprovalStatus,
    ClientConfiguration, CredentialsConfiguration,
    EdgeLanguageWeaverClient,
    EdgeUpdateFeedbackRequest
} from "@language-weaver/lw-sdk-js";

export const updateEdgeFeedback = async clientId => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId);
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
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