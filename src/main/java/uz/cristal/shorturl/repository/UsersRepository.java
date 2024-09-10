package uz.cristal.shorturl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.cristal.shorturl.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {
}
