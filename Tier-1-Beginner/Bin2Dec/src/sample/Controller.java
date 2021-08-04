package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
    @FXML
    private TextArea ResultBox;

    @FXML
    private TextArea InputBox;

    private MathFunctions MathFunc;
    private Helper Helper;

    public Controller() {
        MathFunc = new MathFunctions();
        Helper = new Helper();
    }


    public void convert(ActionEvent event) {
        boolean isItBinary = Helper.checkBinary(InputBox.getText());
        if(!isItBinary) {
            Helper.showAlert("Warning!", "Wrong Input", "Please only enter a number between 0 and 1");
            ResultBox.setText("");
            InputBox.setText("");
            return;
        }
        ResultBox.setText("");
        String[] binaries = InputBox.getText().split("\n");
        String results = ResultBox.getText();
        for(String binary: binaries) {
            if (binary.contains(".")) {
                ArrayList<HashMap<Integer, Integer>> exponents = new ArrayList<>();
                exponents = MathFunc.getFractionalExponents(binary);
                double result_1 = MathFunc.convertToDecimal(exponents.get(0));
                double result_2 = MathFunc.convertToDecimal(exponents.get(1));
                double output = result_1 + result_2;
                results += output + "\n";
                ResultBox.setText(results);

            }
            else {
                HashMap<Integer, Integer> exponents = MathFunc.getExponents(binary);
                double output = MathFunc.convertToDecimal(exponents);
                results += output + "\n";
            }
            ResultBox.setText(results);
        }
    }

}
