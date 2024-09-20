package uz.cristal.shorturl.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;


}
