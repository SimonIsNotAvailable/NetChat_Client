package Client;

import java.io.PrintWriter;
import java.util.Scanner;

import Logger.Logger;
import Logger.LogType;

public class MessageSender implements Runnable{
    private PrintWriter out;
    private Logger log = Logger.getInstance();
    private Scanner scanner = new Scanner(System.in);

    public MessageSender(PrintWriter out) {
    this.out = out;
    }

    @Override
    public void run() {
        String msg;
        while (true) {
            msg = scanner.nextLine();
            if (!sendMessage(msg)) break;
        }
        System.exit(0);
    }
    public boolean sendMessage(String message){
        out.println(message);
        if (message.equalsIgnoreCase("/exit")){
            String byeMessage = "| You left the chat |";
            log.log(byeMessage, LogType.INFO, false);
            return false;
        } else {
            String yourMessage = "You: " + message;
            log.log(yourMessage, LogType.MESSAGE, false);
        }
        return true;
    }
}
