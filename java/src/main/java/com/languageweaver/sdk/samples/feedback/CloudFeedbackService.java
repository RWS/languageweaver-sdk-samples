package com.languageweaver.sdk.samples.feedback;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.common.constants.ApprovalStatus;
import com.languageweaver.sdk.common.constants.CloudFeedbackSortCriteria;
import com.languageweaver.sdk.common.constants.Order;
import com.languageweaver.sdk.common.constants.QualityEstimation;
import com.languageweaver.sdk.feedback.cloud.request.*;
import com.languageweaver.sdk.feedback.cloud.result.CloudFeedbackListResult;
import com.languageweaver.sdk.feedback.cloud.result.CloudFeedbackResult;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class CloudFeedbackService {

    public static CloudFeedbackResult createFeedback() throws IOException {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudCreateFeedbackRequest createFeedbackRequest = new CloudCreateFeedbackRequest()
                    .setSourceLanguageId("eng")
                    .setTargetLanguageId("fra")
                    .setModel("generic")
                    .setSourceText("sourceText")
                    .setTargetText("targetText")
                    .setSuggestedTranslation("suggestedTranslation")
                    .setNumberOfSegments(1)
                    .setQualityEstimationMT(QualityEstimation.ADEQUATE)
                    .setQualityEstimation(QualityEstimation.POOR);

            return lwClient.createFeedback(createFeedbackRequest);
        }
    }

    public static void updateFeedback() throws IOException {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudUpdateFeedbackRequest cloudUpdateFeedbackRequest = new CloudUpdateFeedbackRequest()
                    .setFeedbackId("feedbackId")
                    .setSuggestedTranslation("new suggested translation")
                    .setQualityEstimation(QualityEstimation.POOR);

            CloudFeedbackResult feedback = lwClient.updateFeedback(cloudUpdateFeedbackRequest);
        }
    }

    public static void updateFeedbackStatus() throws IOException {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudUpdateFeedbackApprovalRequest cloudUpdateApprovalRequest = new CloudUpdateFeedbackApprovalRequest()
                    .setFeedbackId("feedbackId")
                    .setApprovalStatus(ApprovalStatus.APPROVED);

            CloudFeedbackResult feedback = lwClient.updateFeedbackApproval(cloudUpdateApprovalRequest);
            System.out.println(feedback.getApprovalState());
        }
    }

    public static void deleteFeedback() throws IOException {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudDeleteFeedbackRequest deleteFeedbackRequest = new CloudDeleteFeedbackRequest()
                    .setFeedbackId("feedbackId");

            lwClient.deleteFeedback(deleteFeedbackRequest);
        }
    }

    public static void retrieveFeedback() throws IOException {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
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
        }
    }

    public static void filterFeedback() throws IOException {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudFilterFeedbackRequest filterFeedbackRequest = new CloudFilterFeedbackRequest()
                    .setApprovalStatus(ApprovalStatus.APPROVED)
                    .setUser("userId")
                    .setStartDate("10/10/2021")
                    .setEndDate("10/10/2022")
                    .setSortRequest(new CloudFeedbackSortRequest()
                            .setCriteria(CloudFeedbackSortCriteria.DATE)
                            .setOrder(Order.DESCENDING));

            int pageNumber = 1;
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

    public static void main(String[] args) throws IOException, ParseException {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            CloudFeedbackResult feedback;

            // CREATE FEEDBACK
            feedback = createFeedback();
            System.out.println(feedback.getFeedbackId());

            // UPDATE FEEDBACK
            CloudUpdateFeedbackRequest cloudUpdateFeedbackRequest = feedback.toUpdateRequest()
                    .setSuggestedTranslation("new suggested translation")
                    .setQualityEstimation(QualityEstimation.POOR);
            feedback = lwClient.updateFeedback(cloudUpdateFeedbackRequest);

            // UPDATE FEEDBACK APPROVAL
            CloudUpdateFeedbackApprovalRequest cloudUpdateApprovalRequest = feedback.toUpdateApprovalRequest(ApprovalStatus.REJECTED);
            feedback = lwClient.updateFeedbackApproval(cloudUpdateApprovalRequest);
            System.out.println(feedback.getApprovalState());

            // DELETE FEEDBACK
            CloudDeleteFeedbackRequest deleteFeedbackRequest = feedback.toDeleteRequest();
            lwClient.deleteFeedback(deleteFeedbackRequest);
        }
    }
}
