package net.jaggerl.person;

public interface PersonRepository {

    void store(Person person);
    int getNumberOfPeople();
}
