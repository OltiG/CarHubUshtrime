package dev.oltijanuzi.carhubushtrime.repository;

import dev.oltijanuzi.carhubushtrime.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findCustomerByAddress(String address);

    Optional<User> findCustomerByEmail(String email);

    Optional<User> findCustomerByName(String name);

    Optional<User> findCustomerBySurname(String surname);

    List<User> findCustomersByCity(String city);

    List<User> findCustomersByPhone(String phone);

    List<User> findCustomersByAddress(String address);

    List<User> findCustomersByState(String state);

    List<User> findCustomersByZip(String zip);
}
