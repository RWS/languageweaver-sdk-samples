const {EdgeLanguageWeaverClient} = require("@language-weaver/lw-sdk-js");

const getDictionaries = async () => {
    try {
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const dictionariesResult = await edgeLanguageWeaverClient.getEdgeDictionaries(1);
        console.log(dictionariesResult.dictionaries);
    } catch (e) {
        console.log(e);
    }
}

getDictionaries();