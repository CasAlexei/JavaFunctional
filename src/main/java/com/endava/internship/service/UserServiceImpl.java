package com.endava.internship.service;

import com.endava.internship.domain.Privilege;
import com.endava.internship.domain.User;
import com.endava.internship.service.UserService;

import javax.jws.soap.SOAPBinding;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

public class UserServiceImpl implements UserService {

    @Override
    public List<String> getFirstNamesReverseSorted(List<User> users) {
        return users.stream()
                .map(name -> name.getFirstName())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    @Override
    public List<User> sortByAgeDescAndNameAsc(final List<User> users) {
        return users.stream()
                .sorted(Comparator.comparingInt(User::getAge).reversed().thenComparing(User::getFirstName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Privilege> getAllDistinctPrivileges(final List<User> users) {
        return users.stream()
                .map(User::getPrivileges)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> getUpdateUserWithAgeHigherThan(final List<User> users, final int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .findFirst();
    }

    @Override
    public Map<Integer, List<User>> groupByCountOfPrivileges(final List<User> users) {
        return users.stream()
                .collect(groupingBy(emp -> emp.getPrivileges().size()));
    }

    @Override
    public double getAverageAgeForUsers(final List<User> users) {
        if(users.size() == 0)
            return -1;
        else
            return users.stream().collect(Collectors.averagingInt(User::getAge));
    }

    @Override
    public Optional<String> getMostFrequentLastName(final List<User> users) {
        return users.stream()
                .collect(groupingBy(User::getLastName, Collectors.counting()))
                .entrySet()
                .stream()
                       .filter(entry -> entry.getValue() >=2)
                       .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                       .map(Map.Entry::getKey)
                       .findFirst();
    }

    @Override
    public List<User> filterBy(final List<User> users, final Predicate<User>... predicates) {
        return users.stream()
                .filter(Arrays.stream(predicates).reduce(is -> true, Predicate::and))
                .collect(Collectors.toList());
    }

    @Override
    public String convertTo(final List<User> users, final String delimiter, final Function<User, String> mapFun) {
        return users.stream()
                .map(mapFun)
                .collect(Collectors.joining(delimiter));
    }

    @Override
    public Map<Privilege, List<User>> groupByPrivileges(List<User> users) {
        return users.stream()
            .flatMap(user -> user.getPrivileges().stream().map(privilege ->
                {
                    Map<Privilege, User> map = new HashMap<>();
                    map.put(privilege, user);
                    return map.entrySet();
                }
            ))
            .flatMap(Set::stream)
            .collect(groupingBy(Map.Entry::getKey, mapping(Map.Entry::getValue, Collectors.toList())));
    }

    @Override
    public Map<String, Long> getNumberOfLastNames(final List<User> users) {
        return users.stream()
                .collect(groupingBy(User::getLastName, Collectors.counting()));
    }
}
