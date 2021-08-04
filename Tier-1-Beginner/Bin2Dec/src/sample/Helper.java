package sample;

import javafx.scene.control.Alert;

public class Helper {
    public void showAlert(String message, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(message);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public boolean checkBinary(String binary) {
        for(char c: binary.toCharArray()) {
            if(!(c == '1') && !(c == '0') && !(c == '\n')) {
                System.out.println(c);

                return false;
            }
        }
        return true;
    }
}
