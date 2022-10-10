const {CloudLanguageWeaverClient} = require("@language-weaver/lw-sdk-js");

const getLanguagePairs = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const languagePairsResult = await cloudLanguageWeaverClient.getCloudLanguagePairs();
        console.log(languagePairsResult.languagePairs);
    } catch (e) {
        console.log(e)
    }
}

getLanguagePairs();