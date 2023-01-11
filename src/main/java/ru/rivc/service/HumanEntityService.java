package ru.rivc.service;

import org.springframework.stereotype.Service;
import ru.rivc.data.entity.HumanEntity;

import java.util.List;

/**
 * The type Human entity service.
 * Used to work with JPA Repository
 */
@Service
public class HumanEntityService {


    /**
     * Gets users by search query.
     * Method that must be used to find humans from task 5
     * @return the users by search query
     */
    public List<HumanEntity> getHumansBySearchQuery() {

        // TODO

        return null;
    }
}
