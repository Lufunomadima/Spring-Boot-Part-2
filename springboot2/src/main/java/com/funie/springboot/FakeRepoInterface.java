package com.funie.springboot;

import com.funie.springboot.model.User;

public interface FakeRepoInterface {
    void insertUser (long id, String name, String surname);
    User findById(long id);
    void deleteUser(long id);
}
