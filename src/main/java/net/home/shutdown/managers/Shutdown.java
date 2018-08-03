package net.home.shutdown.managers;

import org.springframework.http.ResponseEntity;
import java.io.IOException;

public interface Shutdown {
    ResponseEntity shutdown();
    ResponseEntity getStatus();
}
