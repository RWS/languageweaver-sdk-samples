package com.languageweaver.sdk.samples.feedback;

import com.languageweaver.sdk.common.constants.ApprovalStatus;
import com.languageweaver.sdk.common.constants.FeedbackComment;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.feedback.edge.request.*;
import com.languageweaver.sdk.feedback.edge.result.EdgeFeedbackListResult;
import com.languageweaver.sdk.feedback.edge.result.EdgeFeedbackResult;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class EdgeFeedbackService {

    public static EdgeFeedbackResult createFeedback() throws IOException {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeCreateFeedbackRequest createFeedbackRequest = new EdgeCreateFeedbackRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .setSourceText("sourceText")
                    .setTargetText("targetText")
                    .setSuggestedTranslation("suggestedTranslation")
                    .setComment(FeedbackComment.SPELLING)
                    .setApprovalState(ApprovalStatus.APPROVED);

            EdgeFeedbackResult feedback = lwClient.createFeedback(createFeedbackRequest);
            return feedback;
        }
    }

    public static void updateFeedback() throws IOException {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeUpdateFeedbackRequest edgeUpdateFeedbackRequest = new EdgeUpdateFeedbackRequest()
                    .setFeedbackId("feedbackId")
                    .setSuggestedTranslation("new suggested translation")
                    .setComment(FeedbackComment.CAPITALIZATION_PUNCTUATION);

            EdgeFeedbackResult feedback = lwClient.updateFeedback(edgeUpdateFeedbackRequest);
        }
    }

    public static void updateFeedbackStatus() throws IOException {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeUpdateFeedbackApprovalRequest edgeUpdateApprovalRequest = new EdgeUpdateFeedbackApprovalRequest()
                    .setFeedbackId("feedbackId")
                    .setApprovalStatus(ApprovalStatus.REJECTED);

            EdgeFeedbackResult feedback = lwClient.updateFeedbackApproval(edgeUpdateApprovalRequest);
            System.out.println(feedback.getApprovalState());
        }
    }

    public static void deleteFeedback() throws IOException {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeDeleteFeedbackRequest deleteFeedbackRequest = new EdgeDeleteFeedbackRequest()
                    .setFeedbackId("feedbackId");

            lwClient.deleteFeedback(deleteFeedbackRequest);
        }
    }

    public static void retrieveFeedback() throws IOException {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            int pageNumber = 1;
            int pageSize = 50;
            EdgeFeedbackListResult edgeFeedbackList;
            do {
                edgeFeedbackList = lwClient.getEdgeFeedback(pageNumber, pageSize);
                // process feedback
                List<EdgeFeedbackResult> feedbackList = edgeFeedbackList.getFeedbackList();
                feedbackList.stream()
                        .limit(3)
                        .forEach(edgeFeedbackResult -> System.out.println(edgeFeedbackResult.getFeedbackId()));
                pageNumber++;
            } while (edgeFeedbackList.getFeedbackList().size() == pageSize);
        }
    }

    public static void filterFeedback() throws IOException {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeFilterFeedbackRequest filterFeedbackRequest = new EdgeFilterFeedbackRequest()
                    .setLanguagePairId("languagePairId")
                    .setSourceText("sourceText")
                    .setMachineTranslation("machineTranslation")
                    .setSuggestedTranslation("suggestedTranslation")
                    .setComment("comment")
                    .setReviewer("reviewer username")
                    .setUser("creation username")
                    .addApprovalStatus(ApprovalStatus.APPROVED)
                    .addApprovalStatus(ApprovalStatus.PENDING)
                    .setStartDate("10/10/2021")
                    .setEndDate("10/10/2022");

            int pageNumber = 1;
            EdgeFeedbackListResult filteredFeedback;
            do {
                filteredFeedback = lwClient.getEdgeFeedback(filterFeedbackRequest, pageNumber);
                // process feedback
                List<EdgeFeedbackResult> feedbackList = filteredFeedback.getFeedbackList();
                feedbackList.stream()
                        .limit(3)
                        .forEach(edgeFeedbackResult -> System.out.println(edgeFeedbackResult.getFeedbackId()));
                pageNumber++;
            } while (filteredFeedback.getFeedbackList().size() > 0);
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeFeedbackResult feedback;

//          CREATE FEEDBACK
            feedback = createFeedback();
            System.out.println(feedback.getFeedbackId());

//          UPDATE FEEDBACK
            EdgeUpdateFeedbackRequest edgeUpdateFeedbackRequest = feedback.toUpdateRequest()
                    .setSuggestedTranslation("new suggested translation")
                    .setComment(FeedbackComment.CAPITALIZATION_PUNCTUATION);
            feedback = lwClient.updateFeedback(edgeUpdateFeedbackRequest);

//          UPDATE FEEDBACK APPROVAL
            EdgeUpdateFeedbackApprovalRequest edgeUpdateApprovalRequest = feedback.toUpdateApprovalRequest(ApprovalStatus.REJECTED);
            feedback = lwClient.updateFeedbackApproval(edgeUpdateApprovalRequest);
            System.out.println(feedback.getApprovalState());

//          DELETE FEEDBACK
            EdgeDeleteFeedbackRequest deleteFeedbackRequest = feedback.toDeleteRequest();
            lwClient.deleteFeedback(deleteFeedbackRequest);
        }
    }
}
