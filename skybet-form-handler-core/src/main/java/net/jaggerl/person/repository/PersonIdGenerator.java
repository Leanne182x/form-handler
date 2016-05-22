package net.jaggerl.person.repository;

public class PersonIdGenerator {

    private static PersonIdGenerator instance = new PersonIdGenerator();
    private volatile int nextPersonId = 0;

    private PersonIdGenerator() {
    }

    public static PersonIdGenerator getInstance() {
        return instance;
    }

    public synchronized int getNextSequence() {
        return nextPersonId++;
    }
}
