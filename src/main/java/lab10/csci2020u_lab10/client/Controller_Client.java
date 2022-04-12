package lab10.csci2020u_lab10.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller_Client {
    @FXML private TextField messageText;
    @FXML private TextField username;

    private Socket socket = null;
    private PrintWriter out = null;

    public void initialize() {
        try {
            this.socket = new Socket("127.0.0.1", 5000);
            this.out = new PrintWriter(this.socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage() {
        String message = username.getText() + ": " + messageText.getText();
        System.out.println("DATA:\n" + message);
        this.out.println(message + "\n");
        this.out.flush();
    }

    public void exit() {
        try {
            this.out.close();
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}

