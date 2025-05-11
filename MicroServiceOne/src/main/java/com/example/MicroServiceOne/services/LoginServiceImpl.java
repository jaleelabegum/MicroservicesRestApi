package com.example.MicroServiceOne.services;

import com.example.MicroServiceOne.DAO.UserDao;
import com.example.MicroServiceOne.Entities.User;
import com.example.MicroServiceOne.Utilities.UserNotInDatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserDao userDao;

    @Override
    public Optional<User> getUserFromDb(String UserMailid, String Password) throws UserNotInDatabaseException {
        Optional<User> user1 = userDao.findByEmail(UserMailid);
        if (user1.isPresent()) {
            User user = user1.get();
            if (user.getEmail().equals(UserMailid)) {
                throw new UserNotInDatabaseException("Wrong Mail id");
            }
            if (user.getPassword().equals(Password)) {
                throw new UserNotInDatabaseException("Wrong Password");
            }

        }


        return user1;
    }

    @Override
    public List<User> getUserDetailsByuuid(Integer uuid) {
        List<User> users = userDao.findUserByuuid(uuid);
        if (users == null || users.isEmpty()) {
            try {
                throw new UserNotInDatabaseException("User with UUID " + uuid + " not found in database.");
            } catch (UserNotInDatabaseException e) {
                throw new RuntimeException(e);
            }
        }
        return users;
    }

    public boolean userExists(Integer uuid) {
        return userDao.existsById(uuid);
    }

    // Business logic to delete user by UUID
    public String deleteUserByUuid(Integer uuid) {
        if (!userDao.existsById(uuid)) {
            throw new IllegalArgumentException("User not found with UUID: " + uuid);
        }

        userDao.deleteById(uuid);
        return "User with UUID " + uuid + " deleted successfully.";
    }
    
    public String updateUser(Integer uuid, User updatedUser) {
        Optional<User> optionalUser = userDao.findById(uuid);

        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User not found with UUID: " + uuid);
        }

        User existingUser = optionalUser.get();
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setAge(updatedUser.getAge());
        existingUser.setCity(updatedUser.getCity());
        existingUser.setCountry(updatedUser.getCountry());

        userDao.save(existingUser);
        return "User with UUID " + uuid + " updated successfully.";
    }

	@Override
    public List<User> getUsersByCity(String city) throws UserNotInDatabaseException {
        List<User> users = userDao.findByCity(city);

        if (users == null || users.isEmpty()) {
            throw new UserNotInDatabaseException("No users found in city: " + city);
        }

        return users;
    }


}

