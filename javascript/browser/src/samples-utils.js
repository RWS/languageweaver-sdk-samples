import jsPDF from "jspdf";

import {
    translateTextUsingEdge,
    translateTextWithLinguisticOptionsUsingEdge
} from "./samples/translations/text/EdgeTextTranslationService";
import {
    translateFileUsingEdge, translateFileWithLinguisticOptionsUsingEdge,
    translatePdfFileUsingEdge
} from "./samples/translations/file/EdgeFileTranslationService";
import {
    translateBatchFileUsingEdge, translateBatchFileWithLinguisticOptionsUsingEdge,
    translatePdfBatchFileUsingEdge
} from "./samples/translations/file/batch/EdgeBatchFileTranslationService";
import {getEdgeLanguagePairs} from "./samples/lps/EdgeLanguagePairService";
import {getEdgeDictionaries} from "./samples/dictionaries/EdgeDictionaryService";
import {getEdgeFeedback} from "./samples/feedback/read/EdgeFeedbackReadService";
import {createEdgeFeedback} from "./samples/feedback/create/EdgeFeedbackCreateService";
import {updateEdgeFeedback} from "./samples/feedback/update/EdgeFeedbackUpdateService";
import {updateEdgeFeedbackApproval} from "./samples/feedback/update/approvalStatus/EdgeFeedbackApprovalUpdateService";
import {deleteEdgeFeedback} from "./samples/feedback/delete/EdgeFeedbackDeleteService";
import {
    retrieveFileTranslationUsingEdge
} from "./samples/translations/file/retrieve/EdgeRetrieveFileTranslationService";
import {getEdgeLinguisticOptions} from "./samples/linguisticOptions/EdgeLinguisticOptionsService";
import {getContentInsightsForTranslationsUsingEdge} from "./samples/content-insights/EdgeContentInsightsService";

const textTranslationItems = [
    {
        id: "text-translation-edge",
        title: "Edge",
        onClick: clientId => translateTextUsingEdge(clientId)
    }
];

const textTranslationWithLinguisticOptionsItems = [
    {
        id: "text-translation-with-linguistic-options-edge",
        title: "Edge",
        onClick: clientId => translateTextWithLinguisticOptionsUsingEdge(clientId)
    }
];

const fileTranslationItems = [
    {
        id: "file-translation-edge",
        title: "Edge",
        onClick: clientId => translateFileUsingEdge(clientId)
    }
];

const pdfFileTranslationItems = [
    {
        id: "pdf-file-translation-edge",
        title: "Edge",
        onClick: clientId => translatePdfFileUsingEdge(clientId)
    }
];

const fileTranslationWithLinguisticOptionsItems = [
    {
        id: "file-translation-with-linguistic-options-edge",
        title: "Edge",
        onClick: clientId => translateFileWithLinguisticOptionsUsingEdge(clientId)
    }
];

const batchFileTranslationItems = [
    {
        id: "batch-file-translation-edge",
        title: "Edge",
        onClick: clientId => translateBatchFileUsingEdge(clientId)
    }
];

const retrieveFileTranslationItems = [
    {
        id: "retrieve-file-translation-edge",
        title: "Edge",
        onClick: clientId => retrieveFileTranslationUsingEdge(clientId)
    }
];

const pdfBatchFileTranslationItems = [
    {
        id: "pdf-batch-file-translation-edge",
        title: "Edge",
        onClick: clientId => translatePdfBatchFileUsingEdge(clientId)
    }
];

const batchFileTranslationWithLinguisticOptionsItems = [
    {
        id: "batch-file-translation-with-linguistic-options-edge",
        title: "Edge",
        onClick: clientId => translateBatchFileWithLinguisticOptionsUsingEdge(clientId)
    }
];

const languagePairsItems = [
    {
        id: "language-pairs-edge",
        title: "Edge",
        onClick: clientId => getEdgeLanguagePairs(clientId)
    }
];

const linguisticOptionsItems = [
    {
        id: "linguistic-options-edge",
        title: "Edge",
        onClick: clientId => getEdgeLinguisticOptions(clientId)
    }
];

const dictionariesItems = [
    {
        id: "dictionaries-edge",
        title: "Edge",
        onClick: clientId => getEdgeDictionaries(clientId)
    }
];

const readFeedbackItems = [
    {
        id: "feedback-edge",
        title: "Edge",
        onClick: clientId => getEdgeFeedback(clientId)
    }
];

const createFeedbackItems = [
    {
        id: "create-feedback-edge",
        title: "Edge",
        onClick: clientId => createEdgeFeedback(clientId)
    }
];

const updateFeedbackItems = [
    {
        id: "update-feedback-edge",
        title: "Edge",
        onClick: clientId => updateEdgeFeedback(clientId)
    }
];

const updateFeedbackApprovalItems = [
    {
        id: "update-feedback-approval-edge",
        title: "Edge",
        onClick: clientId => updateEdgeFeedbackApproval(clientId)
    }
];

const deleteFeedbackItems = [
    {
        id: "delete-feedback-edge",
        title: "Edge",
        onClick: clientId => deleteEdgeFeedback(clientId)
    }
];

const contentInsightsItems = [
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