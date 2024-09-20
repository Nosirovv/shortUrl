package uz.cristal.shorturl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.cristal.shorturl.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
