const SdkFactory = require("@language-weaver/lw-sdk-js").default;
const {ClientConfiguration} = require("@language-weaver/lw-sdk-js");

const getDictionaries = async () => {
    try {
        const lwClient = await SdkFactory.getLanguageWeaverClient(new ClientConfiguration());
        const dictionariesResult = await lwClient.getDictionaries(1);
        console.log(dictionariesResult.dictionaries);
    } catch (e) {
        console.log(e);
    }
}

getDictionaries();