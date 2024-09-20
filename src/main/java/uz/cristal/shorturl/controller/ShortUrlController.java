package uz.cristal.shorturl.controller;

import lombok.RequiredArgsConstructor;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.cristal.shorturl.service.ShortUrlService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/url")
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public String shortenUrl(@RequestParam String url){
        return "http://localhost:8080/url/"+ shortUrlService.shortenUrl(url);
    }


    @GetMapping("/{shortUrl}")
    public ModelAndView ToOriginalUrl(@PathVariable String shortUrl) {
        String theUrl = shortUrlService.getOriginalUrl(shortUrl);
        return new ModelAndView("redirect:" + theUrl);
    }

}


