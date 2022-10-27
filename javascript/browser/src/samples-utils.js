import {translateText} from "./samples/translations/text/TextTranslationService";
import {translateTextUsingEdge} from "./samples/translations/text/EdgeTextTranslationService";
import {translateTextUsingCloud} from "./samples/translations/text/CloudTextTranslationService";
import {translateFile} from "./samples/translations/file/FileTranslationService";
import {translateFileUsingEdge} from "./samples/translations/file/EdgeFileTranslationService";
import {translateFileUsingCloud} from "./samples/translations/file/CloudFileTranslationService";
import {translateBatchFileUsingEdge} from "./samples/translations/file/batch/EdgeBatchFileTranslationService";
import {translateBatchFileUsingCloud} from "./samples/translations/file/batch/CloudBatchFileTranslationService";
import {translateBatchFile} from "./samples/translations/file/batch/BatchFileTranslationService";
import {getLanguagePairs} from "./samples/lps/LanguagePairService";
import {getCloudLanguagePairs} from "./samples/lps/CloudLanguagePairService";
import {getEdgeLanguagePairs} from "./samples/lps/EdgeLanguagePairService";
import {getDictionaries} from "./samples/dictionaries/DictionaryService";
import {getCloudDictionaries} from "./samples/dictionaries/CloudDictionaryService";
import {getEdgeDictionaries} from "./samples/dictionaries/EdgeDictionaryService";
import {getFeedback} from "./samples/feedback/read/FeedbackReadService";
import {getCloudFeedback} from "./samples/feedback/read/CloudFeedbackReadService";
import {getEdgeFeedback} from "./samples/feedback/read/EdgeFeedbackReadService";
import {createFeedback} from "./samples/feedback/create/FeedbackCreateService";
import {createCloudFeedback} from "./samples/feedback/create/CloudFeedbackCreateService";
import {createEdgeFeedback} from "./samples/feedback/create/EdgeFeedbackCreateService";
import {updateFeedback} from "./samples/feedback/update/FeedbackUpdateService";
import {updateCloudFeedback} from "./samples/feedback/update/CloudFeedbackUpdateService";
import {updateEdgeFeedback} from "./samples/feedback/update/EdgeFeedbackUpdateService";
import {updateFeedbackApproval} from "./samples/feedback/update/approvalStatus/FeedbackApprovalUpdateService";
import {updateCloudFeedbackApproval} from "./samples/feedback/update/approvalStatus/CloudFeedbackApprovalUpdateService";
import {updateEdgeFeedbackApproval} from "./samples/feedback/update/approvalStatus/EdgeFeedbackApprovalUpdateService";
import {deleteFeedback} from "./samples/feedback/delete/FeedbackDeleteService";
import {deleteCloudFeedback} from "./samples/feedback/delete/CloudFeedbackDeleteService";
import {deleteEdgeFeedback} from "./samples/feedback/delete/EdgeFeedbackDeleteService";

const textTranslationItems = [
    {
        id: "text-translation-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => translateText(clientId, clientSecret)
    },
    {
        id: "text-translation-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => translateTextUsingCloud(clientId, clientSecret)
    },
    {
        id: "text-translation-edge",
        title: "Edge",
        onClick: clientId => translateTextUsingEdge(clientId)
    }
];

const fileTranslationItems = [
    {
        id: "file-translation-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => translateFile(clientId, clientSecret)
    },
    {
        id: "file-translation-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => translateFileUsingCloud(clientId, clientSecret)
    },
    {
        id: "file-translation-edge",
        title: "Edge",
        onClick: clientId => translateFileUsingEdge(clientId)
    }
];

const batchFileTranslationItems = [
    {
        id: "batch-file-translation-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => translateBatchFile(clientId, clientSecret)
    },
    {
        id: "batch-file-translation-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => translateBatchFileUsingCloud(clientId, clientSecret)
    },
    {
        id: "batch-file-translation-edge",
        title: "Edge",
        onClick: clientId => translateBatchFileUsingEdge(clientId)
    }
];

const languagePairsItems = [
    {
        id: "language-pairs-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => getLanguagePairs(clientId, clientSecret)
    },
    {
        id: "language-pairs-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => getCloudLanguagePairs(clientId, clientSecret)
    },
    {
        id: "language-pairs-edge",
        title: "Edge",
        onClick: clientId => getEdgeLanguagePairs(clientId)
    }
];

const dictionariesItems = [
    {
        id: "dictionaries-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => getDictionaries(clientId, clientSecret)
    },
    {
        id: "dictionaries-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => getCloudDictionaries(clientId, clientSecret)
    },
    {
        id: "dictionaries-edge",
        title: "Edge",
        onClick: clientId => getEdgeDictionaries(clientId)
    }
];

const readFeedbackItems = [
    {
        id: "feedback-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => getFeedback(clientId, clientSecret)
    },
    {
        id: "feedback-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => getCloudFeedback(clientId, clientSecret)
    },
    {
        id: "feedback-edge",
        title: "Edge",
        onClick: clientId => getEdgeFeedback(clientId)
    }
];

const createFeedbackItems = [
    {
        id: "create-feedback-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => createFeedback(clientId, clientSecret)
    },
    {
        id: "create-feedback-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => createCloudFeedback(clientId, clientSecret)
    },
    {
        id: "create-feedback-edge",
        title: "Edge",
        onClick: clientId => createEdgeFeedback(clientId)
    }
];

const updateFeedbackItems = [
    {
        id: "update-feedback-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => updateFeedback(clientId, clientSecret)
    },
    {
        id: "update-feedback-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => updateCloudFeedback(clientId, clientSecret)
    },
    {
        id: "update-feedback-edge",
        title: "Edge",
        onClick: clientId => updateEdgeFeedback(clientId)
    }
];

const updateFeedbackApprovalItems = [
    {
        id: "update-feedback-approval-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => updateFeedbackApproval(clientId, clientSecret)
    },
    {
        id: "update-feedback-approval-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => updateCloudFeedbackApproval(clientId, clientSecret)
    },
    {
        id: "update-feedback-approval-edge",
        title: "Edge",
        onClick: clientId => updateEdgeFeedbackApproval(clientId)
    }
];

const deleteFeedbackItems = [
    {
        id: "delete-feedback-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => deleteFeedback(clientId, clientSecret)
    },
    {
        id: "delete-feedback-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => deleteCloudFeedback(clientId, clientSecret)
    },
    {
        id: "delete-feedback-edge",
        title: "Edge",
        onClick: clientId => deleteEdgeFeedback(clientId)
    }
];

export const samplesConfig = [
    {
        id: "text-translation",
        title: "Text Translation",
        items: textTranslationItems
    },
    {
        id: "file-translation",
        title: "File Translation",
        items: fileTranslationItems
    },
    {
        id: "batch-file-translation",
        title: "Batch File Translation",
        items: batchFileTranslationItems
    },
    {
        id: "language-pairs",
        title: "Language Pairs",
        items: languagePairsItems
    },
    {
        id: "dictionaries",
        title: "Dictionaries",
        items: dictionariesItems
    },
    {
        id: "feedback",
        title: "Feedback - Read",
        items: readFeedbackItems
    },
    {
        id: "create-feedback",
        title: "Feedback - Create",
        items: createFeedbackItems
    },
    {
        id: "update-feedback",
        title: "Feedback - Update",
        items: updateFeedbackItems
    },
    {
        id: "update-feedback-approval",
        title: "Feedback Approval Status - Update",
        items: updateFeedbackApprovalItems
    },
    {
        id: "delete-feedback",
        title: "Feedback - Delete",
        items: deleteFeedbackItems
    },
];

const blob1 = new Blob(["The weather is wonderful today!"]);
export const file1 = new File([blob1], "input1.txt", {
    type: "text/plain"
});
const blob2 = new Blob(["This is a new input that is part of an array translation."]);
export const file2 = new File([blob2], "input2.txt", {
    type: "text/plain"
});