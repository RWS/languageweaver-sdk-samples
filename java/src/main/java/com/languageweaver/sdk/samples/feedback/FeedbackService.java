package com.languageweaver.sdk.samples.feedback;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.common.constants.ApprovalStatus;
import com.languageweaver.sdk.common.constants.FeedbackComment;
import com.languageweaver.sdk.feedback.common.request.*;
import com.languageweaver.sdk.feedback.common.result.FeedbackListResult;
import com.languageweaver.sdk.feedback.common.result.FeedbackResult;

import java.util.List;

public class FeedbackService {

    public static FeedbackResult createFeedback() throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            CreateFeedbackRequest createFeedbackRequest = new CreateFeedbackRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .setSourceText("sourceText")
                    .setTargetText("targetText")
                    .setSuggestedTranslation("suggestedTranslation")
                    .addComment(FeedbackComment.SPELLING);

            return lwClient.createFeedback(createFeedbackRequest);
        }
    }

    public static void updateFeedback() throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            UpdateFeedbackRequest updateFeedbackRequest = new UpdateFeedbackRequest()
                    .setFeedbackId("feedbackId")
                    .setSuggestedTranslation("new suggested translation")
                    .addComment(FeedbackComment.CAPITALIZATION_PUNCTUATION);

            FeedbackResult feedback = lwClient.updateFeedback(updateFeedbackRequest);
        }
    }

    public static void updateFeedbackStatus() throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            UpdateFeedbackApprovalRequest updateApprovalRequest = new UpdateFeedbackApprovalRequest()
                    .setFeedbackId("feedbackId")
                    .setApprovalStatus(ApprovalStatus.REJECTED);

            FeedbackResult feedback = lwClient.updateFeedbackApproval(updateApprovalRequest);
            System.out.println(feedback.getApprovalState());
        }
    }

    public static void deleteFeedback() throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            DeleteFeedbackRequest deleteFeedbackRequest = new DeleteFeedbackRequest()
                    .setFeedbackId("feedbackId");

            lwClient.deleteFeedback(deleteFeedbackRequest);
        }
    }

    public static void retrieveFeedback() throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            int pageNumber = 1;
            int pageSize = 50;
            FeedbackListResult feedbackListResult;
            do {
                feedbackListResult = lwClient.getFeedback(pageNumber, pageSize);
                // process feedback
                List<FeedbackResult> feedbackList = feedbackListResult.getFeedbackList();
                feedbackList.stream()
                        .limit(3)
                        .forEach(feedbackResult -> System.out.println(feedbackResult.getFeedbackId()));
                pageNumber++;
            } while (feedbackListResult.getFeedbackList().size() == pageSize);
        }
    }

    public static void filterFeedback() throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            FilterFeedbackRequest filterFeedbackRequest = new FilterFeedbackRequest()
                    .setApprovalStatus(ApprovalStatus.APPROVED)
                    .setUser("userId")
                    .setStartDate("10/10/2021")
                    .setEndDate("10/10/2022");

            int pageNumber = 1;
            FeedbackListResult filteredFeedback;
            do {
                filteredFeedback = lwClient.getFeedback(filterFeedbackRequest, pageNumber);
                // process feedback
                List<FeedbackResult> feedbackList = filteredFeedback.getFeedbackList();
                feedbackList.stream()
                        .limit(3)
                        .forEach(feedbackResult -> System.out.println(feedbackResult.getFeedbackId()));
                pageNumber++;
            } while (filteredFeedback.getFeedbackList().size() > 0);
        }
    }


    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            FeedbackResult feedback;

            // CREATE FEEDBACK
            feedback = createFeedback();
            System.out.println(feedback.getFeedbackId());

            // UPDATE FEEDBACK
            UpdateFeedbackRequest updateFeedbackRequest = feedback.toUpdateRequest()
                    .setSuggestedTranslation("new suggested translation")
                    .clearComments().addComment(FeedbackComment.CAPITALIZATION_PUNCTUATION);
            feedback = lwClient.updateFeedback(updateFeedbackRequest);

            // UPDATE FEEDBACK APPROVAL
            UpdateFeedbackApprovalRequest updateApprovalRequest = feedback.toUpdateApprovalRequest(ApprovalStatus.REJECTED);
            feedback = lwClient.updateFeedbackApproval(updateApprovalRequest);
            System.out.println(feedback.getApprovalState());

            // DELETE FEEDBACK
            DeleteFeedbackRequest deleteFeedbackRequest = feedback.toDeleteRequest();
            lwClient.deleteFeedback(deleteFeedbackRequest);
        }
    }
}
