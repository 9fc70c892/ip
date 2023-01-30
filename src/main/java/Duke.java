import core.DukeIO;
import core.Parser;
import core.TaskMaster;
import exceptions.DukeException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * DUKE
 * CS2103 project
 * @author EDWIN LIM
 * @version 0.01
 */

public class Duke {

    private static boolean lessonmode = true;
    private static DukeIO dio;
    private static TaskMaster tm;

    /**
     * Main method for the program
     * @param args UNUSED
     */
    public static void main(String[] args) {

//        if (lessonmode) {
//            Launcher.main(args);
//        } else {
            boolean quit = false;
            String userInput;

            initialize();
            greet();


            while (!quit) {
                userInput = dio.readLn();
                if (!userInput.isEmpty()) {
                    dio.lb();
                    try {
                        Parser a = new Parser(userInput);
                        dio.println(a.parse(tm));
                    } catch (exceptions.Quit e) {
                        quit = true;
                    } catch (DukeException de) {
                        dio.println(de.getMessage());
                    }
                    dio.lb();
                    dio.flush();
                }
            }
            goodbye();
//        }
    }

    /**
     * Initialize Duke by initializing needed classes.
     */
    public static void initialize() {
        dio = new DukeIO();
        tm = new TaskMaster();
        try {
            dio.readSave(tm);
        } catch (exceptions.invalid.File e) {
            // do nothing
        } catch (DukeException e) {
            throw new RuntimeException(e); //Figure out who throws tis
        }
    }

    /**
     * Prints standard welcome message.
     */
    public static void greet() {
        String logo = "                __  __ _           \n"
                + "               / _|/ _| |          \n"
                + "__      ____ _| |_| |_| | ___  ___ \n"
                + "\\ \\ /\\ / / _` |  _|  _| |/ _ \\/ __|\n"
                + " \\ V  V / (_| | | | | | |  __/\\__ \\\n"
                + "  \\_/\\_/ \\__,_|_| |_| |_|\\___||___/\n";
        dio.println("Hello from\n" + logo + "\n");
        dio.println("Hello! I'm " + "Waffles");
        dio.println("What can I do for you?");
        dio.flush();
    }

    /**
     * Prints standard goodby message and closes DIO.
     */
    public static void goodbye() {
        dio.writeSave(tm);
        dio.println("Bye. Hope to see you again soon!");
        dio.flush();
        dio.close();
    }

//    private ScrollPane scrollPane;
//    private VBox dialogContainer;
//    private TextField userInput;
//    private Button sendButton;
//    private Scene scene;
//    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
//    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));
//
//    @Override
//    public void start(Stage stage) {
//        //Step 1. Setting up required components
//
//        //The container for the content of the chat to scroll.
//        scrollPane = new ScrollPane();
//        dialogContainer = new VBox();
//        scrollPane.setContent(dialogContainer);
//
//        userInput = new TextField();
//        sendButton = new Button("Send");
//
//        AnchorPane mainLayout = new AnchorPane();
//        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);
//
//        scene = new Scene(mainLayout);
//
//        stage.setScene(scene);
//        stage.show();
//
//        //Step 2. Formatting the window to look as expected
//        stage.setTitle("Duke");
//        stage.setResizable(false);
//        stage.setMinHeight(600.0);
//        stage.setMinWidth(400.0);
//
//        mainLayout.setPrefSize(400.0, 600.0);
//
//        scrollPane.setPrefSize(385, 535);
//        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
//        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
//
//        scrollPane.setVvalue(1.0);
//        scrollPane.setFitToWidth(true);
//
//        // You will need to import `javafx.scene.layout.Region` for this.
//        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);
//
//        userInput.setPrefWidth(325.0);
//
//        sendButton.setPrefWidth(55.0);
//
//        AnchorPane.setTopAnchor(scrollPane, 1.0);
//
//        AnchorPane.setBottomAnchor(sendButton, 1.0);
//        AnchorPane.setRightAnchor(sendButton, 1.0);
//
//        AnchorPane.setLeftAnchor(userInput , 1.0);
//        AnchorPane.setBottomAnchor(userInput, 1.0);
//
////        sendButton.setOnMouseClicked((event) -> {
////            dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
////            userInput.clear();
////        });
////
////        userInput.setOnAction((event) -> {
////            dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
////            userInput.clear();
////        });
//
//        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));
//
//        //Part 3. Add functionality to handle user input.
//        sendButton.setOnMouseClicked((event) -> {
//            handleUserInput();
//        });
//
//        userInput.setOnAction((event) -> {
//            handleUserInput();
//        });
//    }
//
//    /**
//     * Iteration 1:
//     * Creates a label with the specified text and adds it to the dialog container.
//     * @param text String containing text to add
//     * @return a label with the specified text that has word wrap enabled.
//     */
//    private Label getDialogLabel(String text) {
//        // You will need to import `javafx.scene.control.Label`.
//        Label textToAdd = new Label(text);
//        textToAdd.setWrapText(true);
//
//        return textToAdd;
//    }
//
//    /**
//     * Iteration 2:
//     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
//     * the dialog container. Clears the user input after processing.
//     */
////    private void handleUserInput() {
//////        Label userText = new Label(userInput.getText());
//////        Label dukeText = new Label(getResponse(userInput.getText()));
//////        dialogContainer.getChildren().addAll(
//////                new DialogBox(userText, new ImageView(user)),
//////                new DialogBox(dukeText, new ImageView(duke))
//////        );
//////        userInput.clear();
////
////        Label userText = new Label(userInput.getText());
////        Label dukeText = new Label(getResponse(userInput.getText()));
////        dialogContainer.getChildren().addAll(
////                DialogBox.getUserDialog(userText, new ImageView(user)),
////                DialogBox.getDukeDialog(dukeText, new ImageView(duke))
////        );
////        userInput.clear();
////    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    protected String getResponse(String input) {
        return "Duke heard: " + input;
    }

}

