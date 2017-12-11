import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.Scene;

import javax.swing.*;


public class CalDriver extends Application{
    Cal test = new Cal("Monday");
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        List<String> choices = new ArrayList<>();
        choices.add("Set Day");
        choices.add("Print the day");
        choices.add("Get the day");
        choices.add("Next Day");
        choices.add("Previous Day");
        choices.add("Add Days");
        choices.add("Subtract Days");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Choose an operation to perform", choices);
        dialog.setTitle("What to do");
        dialog.setHeaderText("What would you like to do?");
        dialog.setContentText("Please choose an action");


        int count = 0;
        do {

            Optional<String> selection = dialog.showAndWait();
            String selected = selection.get();
            if (selection.isPresent()) {
                switch (selected) {
                    case "Please choose an action":
                        Alert noAction = new Alert(Alert.AlertType.INFORMATION);
                        noAction.setHeaderText("Select an Action");
                        noAction.showAndWait();
                        break;
                    case "Set Day":
                        String name = JOptionPane.showInputDialog(null, "What Day is it?");
                        test.setDay(name);
                        break;
                    case "Print the day":
                        JOptionPane.showMessageDialog(null, test.toString());
                        break;
                    case "Get the day":
                        JOptionPane.showMessageDialog(null, test.getDay());
                        break;
                    case "Next Day":
                        JOptionPane.showMessageDialog(null, test.findDay(1));
                        break;
                    case "Previous Day":
                        JOptionPane.showMessageDialog(null, test.findDay(-1));
                        break;
                    case "Add Days":
                        String daysVar = JOptionPane.showInputDialog(null, "How Many days to add?:");
                        int numOfDays1 = Integer.parseInt(daysVar);
                        JOptionPane.showMessageDialog(null, "The day is: " + test.findDay(numOfDays1));
                        break;
                    case "Subtract Days":
                        String numOfDays2 = JOptionPane.showInputDialog(null, "How many days to subtract?:");
                        int numOfDays3 = Integer.parseInt(numOfDays2);
                        JOptionPane.showMessageDialog(null, "The day is: " + test.findDay(numOfDays3));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, " ");

                }
            } else {
                JOptionPane.showMessageDialog(null, test.toString());
                System.exit(0);
                count++;
            }
        } while (count < 100);
    }

}

