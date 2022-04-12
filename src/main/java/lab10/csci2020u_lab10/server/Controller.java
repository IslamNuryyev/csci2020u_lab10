package lab10.csci2020u_lab10.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Controller {
    @FXML private TextArea messages;

    private List<ChatClientHandler> clientHandlers;
    private ServerSocket serverSocket = null;
    private NetworkHandler listener = null;

    public void initialize() {
        this.clientHandlers = new ArrayList<>();
        try {
            this.serverSocket = new ServerSocket(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        listener = new NetworkHandler(this, this.serverSocket);
        Thread listenerThread = new Thread(listener);
        listenerThread.start();
    }

    public void addClientHandler(ChatClientHandler newHandler) {
        this.clientHandlers.add(newHandler);
    }

    public void addMessage(String message) {
        if (message != null) {
            this.messages.appendText(message + "\n");
            System.out.println("Added message: " + message);
        }
    }

    public void exit() {
        for (ChatClientHandler handler : this.clientHandlers) {
            handler.stop();
        }

        try {
            this.listener.stop();
            this.serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
