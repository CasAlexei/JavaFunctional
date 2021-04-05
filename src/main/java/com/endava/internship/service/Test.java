package com.endava.internship.service;

import com.endava.internship.domain.Privilege;
import com.endava.internship.domain.User;

import java.util.List;

import static java.util.Arrays.asList;

public class Test {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        final List<Privilege> ALL_PRIVILEGES = asList(Privilege.values());

        final User user1 = new User(1L, "John", "Doe", 26, ALL_PRIVILEGES);
        final User user2 = new User(2L, "Greg", "Smith", 30, ALL_PRIVILEGES);
        final User user3 = new User(3L, "Alex", "Smith", 13, ALL_PRIVILEGES);

//        final List<String> sortedFirstNames =
//                    userService.getFirstNamesReverseSorted(asList(user1, user2, user3));

        System.out.println("Get start");
        List<String> list = userService.getFirstNamesReverseSorted(asList(user1, user2, user3));
        System.out.println(list);
        }
}
