const {EdgeLanguageWeaverClient} = require("@language-weaver/lw-sdk-js");

const getLanguagePairs = async () => {
    try {
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const languagePairsResult = await edgeLanguageWeaverClient.getEdgeLanguagePairs();
        console.log(languagePairsResult.languagePairs);
    } catch (e) {
        console.log(e);
    }
}

getLanguagePairs();