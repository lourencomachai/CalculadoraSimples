package views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ViewController implements Initializable {

	@FXML
	private Label txtResult;

	@FXML
	private Label txtText;

	@FXML
	private Label lblAdd;

	@FXML
	private Label lblSub;

	@FXML
	private Label lblMult;

	@FXML
	private Label lblDiv;

	@FXML
	private Label lblEqual;

	@FXML
	private Label lblClear;

	@FXML
	private Label lblOperator;

	@FXML
	private Label lblVal1;

	public void onMauseOver(MouseEvent event) {
		Label lbl = (Label) event.getSource();
		lbl.setStyle("-fx-background-color: #b5b4b4;");
	}

	public void onMouseExit(MouseEvent event) {
		Label lbl = (Label) event.getSource();
		lbl.setStyle("-fx-background-color: #eee;");
	}

	public void onLblNumClickClick(MouseEvent event) {
		String text = txtText.getText() + ((Label) event.getSource()).getText();
		txtText.setText(text);
	}

	public void onLblDelClick(MouseEvent event) {
		String text = txtText.getText();
		char[] TextArray = text.toCharArray();
		if (TextArray.length > 0) {
			char[] nArray = new char[TextArray.length - 1];
			for (int i = 0; i < TextArray.length - 1; i++) {
				nArray[i] = TextArray[i];
			}
			text = new String(nArray);
		}

		txtText.setText(text);
	}

	public void onClearClick(MouseEvent event) {
		txtText.setText("");
		txtResult.setText("0");
		lblVal1.setText("");
		lblOperator.setText("");
	}

	// action for + - / * operators
	public void onOperatorClick(MouseEvent event) {
		try {
			lblOperator.setText(((Label) event.getSource()).getText());
			if (lblVal1.getText().equalsIgnoreCase("")) {
				lblVal1.setText(txtText.getText());
				txtText.setText("");
			}

			// continue
			if (!txtResult.getText().equalsIgnoreCase("0")) {
				lblVal1.setText(txtResult.getText());
				txtText.setText("");
			}
		} catch (Exception e) {

		}
	}

	// for = operator action
	public void onEqualsClick(MouseEvent event) {
		try {
			if (lblOperator.getText().equalsIgnoreCase("+")) {
				double val1 = Double.parseDouble(lblVal1.getText());
				double val2 = Double.parseDouble(txtText.getText());
				double result = sum(val1, val2);
				txtResult.setText(String.valueOf(result));
			} else if (lblOperator.getText().equalsIgnoreCase("-")) {
				double val1 = Double.parseDouble(lblVal1.getText());
				double val2 = Double.parseDouble(txtText.getText());
				double result = sub(val1, val2);
				txtResult.setText(String.valueOf(result));
			} else if (lblOperator.getText().equalsIgnoreCase("/")) {
				double val1 = Double.parseDouble(lblVal1.getText());
				double val2 = Double.parseDouble(txtText.getText());
				double result = div(val1, val2);
				txtResult.setText(String.valueOf(result));

			} else {
				double val1 = Double.parseDouble(lblVal1.getText());
				double val2 = Double.parseDouble(txtText.getText());
				double result = mult(val1, val2);
				txtResult.setText(String.valueOf(result));
			}
		} catch (Exception e) {

		}
	}

	public double sum(double a, double b) {
		return a + b;
	}

	public double div(double a, double b) {
		return a / b;
	}

	public double sub(double a, double b) {
		return a - b;
	}

	public double mult(double a, double b) {
		return a * b;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
