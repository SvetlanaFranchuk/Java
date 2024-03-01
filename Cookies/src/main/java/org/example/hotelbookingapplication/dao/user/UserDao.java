package org.example.hotelbookingapplication.dao.user;

import org.example.hotelbookingapplication.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    User create(User user);
    User read(long id);
    List<User> readAll();
    User update(User user, long id);
    void delete(long id);
}
