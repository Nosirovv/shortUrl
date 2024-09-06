package uz.cristal.shorturl.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ShortUrl {

    @Id
    @GeneratedValue(generator = "UrlShortSeq")
    @SequenceGenerator(name = "UrlShortSeq", sequenceName = "urlshort_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "original_url", length = 1024)
    private String OriginalUrl;
    private String shortUrl;
}
