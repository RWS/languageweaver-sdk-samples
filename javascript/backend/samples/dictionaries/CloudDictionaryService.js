const {CloudLanguageWeaverClient} = require("@language-weaver/lw-sdk-js");

const getDictionaries = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const dictionariesResult = await cloudLanguageWeaverClient.getCloudDictionaries(1);
        console.log(dictionariesResult.dictionaries);
    } catch (e) {
        console.log(e);
    }
}

getDictionaries();