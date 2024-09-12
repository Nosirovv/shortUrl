package uz.cristal.shorturl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.cristal.shorturl.entity.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    List<Users> findByIsActiveTrue();
}
