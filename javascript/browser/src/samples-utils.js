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
    }
];

const blob1 = new Blob(["The weather is wonderful today!"]);
export const file1 = new File([blob1], "input1.txt", {
    type: "text/plain"
});
const blob2 = new Blob(["This is a new input that is part of an array translation."]);
export const file2 = new File([blob2], "input2.txt", {
    type: "text/plain"
});