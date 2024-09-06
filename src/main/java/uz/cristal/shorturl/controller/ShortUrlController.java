package uz.cristal.shorturl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import uz.cristal.shorturl.service.ShortUrlService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam String url){
        return "http://localhost:8080/"+ shortUrlService.shortenUrl(url);
    }


    @GetMapping("/{shortUrl}")
    public ModelAndView ToOriginalUrl(@PathVariable String shortUrl) {
        var theUrl = shortUrlService.getOriginalUrl(shortUrl);
        return new ModelAndView("redirect:" + theUrl);
    }

}


