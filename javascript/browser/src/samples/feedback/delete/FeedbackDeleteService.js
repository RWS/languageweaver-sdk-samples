import SdkFactory, {
    ClientConfiguration,
    CredentialsConfiguration,
    DeleteFeedbackRequest
} from "@language-weaver/lw-sdk-js";

export const deleteFeedback = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);
        const deleteRequest = new DeleteFeedbackRequest();
        deleteRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        await lwClient.deleteFeedback(deleteRequest);
    } catch (e) {
        console.log(e);
    }
}