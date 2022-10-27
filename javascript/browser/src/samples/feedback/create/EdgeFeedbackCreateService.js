import {
    ApprovalStatus,
    ClientConfiguration, CredentialsConfiguration,
    EdgeCreateFeedbackRequest,
    EdgeLanguageWeaverClient
} from "@language-weaver/lw-sdk-js";

export const createEdgeFeedback = async clientId => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId);
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const createRequest = new EdgeCreateFeedbackRequest();
        createRequest.languagePairId = "EngFra_Generic_Cloud";
        createRequest.model = "generic";
        createRequest.sourceText = "This is a sample input text.";
        createRequest.targetText = "C'est un exemple de texte d'entrée.";
        createRequest.suggestedTranslation = "Ceci est un exemple de texte d'entrée.";
        createRequest.addComment("This is a sample feedback entry for documentation.");
        createRequest.approvalState = ApprovalStatus.APPROVED;
        const feedbackResult = await edgeLanguageWeaverClient.createEdgeFeedback(createRequest);
        console.log(feedbackResult);
    } catch (e) {
        console.log(e);
    }
}