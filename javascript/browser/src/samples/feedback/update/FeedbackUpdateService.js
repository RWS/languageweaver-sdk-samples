import SdkFactory, {
    ClientConfiguration,
    CredentialsConfiguration,
    UpdateFeedbackRequest
} from "@language-weaver/lw-sdk-js";

export const updateFeedback = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);
        const updateRequest = new UpdateFeedbackRequest();
        updateRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        updateRequest.suggestedTranslation = "Ceci est un exemple de texte d'entrée.";
        updateRequest.addComment("This is a sample feedback entry for documentation.");
        const feedbackResult = await lwClient.updateFeedback(updateRequest);
        console.log(feedbackResult);
    } catch (e) {
        console.log(e);
    }
}