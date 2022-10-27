import {
    ClientConfiguration,
    CloudDeleteFeedbackRequest,
    CloudLanguageWeaverClient,
    CredentialsConfiguration
} from "@language-weaver/lw-sdk-js";

export const deleteCloudFeedback = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const deleteRequest = new CloudDeleteFeedbackRequest();
        deleteRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        await cloudLanguageWeaverClient.deleteCloudFeedback(deleteRequest);
    } catch (e) {
        console.log(e);
    }
}