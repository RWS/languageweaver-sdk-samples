const SdkFactory = require("@language-weaver/lw-sdk-js").default;
const {ClientConfiguration, FilterFeedbackRequest, ApprovalStatus} = require("@language-weaver/lw-sdk-js");

const getFeedback = async () => {
    try {
        const lwClient = await SdkFactory.getLanguageWeaverClient(new ClientConfiguration());
        const filterRequest = new FilterFeedbackRequest();
        filterRequest.startDate = "10-04-2022";
        filterRequest.endDate = "10-24-2022";
        filterRequest.approvalStatus = ApprovalStatus.APPROVED;
        filterRequest.user = "123";
        const feedbackResult = await lwClient.getFeedback(1, 50, filterRequest);
        console.log(feedbackResult.feedbackList);
    } catch (e) {
        console.log(e);
    }
}

getFeedback();