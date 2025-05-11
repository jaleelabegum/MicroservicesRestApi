package com.example.MicroServiceOne.DAO;

import com.example.MicroServiceOne.Entities.User;
//import com.example.MicroServiceOne.Entities.UserWithTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.uuid = :uuid")
    List<User> findUserByuuid(Integer uuid);

    @Query("SELECT u, t FROM User u JOIN Tasks t ON u.email = t.foreignKeyusers WHERE u.email = :email")
    List<Object[]> findUserTasksByEmail(@Param("email") String email);


    @Query("DELETE FROM User u WHERE u.uuid = :uuid")
    boolean deleteUserById(Integer uuid);

    @Query("SELECT u FROM User u WHERE u.uuid = :uuid")
    Optional<User> findByUuid(Integer uuid);

    @Query("SELECT u FROM User u WHERE u.city = :city")
    List<User> findByCity(String city);







    //boolean exists(String valueOf);



    //@Query("SELECT new com.example.Entities.UserWithTasks(u, t) " +
      //      "FROM User u, Tasks t " +
      //      "WHERE LOWER(u.email) = LOWER(t.foreignKeyusers) " +
      //      "AND LOWER(u.email) = LOWER(:email)")
    //List<UserWithTasks> fetchUserWithTasks(@Param("email") String email);
   // List<UserWithTasks> fetchUserWithTasks(@Param("email") String email);

   // @Query("SELECT t FROM Task t JOIN User u ON t.foreignKeyusers = u.email WHERE u.email = :email")
    //List<Tasks> findTasksByUserEmail(@Param("email") String email);


    //void deleteById(Integer uuid);

    //@Query(value = "SELECT * FROM usersdetails where UserMailid=:UserMailid",nativeQuery = true)
    //Optional<User> findAUserByMailId(Integer id);

}
