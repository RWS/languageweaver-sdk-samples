using LanguageWeaver.Sdk.Common.Cloud;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.Feedback.Cloud.Model;
using LanguageWeaver.Sdk.Feedback.Cloud.Request;
using LanguageWeaver.Sdk.Feedback.Cloud.Result;

namespace LanguageWeaver.Sdk.Samples.Feedback;

public class CloudFeedbackService
{
    public static void Main()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();

        CloudFeedbackResult feedback;

        //CREATE FEEDBACK
        feedback = CreateFeedback();
        Console.WriteLine(feedback.FeedbackId);

        //UPDATE FEEDBACK
        CloudUpdateFeedbackRequest cloudUpdateFeedbackRequest = feedback.ToUpdateRequest();
        cloudUpdateFeedbackRequest.SuggestedTranslation = "new suggested translation";
        cloudUpdateFeedbackRequest.Rating = 2;
        cloudUpdateFeedbackRequest.QualityEstimation = QualityEstimation.Poor;
        cloudUpdateFeedbackRequest.ClearComments().AddComment(FeedbackComment.CapitalizationPunctuation);
        feedback = lwClient.UpdateFeedback(cloudUpdateFeedbackRequest);

        //UPDATE FEEDBACK APPROVAL
        CloudUpdateFeedbackApprovalRequest cloudUpdateFeedbackApprovalRequest =
            feedback.ToUpdateApprovalRequest(ApprovalStatus.Rejected);
        feedback = lwClient.UpdateFeedbackApproval(cloudUpdateFeedbackApprovalRequest);
        Console.WriteLine(feedback.ApprovalState);

        //DELETE FEEDBACK
        CloudDeleteFeedbackRequest deleteFeedbackRequest = feedback.ToDeleteRequest();
        lwClient.DeleteFeedback(deleteFeedbackRequest);
    }

    public static CloudFeedbackResult CreateFeedback()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();

        CloudCreateFeedbackRequest cloudCreateFeedbackRequest = new CloudCreateFeedbackRequest()
        {
            SourceLanguageId = "eng",
            TargetLanguageId = "fra",
            Model = "generic",
            SourceText = "sourceText",
            TargetText = "targetText",
            SuggestedTranslation = "suggestedTranslation",
            Rating = 3,
            TranslationMetadata = "metadata",
            NumberOfSegments = 1,
            QualityEstimation = QualityEstimation.Adequate,
            QualityEstimationMt = QualityEstimation.Poor
        };
        cloudCreateFeedbackRequest.AddComment(FeedbackComment.Spelling);
        cloudCreateFeedbackRequest.AddComment("custom comment");

        CloudFeedbackResult feedback = lwClient.CreateFeedback(cloudCreateFeedbackRequest);
        return feedback;
    }

    public static void UpdateFeedback()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();

        CloudUpdateFeedbackRequest cloudUpdateFeedbackRequest = new CloudUpdateFeedbackRequest()
        {
            FeedbackId = "feedbackId",
            SuggestedTranslation = "new suggested translation",
            Rating = 2,
            QualityEstimation = QualityEstimation.Poor
        };
        cloudUpdateFeedbackRequest.AddComment(FeedbackComment.CapitalizationPunctuation);

        CloudFeedbackResult feedback = lwClient.UpdateFeedback(cloudUpdateFeedbackRequest);
        Console.WriteLine(feedback.ApprovalState);
    }

    public static void UpdateFeedbackStatus()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();

        CloudUpdateFeedbackApprovalRequest cloudUpdateFeedbackApprovalRequest =
            new CloudUpdateFeedbackApprovalRequest()
            {
                FeedbackId = "feedbackId",
                ApprovalStatus = ApprovalStatus.Approved
            };

        CloudFeedbackResult feedback = lwClient.UpdateFeedbackApproval(cloudUpdateFeedbackApprovalRequest);
        Console.WriteLine(feedback.ApprovalState);
    }

    public static void DeleteFeedback()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();

        CloudDeleteFeedbackRequest deleteFeedbackRequest = new CloudDeleteFeedbackRequest()
        {
            FeedbackId = "feedbackId"
        };

        lwClient.DeleteFeedback(deleteFeedbackRequest);
    }

    public static void RetrieveFeedback()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();

        int pageNumber = 1;
        int pageSize = 50;
        CloudFeedbackListResult cloudFeedbackList;
        do
        {
            cloudFeedbackList = lwClient.GetCloudFeedback(pageNumber, pageSize);
            //process feedback
            List<CloudFeedbackResult> feedbackList = cloudFeedbackList.FeedbackList;
            feedbackList.Take(3)
                .ToList()
                .ForEach(cloudFeedbackResult => Console.WriteLine(cloudFeedbackResult.FeedbackId));
            pageNumber++;
        } while (cloudFeedbackList.FeedbackList.Count == pageSize);
    }

    public static void FilterFeedback()
    {
        using var lwClient = new CloudLanguageWeaverClient().Build();

        CloudFilterFeedbackRequest filterFeedbackRequest = new CloudFilterFeedbackRequest()
        {
            ApprovalStatus = ApprovalStatus.Approved,
            FeedbackCategory = FeedbackCategory.Improvement,
            User = "userId",
            StartDate = "10/10/2021",
            EndDate = "10/10/2022",
            SortRequest = new CloudFeedbackSortRequest()
            {
                Criteria = CloudFeedbackSortCriteria.Date,
                Order = Order.Descending
            }
        };

        int pageNumber = 1;
        CloudFeedbackListResult filteredFeedback;
        do
        {
            filteredFeedback = lwClient.GetCloudFeedback(filterFeedbackRequest, pageNumber);
            //process feedback
            List<CloudFeedbackResult> feedbackList = filteredFeedback.FeedbackList;
            feedbackList.Take(3)
                .ToList()
                .ForEach(cloudFeedbackResult => Console.WriteLine(cloudFeedbackResult.FeedbackId));
            pageNumber++;
        } while (filteredFeedback.FeedbackList.Count > 0);
    }
}