package com.funie.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import static java.lang.String.format;

    @Repository
    public class FakeRepo implements FakeRepoInterface{
        private static final Logger LOGGER = LogManager.getLogger(FakeRepo.class.getName());

        ArrayList<User> users = new ArrayList<>();

        // adding the user
        @Override
        public void insertUser(long id, String name, String surname) {
            users.add(new User(id, name, surname));
            LOGGER.info(format("name : %s", name));
        }

        // finding a user given an id
        @Override
        public User findById(long id) {
            for (User user : users) {
                if (user.getId() == id) {
                    LOGGER.info("User Found : " + user.getName());
                    return user;
                }
            }
            LOGGER.error("User Not Found");
            return null;
        }

        // removing a user given an id
        @Override
        public void deleteUser(long id) {
            users.removeIf(user -> user.getId() == id);
        }

        // printing out user information
        @Override
        public String toString() {
            return "FakeRepo{" +
                    "users=" + users +
                    '}';
        }
    }

