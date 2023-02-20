import SdkFactory, {
    ClientConfiguration,
    CreateFeedbackRequest,
    CredentialsConfiguration
} from "@language-weaver/lw-sdk-js";

export const createFeedback = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);
        const createRequest = new CreateFeedbackRequest();
        createRequest.sourceLanguageId = "eng";
        createRequest.targetLanguageId = "fra";
        createRequest.model = "generic";
        createRequest.sourceText = "This is a sample input text.";
        createRequest.targetText = "C'est un exemple de texte d'entrée.";
        createRequest.suggestedTranslation = "Ceci est un exemple de texte d'entrée.";
        createRequest.addComment("This is a sample feedback entry for documentation.");
        const feedbackResult = await lwClient.createFeedback(createRequest);
        console.log(feedbackResult);
    } catch (e) {
        console.log(e);
    }
}