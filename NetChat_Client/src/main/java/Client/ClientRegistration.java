package Client;

import Logger.Logger;
import Logger.LogType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ClientRegistration {

    private Logger logger = Logger.getInstance();
    private BufferedReader in;
    private PrintWriter out;

    public ClientRegistration(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    public boolean register() {
        try {
            String serverMessage = in.readLine();
            System.out.println(serverMessage);
            Scanner scanner = new Scanner(System.in);
            String name = null;
            while (name == null) {
                name = scanner.nextLine();
                out.println(name);
                serverMessage = in.readLine();
                System.out.println(serverMessage);
                if (serverMessage.contains("This name is occupied, please use another one:")) {
                    name = null;
                } else
                    break;
            }
        } catch (IOException e) {
            String trouble = "| Cannot connect to server |";
            System.out.println(trouble);
            logger.log(trouble, LogType.ERROR, false);
            return false;
        }
        return true;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
