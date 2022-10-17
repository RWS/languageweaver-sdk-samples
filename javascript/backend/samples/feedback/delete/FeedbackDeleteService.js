const SdkFactory = require("@language-weaver/lw-sdk-js").default;
const {ClientConfiguration, DeleteFeedbackRequest} = require("@language-weaver/lw-sdk-js");

const deleteFeedback = async () => {
    try {
        const lwClient = await SdkFactory.getLanguageWeaverClient(new ClientConfiguration());
        const deleteRequest = new DeleteFeedbackRequest();
        deleteRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        await lwClient.deleteFeedback(deleteRequest);
    } catch (e) {
        console.log(e);
    }
}

deleteFeedback();