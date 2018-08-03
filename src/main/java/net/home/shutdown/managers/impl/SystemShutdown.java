package net.home.shutdown.managers.impl;

import net.home.shutdown.entities.ShutdownStatus;
import net.home.shutdown.managers.Shutdown;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class SystemShutdown implements Shutdown {

    private ShutdownStatus status = ShutdownStatus.READY;

    @Override
    public ResponseEntity shutdown() {
        String shutdownCommand;
        String operatingSystem = System.getProperty("os.name");

        if ("Linux".equals(operatingSystem) || "Mac OS X".equals(operatingSystem)) {
            shutdownCommand = "shutdown -h now";
        }
        else if ("Windows".equals(operatingSystem)) {
            shutdownCommand = "shutdown.exe -s -t 0";
        }
        else {
            throw new RuntimeException("Unsupported operating system.");
        }
        status = ShutdownStatus.INPROGRESS;
        try{
            Runtime.getRuntime().exec(shutdownCommand);
        }
        catch (IOException e) {
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return getStatus();
//        System.exit(0);
    }

    @Override
    public ResponseEntity getStatus() {
        switch (status) {
            case INPROGRESS:
                return ResponseEntity.accepted().body("IN PROGRESS");
            case READY:
                return ResponseEntity.ok("OK");
            default:
                return null;
        }
    }
}
