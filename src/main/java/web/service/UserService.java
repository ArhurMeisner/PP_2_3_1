package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> index();

    User showUser(long id);

    void saveUser(User user);

    void updateUser(User updatedUser, long id);

    void deleteUser(long id);
}
