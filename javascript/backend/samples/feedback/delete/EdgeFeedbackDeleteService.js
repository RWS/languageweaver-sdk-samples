const {EdgeLanguageWeaverClient, EdgeDeleteFeedbackRequest} = require("@language-weaver/lw-sdk-js");

const deleteFeedback = async () => {
    try {
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const deleteRequest = new EdgeDeleteFeedbackRequest();
        deleteRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        await edgeLanguageWeaverClient.deleteEdgeFeedback(deleteRequest);
    } catch (e) {
        console.log(e);
    }
}

deleteFeedback();