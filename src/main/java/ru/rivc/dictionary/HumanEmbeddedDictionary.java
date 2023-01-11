package ru.rivc.dictionary;

import org.springframework.stereotype.Component;
import ru.rivc.pojo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component("dictionary")
public class HumanEmbeddedDictionary {
    private final List<? super Human> humans = new ArrayList<>();

    public HumanEmbeddedDictionary() {
        humans.add(new Adult(1, "Ivan", LocalDate.of(1990, 2, 19), Nationality.RU, Qualification.MANAGER));
        humans.add(new Child(2, "Petr", LocalDate.of(2010, 2, 19)));
        humans.add(new Adult(3, "Sergey", LocalDate.of(1887, 2, 19)));
        humans.add(new Child(4, "Nikita", LocalDate.of(2012, 2, 19)));
        humans.add(new Adult(5, null, LocalDate.of(1870, 2, 19)));
        humans.add(new Adult(6, "Vladimir", LocalDate.of(1880, 2, 19)));
        humans.add(new Adult(7, "Sergey", LocalDate.of(1991, 2, 19)));
        humans.add(new Adult(8, "Ivan", LocalDate.of(1993, 2, 19)));
        humans.add(new Child(9, null, LocalDate.of(2016, 2, 19), Nationality.US, Education.ELEMENTARY));
        humans.add(new Adult(10, "Svetlana", LocalDate.of(1991, 2, 19)));
        humans.add(new Adult(11, "Svetlana", LocalDate.of(1990, 2, 19), Nationality.EU, Qualification.ENGINEER));

    }

    public List<? super Human> getHumans() {
        return humans;
    }

}
