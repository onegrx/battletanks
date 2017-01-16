package edu.paszgr.control;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameInfoLogger {


    Logger logger = Logger.getLogger("GameInfoLogger");
    FileHandler fh;

    public GameInfoLogger(String filePath) {
        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler(filePath);
            logger.addHandler(fh);
            logger.setLevel(Level.FINEST);
            MyFormatter formatter = new MyFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            logger.finest("Start Logging");

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void log(String info) {
        logger.finest(info);
    }



}

