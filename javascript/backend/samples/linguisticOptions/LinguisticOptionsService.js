const SdkFactory = require("@language-weaver/lw-sdk-js").default;
const {ClientConfiguration, GetLinguisticOptionsRequest} = require("@language-weaver/lw-sdk-js");

const getLinguisticOptions = async () => {
    try {
        const lwClient = await SdkFactory.getLanguageWeaverClient(new ClientConfiguration());
        const request = new GetLinguisticOptionsRequest();
        request.sourceLanguageId = "chi";
        request.targetLanguageId = "eng";
        request.model = "generic";
        const linguisticOptionsResult = await lwClient.getLinguisticOptions(request);
        console.log(linguisticOptionsResult.linguisticOptions);
    } catch (e) {
        console.log(e);
    }
}

getLinguisticOptions();