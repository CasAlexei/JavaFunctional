package com.endava.internship.service;

import com.endava.internship.domain.Privilege;
import com.endava.internship.domain.User;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class Test {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        final List<Privilege> ALL_PRIVILEGES = asList(Privilege.values());

        final User user1 = new User(1L, "John", "Doe", 26, singletonList(Privilege.DELETE));
        final User user2 = new User(2L, "Greg", "Smith", 30, asList(Privilege.UPDATE, Privilege.CREATE, Privilege.DELETE));
        final User user3 = new User(3L, "Alex", "Smith", 13, singletonList(Privilege.DELETE));

//        final List<String> sortedFirstNames =
//                    userService.getFirstNamesReverseSorted(asList(user1, user2, user3));

        System.out.println("Get start");
//        System.out.println("getFirstNamesReverseSorted");
//        List<String> list = userService.getFirstNamesReverseSorted(asList(user1, user2, user3));
//        System.out.println(list);
//        System.out.println("shouldReturnFirstNamesSortedDesc");
//        List<User> list1 = userService.sortByAgeDescAndNameAsc(asList(user1, user2, user3));
//        System.out.println(list1);

        final int ONE_PRIVILEGE = 1;
        final int TWO_PRIVILEGES = 2;
        final int FOUR_PRIVILEGES = 4;

        final User userWith2Privileges = new User(1L, "John", "Doe", 26, asList(Privilege.UPDATE, Privilege.CREATE));
        final User userWith4Privileges = new User(2L, "Greg", "Smith", 30, ALL_PRIVILEGES);
        final User userWith1Privileges1 = new User(3L, "Alex", "Smith", 13, singletonList(Privilege.DELETE));
        final User userWith1Privileges2 = new User(3L, "Alex", "Smith", 13, singletonList(Privilege.DELETE));

        final Map<Integer, List<User>> groupedMap =
                userService.groupByCountOfPrivileges(asList(userWith2Privileges, userWith4Privileges, userWith1Privileges1, userWith1Privileges1));

        System.out.println(groupedMap);
        }
}
