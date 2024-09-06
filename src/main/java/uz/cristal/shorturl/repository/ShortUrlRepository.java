package uz.cristal.shorturl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpInc;
import uz.cristal.shorturl.entity.ShortUrl;

import java.util.Optional;

public interface ShortUrlRepository extends JpaRepository<ShortUrl,Integer> {
    Optional<ShortUrl> findByShortUrl(String shortUrl);

}
