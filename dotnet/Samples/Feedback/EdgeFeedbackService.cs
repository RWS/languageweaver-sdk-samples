using LanguageWeaver.Sdk.Common.Edge;
using LanguageWeaver.Sdk.Constants;
using LanguageWeaver.Sdk.Feedback.Edge.Request;
using LanguageWeaver.Sdk.Feedback.Edge.Result;

namespace LanguageWeaver.Sdk.Samples.Feedback;

public class EdgeFeedbackService
{
    public static void Main()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();

        EdgeFeedbackResult feedback;

        //CREATE FEEDBACK
        feedback = CreateFeedback();
        Console.WriteLine(feedback.FeedbackId);

        //UPDATE FEEDBACK
        EdgeUpdateFeedbackRequest edgeUpdateFeedbackRequest = feedback.ToUpdateRequest();
        edgeUpdateFeedbackRequest.SuggestedTranslation = "new suggested translation";
        feedback = lwClient.UpdateFeedback(edgeUpdateFeedbackRequest);

        //UPDATE FEEDBACK APPROVAL
        EdgeUpdateFeedbackApprovalRequest edgeUpdateFeedbackApprovalRequest =
            feedback.ToUpdateApprovalRequest(ApprovalStatus.Rejected);
        feedback = lwClient.UpdateFeedbackApproval(edgeUpdateFeedbackApprovalRequest);
        Console.WriteLine(feedback.ApprovalState);

        //DELETE FEEDBACK
        EdgeDeleteFeedbackRequest deleteFeedbackRequest = feedback.ToDeleteRequest();
        lwClient.DeleteFeedback(deleteFeedbackRequest);
    }

    public static EdgeFeedbackResult CreateFeedback()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();

        EdgeCreateFeedbackRequest edgeCreateFeedbackRequest = new EdgeCreateFeedbackRequest()
        {
            LanguagePairId = "languagePairId",
            SourceLanguageId = "eng",
            TargetLanguageId = "fra",
            Model = "generic",
            SourceText = "sourceText",
            TargetText = "targetText",
            SuggestedTranslation = "suggestedTranslation2",
            ApprovalState = ApprovalStatus.Approved
        };

        EdgeFeedbackResult feedback = lwClient.CreateFeedback(edgeCreateFeedbackRequest);
        return feedback;
    }

    public static void UpdateFeedback()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();

        EdgeUpdateFeedbackRequest edgeUpdateFeedbackRequest = new EdgeUpdateFeedbackRequest()
        {
            FeedbackId = "feedbackId",
            SuggestedTranslation = "new suggested translation"
        };

        EdgeFeedbackResult feedback = lwClient.UpdateFeedback(edgeUpdateFeedbackRequest);

        Console.WriteLine(feedback.ApprovalState);
    }

    public static void UpdateFeedbackStatus()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();

        EdgeUpdateFeedbackApprovalRequest edgeUpdateFeedbackApprovalRequest = new EdgeUpdateFeedbackApprovalRequest()
        {
            FeedbackId = "feedbackId",
            ApprovalStatus = ApprovalStatus.Approved
        };

        EdgeFeedbackResult feedback = lwClient.UpdateFeedbackApproval(edgeUpdateFeedbackApprovalRequest);

        Console.WriteLine(feedback.ApprovalState);
    }

    public static void DeleteFeedback()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();

        EdgeDeleteFeedbackRequest deleteFeedbackRequest = new EdgeDeleteFeedbackRequest()
        {
            FeedbackId = "feedbackId"
        };

        lwClient.DeleteFeedback(deleteFeedbackRequest);
    }

    public static void RetrieveFeedback()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();

        int pageNumber = 1;
        int pageSize = 50;
        EdgeFeedbackListResult edgeFeedbackList;
        do
        {
            edgeFeedbackList = lwClient.GetEdgeFeedback(pageNumber, pageSize);
            //process feedback
            List<EdgeFeedbackResult> feedbackList = edgeFeedbackList.FeedbackList;
            feedbackList.Take(3)
                .ToList()
                .ForEach(edgeFeedbackResult => Console.WriteLine(edgeFeedbackResult.FeedbackId));
            pageNumber++;
        } while (edgeFeedbackList.FeedbackList.Count == pageSize);
    }

    public static void FilterFeedback()
    {
        using var lwClient = new EdgeLanguageWeaverClient().Build();

        EdgeFilterFeedbackRequest filterFeedbackRequest = new EdgeFilterFeedbackRequest()
        {
            LanguagePairId = "languagePairId",
            SourceText = "sourceText",
            MachineTranslation = "machineTranslation",
            SuggestedTranslation = "suggestedTranslation",
            Reviewer = "reviewer username",
            User = "creation username",
            ApprovalStatus = ApprovalStatus.Approved,
            StartDate = "10/10/2021",
            EndDate = "10/10/2022",
        };

        int pageNumber = 1;
        EdgeFeedbackListResult filteredFeedback;
        do
        {
            filteredFeedback = lwClient.GetEdgeFeedback(filterFeedbackRequest, pageNumber);
            //process feedback
            List<EdgeFeedbackResult> feedbackList = filteredFeedback.FeedbackList;
            feedbackList.Take(3)
                .ToList()
                .ForEach(edgeFeedbackResult => Console.WriteLine(edgeFeedbackResult.FeedbackId));
            pageNumber++;
        } while (filteredFeedback.FeedbackList.Count > 0);
    }
}