package uz.cristal.shorturl.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public interface ShortUrlService {

    //url qisqartirish uchun service
    String shortenUrl(String originalUrl);

    //original urlga yo'naltirish uchun service
    String getOriginalUrl(String shortUrl);


}
