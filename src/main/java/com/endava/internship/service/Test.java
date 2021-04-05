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
        final User user2 = new User(2L, "Greg", "Smith", 13, asList(Privilege.UPDATE, Privilege.CREATE, Privilege.DELETE));
        final User user3 = new User(3L, "Alex", "Smith", 13, singletonList(Privilege.DELETE));


        System.out.println("Get start");

//        Map<Integer,List<User>> map = userService.groupByCountOfPrivileges(asList(user1, user2, user3));
//        System.out.println(map);

//        final List<String> sortedFirstNames =
//                    userService.getFirstNamesReverseSorted(asList(user1, user2, user3));

//        System.out.println("getAllDistinctPrivileges");
//        List<Privilege> list = userService.getAllDistinctPrivileges(asList(user1, user2, user3));
//        System.out.println(list);

//        System.out.println("getFirstNamesReverseSorted");
//        List<String> list = userService.getFirstNamesReverseSorted(asList(user1, user2, user3));
//        System.out.println(list);

//        System.out.println("shouldReturnFirstNamesSortedDesc");
//        List<User> list1 = userService.sortByAgeDescAndNameAsc(asList(user1, user2, user3));
//        System.out.println(list1);


        userService.getMostFrequentLastName(asList(user1, user2, user3));
        }
}
