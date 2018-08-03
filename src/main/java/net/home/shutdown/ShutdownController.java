package net.home.shutdown;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShutdownController {
    @RequestMapping("/shutdown")
    public String shutdown() {
        return "SAMPLE";
    }
}
