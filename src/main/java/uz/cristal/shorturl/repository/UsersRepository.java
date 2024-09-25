package uz.cristal.shorturl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.cristal.shorturl.entity.Users;

import java.util.List;
import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
    List<Users> findByIsActiveTrue();

    Optional<Users> findByEmail(String email);
}
