package uz.cristal.shorturl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.expression.spel.ast.OpInc;
import org.springframework.stereotype.Repository;
import uz.cristal.shorturl.entity.ShortUrl;

import java.util.Optional;
@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl,Integer> {
    Optional<ShortUrl> findByShortUrl(String shortUrl);

    @Query("select s from ShortUrl s where s.OriginalUrl = ?1")
    ShortUrl findByOriginalUrl(String originalUrl);

}
