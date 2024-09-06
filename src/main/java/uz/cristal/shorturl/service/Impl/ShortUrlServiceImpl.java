package uz.cristal.shorturl.service.Impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.servlet.view.RedirectView;
import uz.cristal.shorturl.entity.ShortUrl;
import uz.cristal.shorturl.repository.ShortUrlRepository;
import uz.cristal.shorturl.service.ShortUrlService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShortUrlServiceImpl implements ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    @Override
    public String shortenUrl(String originalUrl) {

        String generateShortUrl = UUID.randomUUID().toString().substring(0, 8);

        ShortUrl shortUrl = new ShortUrl();

        shortUrl.setShortUrl(generateShortUrl);
        shortUrl.setOriginalUrl(originalUrl);

        shortUrlRepository.save(shortUrl);

        return generateShortUrl;
    }

    @Override
    public String getOriginalUrl(String shortUrl) {
        ShortUrl originalurl = shortUrlRepository.findByShortUrl(shortUrl).orElse(null);

        return originalurl.getOriginalUrl();


    }

}
