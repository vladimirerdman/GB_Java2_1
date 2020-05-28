package com.geekbrains.java2.lesson4.homework;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    MenuBar menuBar;
    @FXML
    TextArea messagesList;
    @FXML
    TextField messageField;
    @FXML
    Button sendButton;
    @FXML
    private void handleAboutAction(final ActionEvent event) { System.out.println("Chat version: 1.2020.0"); }
    @FXML
    private void handleExitAction(final ActionEvent event) { System.exit(0); }

    /*
    @FXML
    private void handleKeyInput(final InputEvent event) {
        if (event instanceof KeyEvent) {
            final KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.A) { provideAboutChat(); }
        }
    }
    private void provideAboutChat() {
        System.out.println("Chat version: 1.2020.0");
    }
    */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuBar.setFocusTraversable(true);
        messagesList.setWrapText(true);
        messagesList.setEditable(false);
        sendButton.setDefaultButton(true);
        sendButton.addEventHandler(ActionEvent.ACTION, this::mouseClickButton);
        messageField.addEventHandler(KeyEvent.KEY_PRESSED, this::keyPressedAction);
    }

    //Send button
    private <T extends Event> void mouseClickButton(T event) {
        event.consume();
        sendMessage();
    }

    //Enter
    private void keyPressedAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER && !event.isControlDown()) {
            event.consume();
            sendMessage();
        }
    }

    private void sendMessage() {
        if (!messageField.getText().isEmpty()) {
            String messageText = messageField.getText();
            messagesList.appendText(getTime() + " : " + messageText + "\n");
            messageField.clear();
        }
    }

    public String getTime() {
        return new SimpleDateFormat("dd.mm.YYYY" + ", " + "HH:mm:ss").format(new Date());
    }
}