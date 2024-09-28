package uz.cristal.shorturl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;



import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.cristal.shorturl.service.ShortUrlService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/url")
@Tag(name = "URL Qisqartirish", description = "URL qisqartirish bilan bog'liq API")
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    @Operation(summary = "URL qisqartirish", description = "Berilgan URL'ni qisqartiradi")
    @PostMapping("/create")
    public String shortenUrl(@RequestParam String url){
        return "http://localhost:8080/url/"+ shortUrlService.shortenUrl(url);
    }

    @Operation(summary = "Qisqartirilgan URL ni yechish", description = "Qisqartirilgan URL'dan asl URL'ga yo'naltiradi")
    @GetMapping("/{shortUrl}")
    public ModelAndView ToOriginalUrl(@PathVariable String shortUrl) {
        String theUrl = shortUrlService.getOriginalUrl(shortUrl);
        return new ModelAndView("redirect:" + theUrl);
    }

}


