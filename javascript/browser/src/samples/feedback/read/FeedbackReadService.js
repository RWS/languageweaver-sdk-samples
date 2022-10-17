import SdkFactory, {
    ApprovalStatus,
    ClientConfiguration,
    CredentialsConfiguration,
    FilterFeedbackRequest
} from "@language-weaver/lw-sdk-js";

export const getFeedback = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const lwClient = await SdkFactory.getLanguageWeaverClient(clientConfiguration);
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