package Client;

import Logger.Logger;
import Logger.LogType;

import Settings.Settings;

import java.io.*;
import java.net.Socket;

public class Client {
    private Logger logger = Logger.getInstance();
    private ClientRegistration clientReg;
    private MessageListener msgListener;
    private MessageSender msgSender;

    public Client() {

    }
    public boolean connectToServer() {

        String host = Settings.getProperty("host");
        int port = Integer.parseInt(Settings.getProperty("port"));

        try {
            Socket clientSocket = new Socket(host, port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            clientReg = new ClientRegistration(in, out);
            clientReg.register();

            msgListener = new MessageListener(in);
            Thread listener = new Thread(msgListener);
            listener.setDaemon(true);
            listener.start();

            msgSender = new MessageSender(out);
            Thread sender = new Thread(msgSender);
            sender.start();

        } catch (IOException e) {
            String troubles = "| Connection troubles |";
            System.out.println(troubles);
            logger.log(troubles, LogType.ERROR, false);
            return false;
        }
        return true;
    }
}
