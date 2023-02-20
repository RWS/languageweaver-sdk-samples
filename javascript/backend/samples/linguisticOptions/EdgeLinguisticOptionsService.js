const {EdgeLanguageWeaverClient, EdgeGetLinguisticOptionsRequest} = require("@language-weaver/lw-sdk-js");

const getLinguisticOptions = async () => {
    try {
        const edgeLanguageWeaverClient = await new EdgeLanguageWeaverClient().build();
        const request = new EdgeGetLinguisticOptionsRequest();
        request.sourceLanguageId = "chi";
        request.targetLanguageId = "eng";
        request.model = "Generic";
        // request.platform = "SRV";
        // request.technology = "TNMV";
        const linguisticOptionsResult = await edgeLanguageWeaverClient.getEdgeLinguisticOptions(request);
        console.log(linguisticOptionsResult.linguisticOptions);
    } catch (e) {
        console.log(e);
    }
}

getLinguisticOptions();