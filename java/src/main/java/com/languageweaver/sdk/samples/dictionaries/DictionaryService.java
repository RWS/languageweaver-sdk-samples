package com.languageweaver.sdk.samples.dictionaries;

import com.languageweaver.sdk.LanguageWeaverClient;
import com.languageweaver.sdk.SdkFactory;
import com.languageweaver.sdk.configurations.ClientConfiguration;
import com.languageweaver.sdk.translate.result.DictionariesResult;

public class DictionaryService {

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            final DictionariesResult dictionariesResult = lwClient.getDictionaries();
            // handle result
        }
    }
}
