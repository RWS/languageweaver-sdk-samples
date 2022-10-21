package com.languageweaver.sdk.samples.feedback;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.common.constants.*;
import com.languageweaver.sdk.feedback.cloud.model.CloudFeedbackSortCriteria;
import com.languageweaver.sdk.feedback.cloud.request.*;
import com.languageweaver.sdk.feedback.cloud.result.CloudFeedbackListResult;
import com.languageweaver.sdk.feedback.cloud.result.CloudFeedbackResult;
import com.languageweaver.sdk.feedback.common.request.DeleteFeedbackRequest;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class CloudFeedbackService {

    public static void main(String[] args) throws IOException, ParseException {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudFeedbackResult feedback;

//          CREATE FEEDBACK
            CloudCreateFeedbackRequest createFeedbackRequest = new CloudCreateFeedbackRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .setSourceText("sourceText")
                    .setTargetText("targetText")
                    .setSuggestedTranslation("suggestedTranslation")
                    .setRating(3)
                    .addComment(FeedbackComment.SPELLING)
                    .addComment("custom comment")
                    .setTranslationMetadata("metadata")
                    .setNumberOfSegments(1)
                    .setQualityEstimationMT(QualityEstimation.ADEQUATE);

            feedback = lwClient.createFeedback(createFeedbackRequest);
            System.out.println(feedback.getFeedbackId());

//          UPDATE FEEDBACK
            CloudUpdateFeedbackRequest cloudUpdateFeedbackRequest = feedback.toUpdateRequest()
                    .setSuggestedTranslation("new suggested translation")
                    .setRating(2)
                    .setQualityEstimation(QualityEstimation.POOR)
                    .clearComments().addComment(FeedbackComment.CAPITALIZATION_PUNCTUATION);

            feedback = lwClient.updateFeedback(cloudUpdateFeedbackRequest);

//          UPDATE FEEDBACK APPROVAL
            CloudUpdateFeedbackApprovalRequest cloudUpdateApprovalRequest = feedback.toUpdateApprovalRequest(ApprovalStatus.REJECTED);
            feedback = lwClient.updateFeedbackApproval(cloudUpdateApprovalRequest);
            System.out.println(feedback.getApprovalState());

//          DELETE FEEDBACK
            DeleteFeedbackRequest deleteFeedbackRequest = feedback.toDeleteRequest();
            lwClient.deleteFeedback(deleteFeedbackRequest);

//          RETRIEVE FEEDBACK
            int pageNumber = 1;
            int pageSize = 50;
            CloudFeedbackListResult cloudFeedbackList;
            do {
                cloudFeedbackList = lwClient.getCloudFeedback(pageNumber, pageSize);
                // process feedback
                List<CloudFeedbackResult> feedbackList = cloudFeedbackList.getFeedbackList();
                feedbackList.stream()
                        .limit(3)
                        .forEach(cloudFeedbackResult -> System.out.println(cloudFeedbackResult.getFeedbackId()));
                pageNumber++;
            } while (cloudFeedbackList.getFeedbackList().size() == pageSize);

//          FILTER FEEDBACK
            CloudFilterFeedbackRequest filterFeedbackRequest = new CloudFilterFeedbackRequest()
                    .setApprovalStatus(ApprovalStatus.APPROVED)
                    .setFeedbackCategory(FeedbackCategory.IMPROVEMENT)
                    .setUser("userId")
                    .setStartDate("10/10/2021")
                    .setEndDate("10/10/2022")
                    .setSortRequest(new CloudFeedbackSortRequest()
                            .setCriteria(CloudFeedbackSortCriteria.DATE)
                            .setOrder(Order.DESCENDING));

            pageNumber = 1;
            CloudFeedbackListResult filteredFeedback;
            do {
                filteredFeedback = lwClient.getCloudFeedback(filterFeedbackRequest, pageNumber);
                // process feedback
                List<CloudFeedbackResult> feedbackList = filteredFeedback.getFeedbackList();
                feedbackList.stream()
                        .limit(3)
                        .forEach(cloudFeedbackResult -> System.out.println(cloudFeedbackResult.getFeedbackId()));
                pageNumber++;
            } while (filteredFeedback.getFeedbackList().size() > 0);
        }
    }


}
