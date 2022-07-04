package africa.semicolon.hostelManagementSystem.data.repositories;

import africa.semicolon.hostelManagementSystem.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository <User, String> {
    Optional <User> findByEmail(String email);

    boolean existsByEmail(String email);
}
