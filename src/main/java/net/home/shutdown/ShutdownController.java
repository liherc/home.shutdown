package net.home.shutdown;

import net.home.shutdown.managers.Shutdown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShutdownController {

    @Autowired
    private Shutdown shutdownManager;

    @RequestMapping("/shutdown")
    public ResponseEntity shutdown() {
        return shutdownManager.shutdown();
    }

    @RequestMapping("/status")
    public ResponseEntity getStatus(){
        return shutdownManager.getStatus();
    }

}
