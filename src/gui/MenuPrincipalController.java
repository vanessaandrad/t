package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuPrincipalController {

	@FXML
	private Button botaoLoginMedico;

	@FXML
	private Button botaoLoginPaciente;
	
	@FXML
	private Button botaoLoginAdministrador;

	@FXML
	public void cliqueBotaoLoginMedico() {
		System.out.println("MEDICO");
		abrirTelaLoginMedico();
	}

	@FXML
	public void cliqueBotaoLoginPaciente() {
		System.out.println("PACIENTE");
		abrirTelaLoginPaciente();
	}
	
	public void cliqueBotaoLoginAdministrador() {
		abrirTelaLoginAdmin();
	}
	
	private void abrirTelaLoginAdmin() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaLoginAdmin.fxml"));
			Parent root = loader.load();
			Stage stage = new Stage();
			stage.setTitle("Login de administrador");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void abrirTelaLoginMedico() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaLoginMedico.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Tela de Operações");
			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void abrirTelaLoginPaciente() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaLoginPaciente.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Tela de Operações");
			
			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void abrirMenuPaciente() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuPaciente.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Tela de Operações");

			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}