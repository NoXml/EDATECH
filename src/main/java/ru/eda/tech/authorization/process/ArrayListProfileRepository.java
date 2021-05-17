package ru.eda.tech.authorization.process;

import java.util.ArrayList;

public class ArrayListProfileRepository extends ListProfileRepository {

    protected ArrayListProfileRepository() {
        super(new ArrayList<>());
    }
}
