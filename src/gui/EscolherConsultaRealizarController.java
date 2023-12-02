package gui;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class EscolherConsultaRealizarController {
	
	@FXML
	private ChoiceBox<String> choiceBoxConsultas;
	
	@FXML
	private Button botaoEscolha;
	
	public static String cpfPacienteDaConsulta;
	
	public static int idConsultaEscolhida;
	
	public static Date dataEscolhida;
	@FXML
	public void initialize() {
		String url = "jdbc:mysql://localhost:3306/hospital?useSSL=false";
		String username = "root";
		String password = "demilovato1";

		String selectQuery = "SELECT * FROM consultas WHERE crm_Medico = ? ";
		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
			
			preparedStatement.setString(1, TelaLoginMedicoController.getcrmLogado());

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					String cpfPaciente = resultSet.getString("cpf_paciente");
					cpfPacienteDaConsulta = cpfPaciente;
					idConsultaEscolhida = resultSet.getInt("idConsulta");
					String data = resultSet.getString("dataConsulta");
					dataEscolhida = resultSet.getDate("dataConsulta");
					String infoConsulta = "CPF do paciente: " + cpfPaciente + " - " + data;
					choiceBoxConsultas.getItems().addAll(infoConsulta);
				}
			} catch (SQLException e) {
				e.getMessage();
			}

		} catch (SQLException e) {
			e.getMessage();
		}
	}
	
	public void cliqueBotaoEscolha() {
		System.out.println(idConsultaEscolhida);
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("RealizarConsulta.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Consulta");

			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}