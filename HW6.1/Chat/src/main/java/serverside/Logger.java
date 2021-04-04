package serverside;

import sun.net.www.protocol.http.logging.HttpLogFormatter;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

public class Logger {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());


    public static void recording(String s) {
        try {
            Handler h = new FileHandler("C:\\Java\\Java3\\ДЗ\\HW6.1\\123.log");
            h.setFormatter(new SimpleFormatter());
            logger.addHandler(h);
            logger.log(Level.SEVERE, s);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
