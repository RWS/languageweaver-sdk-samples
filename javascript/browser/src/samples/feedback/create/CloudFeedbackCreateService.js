import {
    ClientConfiguration,
    CloudCreateFeedbackRequest,
    CloudLanguageWeaverClient, CredentialsConfiguration,
    QualityEstimation
} from "@language-weaver/lw-sdk-js";

export const createCloudFeedback = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const createRequest = new CloudCreateFeedbackRequest();
        createRequest.sourceLanguageId = "eng";
        createRequest.targetLanguageId = "fra";
        createRequest.model = "generic";
        createRequest.sourceText = "This is a sample input text.";
        createRequest.targetText = "C'est un exemple de texte d'entrée.";
        createRequest.suggestedTranslation = "Ceci est un exemple de texte d'entrée.";
        createRequest.addComment("This is a sample feedback entry for documentation.");
        createRequest.translationMetadata = "source.txt";
        createRequest.numberOfSegments = 1;
        createRequest.rating = 4;
        createRequest.qualityEstimationMT = QualityEstimation.GOOD;
        createRequest.qualityEstimation = QualityEstimation.ADEQUATE;
        const feedbackResult = await cloudLanguageWeaverClient.createCloudFeedback(createRequest);
        console.log(feedbackResult);
    } catch (e) {
        console.log(e);
    }
}