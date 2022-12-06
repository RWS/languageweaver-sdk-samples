const SdkFactory = require("@language-weaver/lw-sdk-js").default;
const {ClientConfiguration} = require("@language-weaver/lw-sdk-js");

const getLanguagePairs = async () => {
    try {
        const lwClient = await SdkFactory.getLanguageWeaverClient(new ClientConfiguration());
        const languagePairsResult = await lwClient.getLanguagePairs();
        console.log(languagePairsResult.languagePairs);
    } catch (e) {
        console.log(e);
    }
}

getLanguagePairs();