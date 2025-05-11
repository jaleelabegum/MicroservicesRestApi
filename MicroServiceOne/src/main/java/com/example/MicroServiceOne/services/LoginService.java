package com.example.MicroServiceOne.services;

import com.example.MicroServiceOne.Entities.User;
import com.example.MicroServiceOne.Utilities.UserNotInDatabaseException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LoginService {

    Optional<User> getUserFromDb(String UserMailid,String Password) throws UserNotInDatabaseException;

    List<User> getUserDetailsByuuid(Integer uuid);
    
    public String deleteUserByUuid(Integer uuid);

    public String updateUser(Integer uuid, User updatedUser);

    public List<User> getUsersByCity(String city) throws UserNotInDatabaseException;


}
