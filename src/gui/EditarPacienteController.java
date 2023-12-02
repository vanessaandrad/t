package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.entities.MedicoLogado;
import gui.TelaLoginMedicoController;

public class EditarPacienteController {

	@FXML
	private RadioButton radioButtonNome;

	@FXML
	private RadioButton radioButtonIdade;

	@FXML
	private RadioButton radioButtonCPF;

	@FXML
	private RadioButton radioButtonPlano;

	@FXML
	private RadioButton radioButtonSenha;

	@FXML
	private TextField textFieldEditar;

	@FXML
	private Button botaoEditar;

	@FXML
	private Label labelMensagem;

	public void editarDado() {
		String url = "jdbc:mysql://localhost:3306/hospital";
		String username = "root";
		String password = "demilovato1";

		String dadoNovo = textFieldEditar.getText();

		if (radioButtonNome.isSelected()) {
			String updateQuery = "UPDATE pacientes " + "SET nome = ? " + "WHERE " + "cpf = ?";
			try (Connection connection = DriverManager.getConnection(url, username, password);
					PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

				preparedStatement.setString(1, dadoNovo);
				preparedStatement.setString(2, TelaLoginPacienteController.getcpfLogado());

				int rowsAffected = preparedStatement.executeUpdate();

				if (rowsAffected > 0) {
					labelMensagem.setText("Edição realizada!");
				} else {
					labelMensagem.setText("Falha ao editar.");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				labelMensagem.setText("Erro ao realizar a edição.");
			}
			return;
		}

		if (radioButtonIdade.isSelected()) {
			String updateQuery = "UPDATE pacientes " + "SET idade = ? " + "WHERE " + "cpf = ?";
			try (Connection connection = DriverManager.getConnection(url, username, password);
					PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

				preparedStatement.setString(1, dadoNovo);
				preparedStatement.setString(2, TelaLoginPacienteController.getcpfLogado());

				int rowsAffected = preparedStatement.executeUpdate();

				if (rowsAffected > 0) {
					labelMensagem.setText("Edição realizada!");
				} else {
					labelMensagem.setText("Falha ao editar.");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				labelMensagem.setText("Erro ao realizar a edição.");
			}
			return;
		}
		if (radioButtonPlano.isSelected()) {
			String updateQuery = "UPDATE pacientes " + "SET plano = ? " + "WHERE " + "cpf = ?";
			try (Connection connection = DriverManager.getConnection(url, username, password);
					PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

				preparedStatement.setString(1, dadoNovo);
				preparedStatement.setString(2, TelaLoginPacienteController.getcpfLogado());

				int rowsAffected = preparedStatement.executeUpdate();

				if (rowsAffected > 0) {
					labelMensagem.setText("Edição realizada!");
				} else {
					labelMensagem.setText("Falha ao editar.");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				labelMensagem.setText("Erro ao realizar a edição.");
			}
			return;
		}
		if (radioButtonSenha.isSelected()) {
			String updateQuery = "UPDATE pacientes " + "SET senha = ? " + "WHERE " + "cpf = ?";
			try (Connection connection = DriverManager.getConnection(url, username, password);
					PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

				preparedStatement.setString(1, dadoNovo);
				preparedStatement.setString(2, TelaLoginPacienteController.getcpfLogado());

				int rowsAffected = preparedStatement.executeUpdate();

				if (rowsAffected > 0) {
					labelMensagem.setText("Edição realizada!");
				} else {
					labelMensagem.setText("Falha ao editar.");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				labelMensagem.setText("Erro ao realizar a edição.");
			}
			return;
		}
		if (radioButtonCPF.isSelected()) {
			String updateQuery = "UPDATE pacientes " + "SET cpf = ? " + "WHERE " + "cpf = ?";
			try (Connection connection = DriverManager.getConnection(url, username, password);
					PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
				
				preparedStatement.setString(1, dadoNovo);
				preparedStatement.setString(2, TelaLoginPacienteController.getcpfLogado());

				int rowsAffected = preparedStatement.executeUpdate();

				if (rowsAffected > 0) {
					labelMensagem.setText("Edição realizada!");
				} else {
					labelMensagem.setText("Falha ao editar.");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				labelMensagem.setText("Erro ao realizar a edição.");
			}
			return;
		}
	}
}