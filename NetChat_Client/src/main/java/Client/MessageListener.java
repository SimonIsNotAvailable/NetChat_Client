package Client;

import Logger.Logger;
import Logger.LogType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MessageListener implements Runnable {

    private Logger log = Logger.getInstance();
    private BufferedReader in;

    public MessageListener(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        while (readMessage()) ;
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean readMessage() {
        String msg;
        try {
            msg = in.readLine();
            if (msg != null) {
                System.out.println(msg);
                log.log(msg, LogType.MESSAGE, true);
            }
        } catch (IOException e) {
            String troubles = "| Troubles with connection |";
            System.out.println(troubles);
            log.log(troubles, LogType.ERROR, false);
            return false;
        }
        return true;
    }
}
