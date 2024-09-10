package uz.cristal.shorturl.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.cristal.shorturl.entity.ShortUrl;
import uz.cristal.shorturl.repository.ShortUrlRepository;
import uz.cristal.shorturl.service.ShortUrlService;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShortUrlServiceImpl implements ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    @Override
    public String shortenUrl(String originalUrl) {

        if (shortUrlRepository.findByOriginalUrl(originalUrl) != null){
            return shortUrlRepository.findByOriginalUrl(originalUrl).getShortUrl();
        }

        String generateShortUrl = "";

        do {
            generateShortUrl = UUID.randomUUID().toString().substring(0, 16);
        } while (shortUrlRepository.findByShortUrl(generateShortUrl).isPresent());


        ShortUrl shortUrl = new ShortUrl();

        shortUrl.setShortUrl(generateShortUrl);
        shortUrl.setOriginalUrl(originalUrl);

        shortUrlRepository.save(shortUrl);

        return generateShortUrl;
    }

    @Override
    public String getOriginalUrl(String shortUrl){
        ShortUrl originalurl = shortUrlRepository.findByShortUrl(shortUrl).orElse(null);

        return originalurl.getOriginalUrl();
    }


}
