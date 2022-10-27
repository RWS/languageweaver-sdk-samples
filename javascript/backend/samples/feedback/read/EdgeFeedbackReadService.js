const {ApprovalStatus, EdgeLanguageWeaverClient, EdgeFilterFeedbackRequest} = require("@language-weaver/lw-sdk-js");

const getFeedback = async () => {
    try {
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const filterRequest = new EdgeFilterFeedbackRequest();
        filterRequest.startDate = "10-04-2022";
        filterRequest.endDate = "10-24-2022";
        filterRequest.approvalStatus = ApprovalStatus.APPROVED;
        filterRequest.user = "user@mail.com";
        filterRequest.languagePairId = "EngFra_Generic_Cloud";
        filterRequest.sourceText = "This is a sample input text.";
        filterRequest.machineTranslation = "C'est un exemple de texte d'entrée.";
        filterRequest.suggestedTranslation = "Ceci est un exemple de texte d'entrée.";
        filterRequest.comment = "This is a sample feedback entry for documentation.";
        filterRequest.approvalStatuses = [ApprovalStatus.APPROVED, ApprovalStatus.REJECTED];
        filterRequest.reviewer = "user@mail.com";
        const feedbackResult = await edgeLanguageWeaverClient.getEdgeFeedback(1, 50, filterRequest);
        console.log(feedbackResult.feedbackList);
    } catch (e) {
        console.log(e);
    }
}

getFeedback();