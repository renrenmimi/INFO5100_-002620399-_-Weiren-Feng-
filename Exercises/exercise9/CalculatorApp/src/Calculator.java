import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    private Label display;
    private double firstNumber = 0;
    private String operator = "";
    private boolean start = true;

    @Override
    public void start(Stage primaryStage) {
        display = new Label("0");
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setMinSize(200, 60);
        display.setStyle("-fx-font-size: 20; -fx-border-color: black; -fx-padding: 10px;");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(5);

        String[][] buttonTexts = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"C", "0", "=", "+"}
        };

        for (int i = 0; i < buttonTexts.length; i++) {
            for (int j = 0; j < buttonTexts[i].length; j++) {
                Button button = createButton(buttonTexts[i][j]);
                grid.add(button, j, i + 1);
            }
        }

        grid.add(display, 0, 0, 4, 1);

        Scene scene = new Scene(grid);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setMinSize(40, 40);
        button.setOnAction(e -> onButtonClick(text));
        return button;
    }

    private void onButtonClick(String text) {
        if (text.equals("C")) {
            display.setText("0");
            start = true;
            operator = "";
            firstNumber = 0;
            return;
        }

        if (text.matches("[0-9]")) {
            if (start) {
                display.setText(text);
                start = false;
            } else {
                display.setText(display.getText() + text);
            }
            return;
        }

        if (text.matches("[/\\*\\-\\+]")) {
            firstNumber = Double.parseDouble(display.getText());
            operator = text;
            start = true;
            return;
        }

        if (text.equals("=") && !operator.isEmpty()) {
            double secondNumber = Double.parseDouble(display.getText());
            double result = calculate(firstNumber, secondNumber, operator);
            display.setText(String.valueOf(result));
            operator = "";
            start = true;
        }
    }

    private double calculate(double first, double second, String operator) {
        switch (operator) {
            case "/": return first / second;
            case "*": return first * second;
            case "-": return first - second;
            case "+": return first + second;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
