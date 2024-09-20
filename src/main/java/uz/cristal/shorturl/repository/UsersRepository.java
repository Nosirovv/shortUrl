package uz.cristal.shorturl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.cristal.shorturl.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    List<Users> findByIsActiveTrue();

    Optional<Users> findByEmail(String email);
}
