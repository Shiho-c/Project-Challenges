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

    public Controller() {
        MathFunc = new MathFunctions();
    }


    public void convert(ActionEvent event) {
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
