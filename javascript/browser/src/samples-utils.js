import jsPDF from "jspdf";

import {translateText, translateTextWithLinguisticOptions} from "./samples/translations/text/TextTranslationService";
import {
    translateTextUsingEdge,
    translateTextWithLinguisticOptionsUsingEdge
} from "./samples/translations/text/EdgeTextTranslationService";
import {
    translateTextUsingCloud,
    translateTextWithLinguisticOptionsUsingCloud
} from "./samples/translations/text/CloudTextTranslationService";
import {
    translateFile,
    translateFileWithLinguisticOptions,
    translatePdfFile
} from "./samples/translations/file/FileTranslationService";
import {
    translateFileUsingEdge, translateFileWithLinguisticOptionsUsingEdge,
    translatePdfFileUsingEdge
} from "./samples/translations/file/EdgeFileTranslationService";
import {
    translateFileUsingCloud, translateFileWithLinguisticOptionsUsingCloud,
    translatePdfFileUsingCloud
} from "./samples/translations/file/CloudFileTranslationService";
import {
    translateBatchFileUsingEdge, translateBatchFileWithLinguisticOptionsUsingEdge,
    translatePdfBatchFileUsingEdge
} from "./samples/translations/file/batch/EdgeBatchFileTranslationService";
import {
    translateBatchFileUsingCloud, translateBatchFileWithLinguisticOptionsUsingCloud,
    translatePdfBatchFileUsingCloud
} from "./samples/translations/file/batch/CloudBatchFileTranslationService";
import {
    translateBatchFile,
    translateBatchFileWithLinguisticOptions,
    translatePdfBatchFile
} from "./samples/translations/file/batch/BatchFileTranslationService";
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
import {retrieveFileTranslation} from "./samples/translations/file/retrieve/RetrieveFileTranslationService";
import {
    retrieveFileTranslationUsingCloud
} from "./samples/translations/file/retrieve/CloudRetrieveFileTranslationService";
import {
    retrieveFileTranslationUsingEdge
} from "./samples/translations/file/retrieve/EdgeRetrieveFileTranslationService";
import {getLinguisticOptions} from "./samples/linguisticOptions/LinguisticOptionsService";
import {getCloudLinguisticOptions} from "./samples/linguisticOptions/CloudLinguisticOptionsService";
import {getEdgeLinguisticOptions} from "./samples/linguisticOptions/EdgeLinguisticOptionsService";
import {getContentInsightsForTranslations} from "./samples/content-insights/ContentInsightsService";
import {
    getContentInsightsForTranslationsUsingCloud,
    getContentInsightsUsingCloud
} from "./samples/content-insights/CloudContentInsightsService";
import {getContentInsightsForTranslationsUsingEdge} from "./samples/content-insights/EdgeContentInsightsService";

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

const textTranslationWithLinguisticOptionsItems = [
    {
        id: "text-translation-with-linguistic-options-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => translateTextWithLinguisticOptions(clientId, clientSecret)
    },
    {
        id: "text-translation-with-linguistic-options-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => translateTextWithLinguisticOptionsUsingCloud(clientId, clientSecret)
    },
    {
        id: "text-translation-with-linguistic-options-edge",
        title: "Edge",
        onClick: clientId => translateTextWithLinguisticOptionsUsingEdge(clientId)
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

const pdfFileTranslationItems = [
    {
        id: "pdf-file-translation-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => translatePdfFile(clientId, clientSecret)
    },
    {
        id: "pdf-file-translation-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => translatePdfFileUsingCloud(clientId, clientSecret)
    },
    {
        id: "pdf-file-translation-edge",
        title: "Edge",
        onClick: clientId => translatePdfFileUsingEdge(clientId)
    }
];

const fileTranslationWithLinguisticOptionsItems = [
    {
        id: "file-translation-with-linguistic-options-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => translateFileWithLinguisticOptions(clientId, clientSecret)
    },
    {
        id: "file-translation-with-linguistic-options-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => translateFileWithLinguisticOptionsUsingCloud(clientId, clientSecret)
    },
    {
        id: "file-translation-with-linguistic-options-edge",
        title: "Edge",
        onClick: clientId => translateFileWithLinguisticOptionsUsingEdge(clientId)
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

const retrieveFileTranslationItems = [
    {
        id: "retrieve-file-translation-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => retrieveFileTranslation(clientId, clientSecret)
    },
    {
        id: "retrieve-file-translation-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => retrieveFileTranslationUsingCloud(clientId, clientSecret)
    },
    {
        id: "retrieve-file-translation-edge",
        title: "Edge",
        onClick: clientId => retrieveFileTranslationUsingEdge(clientId)
    }
];

const pdfBatchFileTranslationItems = [
    {
        id: "pdf-batch-file-translation-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => translatePdfBatchFile(clientId, clientSecret)
    },
    {
        id: "pdf-batch-file-translation-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => translatePdfBatchFileUsingCloud(clientId, clientSecret)
    },
    {
        id: "pdf-batch-file-translation-edge",
        title: "Edge",
        onClick: clientId => translatePdfBatchFileUsingEdge(clientId)
    }
];

const batchFileTranslationWithLinguisticOptionsItems = [
    {
        id: "batch-file-translation-with-linguistic-options-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => translateBatchFileWithLinguisticOptions(clientId, clientSecret)
    },
    {
        id: "batch-file-translation-with-linguistic-options-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => translateBatchFileWithLinguisticOptionsUsingCloud(clientId, clientSecret)
    },
    {
        id: "batch-file-translation-with-linguistic-options-edge",
        title: "Edge",
        onClick: clientId => translateBatchFileWithLinguisticOptionsUsingEdge(clientId)
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

const linguisticOptionsItems = [
    {
        id: "linguistic-options-generic",
        title: "Generic",
        onClick: (clientId, clientSecret) => getLinguisticOptions(clientId, clientSecret)
    },
    {
        id: "linguistic-options-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => getCloudLinguisticOptions(clientId, clientSecret)
    },
    {
        id: "linguistic-options-edge",
        title: "Edge",
        onClick: clientId => getEdgeLinguisticOptions(clientId)
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

const contentInsightsItems = [
    {
        id: "content-insights-for-translations-generic",
        title: "Generic - For translations",
        onClick: (clientId, clientSecret) => getContentInsightsForTranslations(clientId, clientSecret)
    },
    {
        id: "content-insights-cloud",
        title: "Cloud",
        onClick: (clientId, clientSecret) => getContentInsightsUsingCloud(clientId, clientSecret)
    },
    {
        id: "content-insights-for-translations-cloud",
        title: "Cloud - For translations",
        onClick: (clientId, clientSecret) => getContentInsightsForTranslationsUsingCloud(clientId, clientSecret)
    },
    {
        id: "content-insights-for-translation-edge",
        title: "Edge - For translation",
        onClick: clientId => getContentInsightsForTranslationsUsingEdge(clientId)
    }
];

export const samplesConfig = [
    {
        id: "text-translation",
        title: "Text Translation",
        items: textTranslationItems
    },
    {
        id: "text-translation-with-linguistic-options",
        title: "Text Translation With Linguistic Options",
        items: textTranslationWithLinguisticOptionsItems
    },
    {
        id: "file-translation",
        title: "File Translation",
        items: fileTranslationItems
    },
    {
        id: "pdf-file-translation",
        title: "PDF - File Translation",
        items: pdfFileTranslationItems
    },
    {
        id: "file-translation-with-linguistic-options",
        title: "File Translation With Linguistic Options",
        items: fileTranslationWithLinguisticOptionsItems
    },
    {
        id: "batch-file-translation",
        title: "Batch File Translation",
        items: batchFileTranslationItems
    },
    {
        id: "pdf-batch-file-translation",
        title: "PDF - Batch File Translation",
        items: pdfBatchFileTranslationItems
    },
    {
        id: "batch-file-translation-with-linguistic-options",
        title: "Batch File Translation With Linguistic Options",
        items: batchFileTranslationWithLinguisticOptionsItems
    },
    {
        id: "retrieve-file-translation",
        title: "Retrieve File Translation",
        items: retrieveFileTranslationItems
    },
    {
        id: "language-pairs",
        title: "Language Pairs",
        items: languagePairsItems
    },
    {
        id: "linguistic-options",
        title: "Linguistic Options",
        items: linguisticOptionsItems
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
    {
        id: "content-insights",
        title: "Content Insights",
        items: contentInsightsItems
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

const pdf1 = new jsPDF();
pdf1.text("The weather is wonderful today!", 10, 10);
export const file3 = new File([pdf1.output("blob")], "input3.pdf");

const pdf2 = new jsPDF();
pdf2.text("This is a new input that is part of an array translation.", 10, 10);
export const file4 = new File([pdf2.output("blob")], "input4.pdf");

const blob5 = new Blob(["j'aime cette couleur"]);
export const file5 = new File([blob5], "input5.txt", {
    type: "text/plain"
});

const blob6 = new Blob(["cette couleur est magnifique"]);
export const file6 = new File([blob6], "input6.txt", {
    type: "text/plain"
});