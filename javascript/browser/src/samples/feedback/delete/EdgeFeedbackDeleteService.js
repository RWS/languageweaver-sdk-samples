import {
    ClientConfiguration,
    CredentialsConfiguration,
    EdgeDeleteFeedbackRequest,
    EdgeLanguageWeaverClient
} from "@language-weaver/lw-sdk-js";

export const deleteEdgeFeedback = async clientId => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId);
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const deleteRequest = new EdgeDeleteFeedbackRequest();
        deleteRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        await edgeLanguageWeaverClient.deleteEdgeFeedback(deleteRequest);
    } catch (e) {
        console.log(e);
    }
}