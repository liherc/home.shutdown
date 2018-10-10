package net.home.shutdown;

import net.home.shutdown.managers.Shutdown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/home")
public class ShutdownController {

    @Autowired
    private Shutdown shutdownManager;

    @RequestMapping(value = "/shutdown", method = RequestMethod.POST)
    public ResponseEntity shutdown() {
        return shutdownManager.shutdown();
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public ResponseEntity getStatus(){
        return shutdownManager.getStatus();
    }

}
