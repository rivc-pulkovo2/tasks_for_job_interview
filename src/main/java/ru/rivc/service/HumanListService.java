package ru.rivc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rivc.dictionary.HumanEmbeddedDictionary;


/**
 * The type Human list service.
 * Service to work with in-memory dictionary
 * TODO methods for task 1,2 and 3
 */
@Service
public class HumanListService {
    private final HumanEmbeddedDictionary dictionary;

    /**
     * Instantiates a new Human list service.
     *
     * @param dictionary the dictionary
     */
    @Autowired
    public HumanListService(HumanEmbeddedDictionary dictionary) {
        this.dictionary = dictionary;
    }

    //TODO findById

    //TODO groupByName

    //TODO getRandomHumanForLottery()

}
