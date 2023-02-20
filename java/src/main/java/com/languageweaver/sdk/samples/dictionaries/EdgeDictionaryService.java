package com.languageweaver.sdk.samples.dictionaries;

import com.languageweaver.sdk.common.edge.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.dictionaries.edge.result.EdgeDictionariesResult;

public class EdgeDictionaryService {
    public static final int PAGE_NUMBER = 1;
    public static final int PAGE_SIZE = 100;

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            final EdgeDictionariesResult dictionariesResult = lwClient.getEdgeDictionaries(PAGE_NUMBER, PAGE_SIZE);

            if (dictionariesResult.getDictionaries() != null) {
                dictionariesResult.getDictionaries()
                        .forEach(dictionary -> System.out.println(dictionary.getDictionaryId()));
            }
        }
    }
}
