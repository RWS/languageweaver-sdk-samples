package com.languageweaver.sdk.samples.feedback;

import com.languageweaver.sdk.common.constants.ApprovalStatus;
import com.languageweaver.sdk.common.constants.FeedbackComment;
import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.feedback.common.request.DeleteFeedbackRequest;
import com.languageweaver.sdk.feedback.edge.request.EdgeCreateFeedbackRequest;
import com.languageweaver.sdk.feedback.edge.request.EdgeFilterFeedbackRequest;
import com.languageweaver.sdk.feedback.edge.request.EdgeUpdateFeedbackApprovalRequest;
import com.languageweaver.sdk.feedback.edge.request.EdgeUpdateFeedbackRequest;
import com.languageweaver.sdk.feedback.edge.result.EdgeFeedbackListResult;
import com.languageweaver.sdk.feedback.edge.result.EdgeFeedbackResult;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class EdgeFeedbackService {

    public static void main(String[] args) throws IOException, ParseException {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            EdgeFeedbackResult feedback;

//          CREATE FEEDBACK
            EdgeCreateFeedbackRequest createFeedbackRequest = new EdgeCreateFeedbackRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .setSourceText("sourceText")
                    .setTargetText("targetText")
                    .setSuggestedTranslation("suggestedTranslation")
                    .setComment(FeedbackComment.SPELLING);

            feedback = lwClient.createFeedback(createFeedbackRequest);
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
            DeleteFeedbackRequest deleteFeedbackRequest = feedback.toDeleteRequest();
            lwClient.deleteFeedback(deleteFeedbackRequest);

//          RETRIEVE FEEDBACK
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

//          FILTER FEEDBACK
            EdgeFilterFeedbackRequest filterFeedbackRequest = new EdgeFilterFeedbackRequest()
                    .setLanguagePairId("languagePairId")
                    .setSourceText("sourceText")
                    .setMachineTranslation("machineTranslation")
                    .setSuggestedTranslation("suggestedTranslation")
                    .setComment("comment")
                    .setReviewer("reviewer username")
                    .addApprovalStatus(ApprovalStatus.APPROVED)
                    .addApprovalStatus(ApprovalStatus.PENDING)
                    .setStartDate("10/10/2021")
                    .setEndDate("10/10/2022");

            pageNumber = 1;
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
}
