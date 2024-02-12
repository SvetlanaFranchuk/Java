package org.example.service;

import org.example.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final List<User> users;

    public UserService() {
        users = new ArrayList<>();
    }

    public List<User> getUsers(String lastNameStartsWith) {
        return lastNameStartsWith.isBlank() ? new ArrayList<>(users) : users.stream()
                .filter(u -> u.lastName().startsWith(lastNameStartsWith))
                .toList();
    }

    public User getUser(long id) {
        return users.stream().filter(u -> u.id() == id).findFirst().orElseThrow();
    }

    public User createUser(User candidate) {
        if (candidate.id() != null) throw new IllegalStateException("Пользователь не создан, т.к. id не равен null");
        if (users.stream().anyMatch(u -> u.lastName().equals(candidate.lastName()) &&
                u.firstName().equals(candidate.firstName()) &&
                u.email().equals(candidate.email())&&
                u.status()) //предполагаем, что нового пользователя будем создавать со статусом активный
        )
            throw new IllegalStateException("Пользователь с указанными фамилией, именем, email и статусом (активный) уже существует");
        User user = new User(candidate);
        users.add(user);
        return user;
    }

    public User updateUser(long id, User user) {
        user = new User(id, user.firstName(), user.lastName(), user.birthDate(),user.email(), user.status());
        users.removeIf(u -> u.id() == id);
        users.add(user);
        return user;
    }

    public void deleteUser(long id){
        users.removeIf(e->e.id()==id);
    }

    public User setStatus(boolean status, long id){
        User user = getUser(id);
        return updateUser(id, new User(user.id(), user.firstName(), user.lastName(), user.birthDate(),
                user.email(), status));
    }
}
