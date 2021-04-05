package com.endava.internship.service;

import com.endava.internship.domain.Privilege;
import com.endava.internship.domain.User;
import com.endava.internship.service.UserService;

import javax.jws.soap.SOAPBinding;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    @Override
    public List<String> getFirstNamesReverseSorted(List<User> users) {
        List<String> newList = users.stream()
                .sorted(Comparator.comparing(User::getFirstName).reversed())
                .map(name -> name.getFirstName())
                .collect(Collectors.toList());

        return newList;
    }

    @Override
    public List<User> sortByAgeDescAndNameAsc(final List<User> users) {
        List<User> newList = users.stream()
                .sorted(Comparator.comparingInt(User::getAge).reversed().thenComparing(User::getFirstName))
                .collect(Collectors.toList());

        return newList;
    }

    @Override
    public List<Privilege> getAllDistinctPrivileges(final List<User> users) {
        List<Privilege> listPrivilege = users.stream()
                .map(emp -> emp.getPrivileges())
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

        return listPrivilege;
    }

    @Override
    public Optional<User> getUpdateUserWithAgeHigherThan(final List<User> users, final int age) {
        Optional<User> userHigherAge = users.stream()
                .filter(user -> user.getAge() > age)
                .findFirst();

        return userHigherAge;
    }

    @Override
    public Map<Integer, List<User>> groupByCountOfPrivileges(final List<User> users) {
        Map<Integer, List<User>> mapUsers = users.stream()
                .collect(Collectors.groupingBy(emp -> emp.getPrivileges().size()));

        return mapUsers;
    }

    @Override
    public double getAverageAgeForUsers(final List<User> users) {

        return users.stream().collect(Collectors.averagingInt(user -> user.getAge()));
    }

    @Override
    public Optional<String> getMostFrequentLastName(final List<User> users) {

        Map<String, Long> mapUsers;

               Optional opt =  users.stream()
                .collect(Collectors.groupingBy(User::getLastName, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .findFirst();

        //System.out.println(opt);

    return opt;
    }

    @Override
    public List<User> filterBy(final List<User> users, final Predicate<User>... predicates) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public String convertTo(final List<User> users, final String delimiter, final Function<User, String> mapFun) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Map<Privilege, List<User>> groupByPrivileges(List<User> users) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Map<String, Long> getNumberOfLastNames(final List<User> users) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
