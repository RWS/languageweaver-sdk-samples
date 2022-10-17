import {
    ApprovalStatus, ClientConfiguration,
    CloudFeedbackSortCriteria,
    CloudFeedbackSortRequest, CloudFilterFeedbackRequest,
    CloudLanguageWeaverClient, CredentialsConfiguration, FeedbackCategory, Order
} from "@language-weaver/lw-sdk-js";

export const getCloudFeedback = async (clientId, clientSecret) => {
    try {
        const clientConfiguration = new ClientConfiguration();
        clientConfiguration.credentialsConfiguration = new CredentialsConfiguration(clientId, clientSecret);
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient()
            .withConfigurations(clientConfiguration)
            .build();
        const sortRequest = new CloudFeedbackSortRequest();
        sortRequest.criteria = CloudFeedbackSortCriteria.DATE;
        sortRequest.order = Order.DESCENDING;
        const filterRequest = new CloudFilterFeedbackRequest();
        filterRequest.feedbackId = "e8b01170-1bc4-4d61-89f7-fc2f65733442";
        filterRequest.feedbackCategory = FeedbackCategory.RATING;
        filterRequest.startDate = "10-04-2022";
        filterRequest.endDate = "10-24-2022";
        filterRequest.approvalStatus = ApprovalStatus.APPROVED;
        filterRequest.user = "123";
        filterRequest.sortRequest = sortRequest;
        const feedbackResult = await cloudLanguageWeaverClient.getCloudFeedback(1, 50, filterRequest);
        console.log(feedbackResult.feedbackList);
    } catch (e) {
        console.log(e);
    }
}