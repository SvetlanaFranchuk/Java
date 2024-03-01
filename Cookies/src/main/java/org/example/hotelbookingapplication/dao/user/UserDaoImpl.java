package org.example.hotelbookingapplication.dao.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.hotelbookingapplication.entity.user.Role;
import org.example.hotelbookingapplication.entity.user.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao{
@PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public User create(User user) {
        Objects.requireNonNull(user);
        user.setRole(Role.GUEST);
        user.setBlocked(false);
        entityManager.persist(user);
        return user;
    }

    @Override
    public User read(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> readAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public User update(User user, long id) {
        Objects.requireNonNull(user);
        user.setId(id);
        return entityManager.merge(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        Optional.ofNullable(read(id)).ifPresent(u -> entityManager.remove(u));
    }
}
