package uz.cristal.shorturl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.cristal.shorturl.entity.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "select r.name from role r " +
            "left join users_roles ur on ur.role_id = r.id " +
            "where ur.users_id = ?1", nativeQuery = true)
    List<String> findNamesByUserId(Integer id);
}
