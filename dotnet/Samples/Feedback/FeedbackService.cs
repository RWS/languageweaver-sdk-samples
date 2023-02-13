using LanguageWeaver.Sdk.Common;
using LanguageWeaver.Sdk.Configurations;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.Feedback.Common.Request;
using LanguageWeaver.Sdk.Feedback.Common.Result;

namespace LanguageWeaver.Sdk.Samples.Feedback;

public class FeedbackService
{
    public static void Main()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());

        FeedbackResult feedback;

        //CREATE FEEDBACK
        feedback = CreateFeedback();
        Console.WriteLine(feedback.FeedbackId);

        //UPDATE FEEDBACK
        UpdateFeedbackRequest updateFeedbackRequest = feedback.ToUpdateRequest();
        updateFeedbackRequest.SuggestedTranslation = "new suggested translation";
        updateFeedbackRequest.ClearComments().AddComment(FeedbackComment.CapitalizationPunctuation);
        feedback = lwClient.UpdateFeedback(updateFeedbackRequest);

        //UPDATE FEEDBACK APPROVAL
        UpdateFeedbackApprovalRequest updateFeedbackApprovalRequest =
            feedback.ToUpdateApprovalRequest(ApprovalStatus.Rejected);
        feedback = lwClient.UpdateFeedbackApproval(updateFeedbackApprovalRequest);
        Console.WriteLine(feedback.ApprovalState);

        //DELETE FEEDBACK
        DeleteFeedbackRequest deleteFeedbackRequest = feedback.ToDeleteRequest();
        lwClient.DeleteFeedback(deleteFeedbackRequest);
    }

    public static FeedbackResult CreateFeedback()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());

        CreateFeedbackRequest createFeedbackRequest = new CreateFeedbackRequest()
        {
            SourceLanguageId = "eng",
            TargetLanguageId = "fra",
            Model = "generic",
            SourceText = "sourceText",
            TargetText = "targetText",
            SuggestedTranslation = "suggestedTranslation",
        };
        createFeedbackRequest.AddComment(FeedbackComment.Spelling);

        FeedbackResult feedback = lwClient.CreateFeedback(createFeedbackRequest);

        return feedback;
    }

    public static void UpdateFeedback()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());

        UpdateFeedbackRequest updateFeedbackRequest = new UpdateFeedbackRequest()
        {
            FeedbackId = "feedbackId",
            SuggestedTranslation = "new suggested translation"
        };

        updateFeedbackRequest.AddComment(FeedbackComment.CapitalizationPunctuation);

        FeedbackResult feedback = lwClient.UpdateFeedback(updateFeedbackRequest);
    }

    public static void UpdateFeedbackStatus()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());

        UpdateFeedbackApprovalRequest updateFeedbackApprovalRequest = new UpdateFeedbackApprovalRequest()
        {
            FeedbackId = "feedbackId",
            ApprovalStatus = ApprovalStatus.Approved
        };

        FeedbackResult feedback = lwClient.UpdateFeedbackApproval(updateFeedbackApprovalRequest);
        Console.WriteLine(feedback.ApprovalState);
    }

    public static void DeleteFeedback()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());

        DeleteFeedbackRequest deleteFeedbackRequest = new DeleteFeedbackRequest()
        {
            FeedbackId = "feedbackId"
        };

        lwClient.DeleteFeedback(deleteFeedbackRequest);
    }

    public static void RetrieveFeedback()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());

        int pageNumber = 1;
        int pageSize = 50;
        FeedbackListResult feedbackListResult;
        do
        {
            feedbackListResult = lwClient.GetFeedback(pageNumber, pageSize);
            //process feedback
            List<FeedbackResult> feedbackList = feedbackListResult.FeedbackList;
            feedbackList.Take(3)
                .ToList()
                .ForEach(feedbackResult => Console.WriteLine(feedbackResult.FeedbackId));
            pageNumber++;
        } while (feedbackListResult.FeedbackList.Count == pageSize);
    }

    public static void FilterFeedback()
    {
        using var lwClient = new SdkFactory().GetLanguageWeaverClient(new ClientConfiguration());

        FilterFeedbackRequest filterFeedbackRequest = new FilterFeedbackRequest()
        {
            ApprovalStatus = ApprovalStatus.Approved,
            User = "userId",
            StartDate = "10/10/2021",
            EndDate = "10/10/2022"
        };

        int pageNumber = 1;
        FeedbackListResult filteredFeedback;
        do
        {
            filteredFeedback = lwClient.GetFeedback(filterFeedbackRequest, pageNumber);
            //process feedback
            List<FeedbackResult> feedbackList = filteredFeedback.FeedbackList;
            feedbackList.Take(3)
                .ToList()
                .ForEach(feedbackResult => Console.WriteLine(feedbackResult.FeedbackId));
            pageNumber++;
        } while (filteredFeedback.FeedbackList.Count > 0);
    }
}