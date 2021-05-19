package ru.eda.tech.authorization.process;

import java.util.LinkedList;

public class LinkedListProfileRepository extends ListProfileRepository {

    protected LinkedListProfileRepository() {
        super(new LinkedList<>());
    }
}
