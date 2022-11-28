package com.languageweaver.sdk.samples.dictionaries;

import com.languageweaver.sdk.common.cloud.CloudLanguageWeaverClient;
import com.languageweaver.sdk.translate.cloud.result.CloudDictionariesResult;

public class CloudDictionaryService {
    public static final int PAGE_NUMBER = 1;
    public static final int PAGE_SIZE = 100;

    public static final int PAGE_NUMBER = 1;
    public static final int PAGE_SIZE = 100;

    public static void main(String[] args) throws Exception {
        try (CloudLanguageWeaverClient lwClient = new CloudLanguageWeaverClient().build()) {
            final CloudDictionariesResult dictionariesResult = lwClient.getCloudDictionaries(PAGE_NUMBER, PAGE_SIZE);

            if (dictionariesResult.getDictionaries() != null) {
                dictionariesResult.getDictionaries()
                        .forEach(dictionary -> System.out.println(dictionary.getDictionaryId()));
            }
        }
    }
}
