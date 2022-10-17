import {
    ClientConfiguration,
    CloudLanguageWeaverClient,
    CloudUpdateFeedbackRequest, CredentialsConfiguration,
    QualityEstimation
} from "@language-weaver/lw-sdk-js";

export const updateCloudFeedback = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const updateRequest = new CloudUpdateFeedbackRequest();
        updateRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        updateRequest.suggestedTranslation = "Ceci est un exemple de texte d'entrée.";
        updateRequest.selectedText = "Ceci est";
        updateRequest.rating = 5;
        updateRequest.qualityEstimation = QualityEstimation.GOOD;
        updateRequest.addComment("This is a sample feedback entry for documentation.");
        const feedbackResult = await cloudLanguageWeaverClient.updateCloudFeedback(updateRequest);
        console.log(feedbackResult);
    } catch (e) {
        console.log(e);
    }
}