const {CloudLanguageWeaverClient, CloudGetLinguisticOptionsRequest} = require("@language-weaver/lw-sdk-js");

const getLinguisticOptions = async () => {
    try {
        const cloudLanguageWeaverClient = await new CloudLanguageWeaverClient().build();
        const request = new CloudGetLinguisticOptionsRequest();
        request.sourceLanguageId = "chi";
        request.targetLanguageId = "eng";
        request.model = "generic";
        const linguisticOptionsResult = await cloudLanguageWeaverClient.getCloudLinguisticOptions(request);
        console.log(linguisticOptionsResult.linguisticOptions);
    } catch (e) {
        console.log(e)
    }
}

getLinguisticOptions();