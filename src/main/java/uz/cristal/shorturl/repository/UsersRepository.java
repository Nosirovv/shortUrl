package uz.cristal.shorturl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.cristal.shorturl.entity.Users;

import java.util.List;
import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
    List<Users> findByIsActiveTrue();

    Optional<Users> findByEmail(String email);

    @Query(value = "SELECT r.name FROM role r " +
            "JOIN users_roles ur ON ur.roles_id = r.id " +
            "JOIN users u ON u.id = ur.users_id " +
            "WHERE u.email = :email", nativeQuery = true)
    String findRolesByEmail(@Param("email") String email);

}
