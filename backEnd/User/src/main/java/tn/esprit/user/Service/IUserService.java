package tn.esprit.user.Service;

import tn.esprit.user.Entity.User;

import java.util.List;

public interface IUserService { User SaveUser(User user);
    List<User> getAllUsers();
    User updateUser(Long id, User userDetails);
    void deleteUser(Long id);
}