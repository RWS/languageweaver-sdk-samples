package com.languageweaver.sdk.samples.dictionaries;

import com.languageweaver.sdk.CloudLanguageWeaverClient;
import com.languageweaver.sdk.translate.result.cloud.CloudDictionariesResult;


public class CloudDictionaryService {

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            final CloudDictionariesResult dictionariesResult = lwClient.getCloudDictionaries();

            if (dictionariesResult.getDictionaries() != null) {
                dictionariesResult.getDictionaries()
                        .forEach(dictionary -> System.out.println(dictionary.getDictionaryId()));
            }
        }
    }
}
