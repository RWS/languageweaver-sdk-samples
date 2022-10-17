const SdkFactory = require("@language-weaver/lw-sdk-js").default;
const {ClientConfiguration, UpdateFeedbackRequest} = require("@language-weaver/lw-sdk-js");

const updateFeedback = async () => {
    try {
        const lwClient = await SdkFactory.getLanguageWeaverClient(new ClientConfiguration());
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

updateFeedback();