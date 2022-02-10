package com.languageweaver.sdk.samples.dictionaries;

import com.languageweaver.sdk.EdgeLanguageWeaverClient;
import com.languageweaver.sdk.translate.result.edge.EdgeDictionariesResult;

public class EdgeDictionaryService {

    public static void main(String[] args) throws Exception {
        try (EdgeLanguageWeaverClient lwClient = new EdgeLanguageWeaverClient().build()) {
            final EdgeDictionariesResult dictionariesResult = lwClient.getEdgeDictionaries();

            if (dictionariesResult.getDictionaries() != null) {
                dictionariesResult.getDictionaries()
                        .forEach(dictionary -> System.out.println(dictionary.getDictionaryId()));
            }
        }
    }
}
