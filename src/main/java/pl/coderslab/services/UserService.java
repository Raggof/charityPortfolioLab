package pl.coderslab.services;

import pl.coderslab.entity.User;

public interface UserService {
    void save(User user);

    User findByName(String name);
}
