const {CloudLanguageWeaverClient, CloudDeleteFeedbackRequest} = require("@language-weaver/lw-sdk-js");

const deleteFeedback = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const deleteRequest = new CloudDeleteFeedbackRequest();
        deleteRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        await cloudLanguageWeaverClient.deleteCloudFeedback(deleteRequest);
    } catch (e) {
        console.log(e);
    }
}

deleteFeedback();