package com.funie.user;

public interface FakeRepoInterface {
    void insertUser (long id, String name, String surname);
    User findById(long id);
    void deleteUser(long id);
}
