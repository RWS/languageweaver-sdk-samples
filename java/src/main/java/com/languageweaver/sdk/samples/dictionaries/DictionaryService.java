package com.languageweaver.sdk.samples.dictionaries;

import com.languageweaver.sdk.common.LanguageWeaverClient;
import com.languageweaver.sdk.common.SdkFactory;
import com.languageweaver.sdk.common.configurations.ClientConfiguration;
import com.languageweaver.sdk.translate.common.result.DictionariesResult;

public class DictionaryService {
    public static final int PAGE_NUMBER = 1;
    public static final int PAGE_SIZE = 100;

    public static void main(String[] args) throws Exception {
        try (LanguageWeaverClient lwClient = new SdkFactory().getLanguageWeaverClient(new ClientConfiguration())) {
            final DictionariesResult dictionariesResult = lwClient.getDictionaries(PAGE_NUMBER, PAGE_SIZE);

            if (dictionariesResult.getDictionaries() != null) {
                dictionariesResult.getDictionaries()
                        .forEach(dictionary -> System.out.println(dictionary.getId()));
            }
        }
    }
}
