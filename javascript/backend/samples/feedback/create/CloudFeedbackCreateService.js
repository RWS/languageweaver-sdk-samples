const {CloudLanguageWeaverClient, CloudCreateFeedbackRequest, QualityEstimation} = require("@language-weaver/lw-sdk-js");

const createFeedback = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
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

createFeedback();