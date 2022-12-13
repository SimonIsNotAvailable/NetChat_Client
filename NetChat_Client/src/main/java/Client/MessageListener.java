package Client;

import Logger.Logger;
import Logger.LogType;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class MessageListener implements Runnable{

    private Logger log = Logger.getInstance();
    private BufferedReader in;
    private PrintWriter out;
    public MessageListener (BufferedReader in){

    }

    @Override
    public void run() {

    }
}
