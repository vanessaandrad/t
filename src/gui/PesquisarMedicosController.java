package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PesquisarMedicosController {

	@FXML
	private ChoiceBox<String> choiceBoxEscolha;

	@FXML
	private TextField textFieldDado;

	@FXML
	private Button botaoPesquisar;

	@FXML
	private ListView<String> listViewResultados;

	@FXML
	public void initialize() {
		choiceBoxEscolha.getItems().setAll("Nome", "Especialidade");
	}

	public void procurarMedicos() {
		String dado = textFieldDado.getText();
		String selectQuery = null;

		String url = "jdbc:mysql://localhost:3306/hospital?useSSL=false";
		String username = "root";
		String password = "demilovato1";

		if (TelaLoginPacienteController.getPlanoLogado() == null) {
			System.out.println("NULO");
			selectQuery = "SELECT * FROM medicoscadastrados WHERE nome = ? OR especialidade = ?";
			try (Connection connection = DriverManager.getConnection(url, username, password);
					PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

				preparedStatement.setString(1, dado);
				preparedStatement.setString(2, dado);
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					List<String> listaMedicos = new ArrayList<>();
					while (resultSet.next()) {
						String nomeMedico = resultSet.getString("nome");
						String especialidadeMedico = resultSet.getString("especialidade");
						String nomeEspecialidade = nomeMedico + " - " + especialidadeMedico;

						listaMedicos.add(nomeEspecialidade);
					}
					System.out.println("Lista de Médicos: " + listaMedicos);
					listViewResultados.getItems().setAll(listaMedicos);
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return;
		} else if (choiceBoxEscolha.getValue().equals("Nome")) {
			System.out.println("NOME");
			selectQuery = "SELECT * FROM medicoscadastrados WHERE plano_atendido = ? AND nome = ?";
			try (Connection connection = DriverManager.getConnection(url, username, password);
					PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

				preparedStatement.setString(1, TelaLoginPacienteController.getPlanoLogado()); 
		        preparedStatement.setString(2, dado);
		        
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					List<String> listaMedicos = new ArrayList<>();
					while (resultSet.next()) {
						String nomeMedico = resultSet.getString("nome");
						String especialidadeMedico = resultSet.getString("especialidade");
						String nomeEspecialidade = nomeMedico + " - " + especialidadeMedico;

						listaMedicos.add(nomeEspecialidade);
					}
					System.out.println("Lista de Médicos: " + listaMedicos);
					listViewResultados.getItems().setAll(listaMedicos);
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return;
		}
		else if(choiceBoxEscolha.getValue().equals("Especialidade")){
			System.out.println("ESPEC");
			selectQuery = "SELECT * FROM medicoscadastrados WHERE plano_atendido = ? AND especialidade = ?";
			try (Connection connection = DriverManager.getConnection(url, username, password);
					PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

				preparedStatement.setString(1, TelaLoginPacienteController.getPlanoLogado()); 
		        preparedStatement.setString(2, dado);
		        
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					List<String> listaMedicos = new ArrayList<>();
					while (resultSet.next()) {
						String nomeMedico = resultSet.getString("nome");
						String especialidadeMedico = resultSet.getString("especialidade");
						String nomeEspecialidade = nomeMedico + " - " + especialidadeMedico;

						listaMedicos.add(nomeEspecialidade);
					}
					System.out.println("Lista de Médicos: " + listaMedicos);
					listViewResultados.getItems().setAll(listaMedicos);
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return;
		}
	}
}