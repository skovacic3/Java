package hr.java.vjezbe;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import hr.java.vjezbe.util.Datoteke;
import hr.java.vjezbe.enitet.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class PrivatniKorisniciController {
	
	public void prikaziPretraguStanova() {
		try {
			BorderPane center = FXMLLoader.load(Main.class.getResource("Stanovi.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void prikaziPretraguUsluga() {
		try {
			BorderPane center = FXMLLoader.load(Main.class.getResource("Usluge.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void prikaziPretraguAutomobila() {
		try {
			BorderPane center = FXMLLoader.load(Main.class.getResource("Automobili.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void prikaziPoslovnogKorisnik() {
		try {
			BorderPane center = FXMLLoader.load(Main.class.getResource("PoslovniKorisnici.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void prikaziUslugeAdd() {
		try {
			BorderPane center = FXMLLoader.load(Main.class.getResource("UslugaAdd.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void prikaziAutomobiliAdd() {
		try {
			BorderPane center = FXMLLoader.load(Main.class.getResource("AutomobilAdd.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void prikaziStanoviAdd() {
		try {
			BorderPane center = FXMLLoader.load(Main.class.getResource("StanAdd.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void prikaziPoslovniKorisniciAdd() {
		try {
			BorderPane center = FXMLLoader.load(Main.class.getResource("PoslovniKorisnikAdd.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void prikaziPrivatniKorisniciAdd() {
		try {
			BorderPane center = FXMLLoader.load(Main.class.getResource("PrivatniKorisnikAdd.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@FXML
	private TableView<PrivatniKorisnik> tablicaKorisnika = new TableView<PrivatniKorisnik>();

	@FXML
	private TableColumn<PrivatniKorisnik, String> kolonaTabliceZaIme = new TableColumn<PrivatniKorisnik, String>();

	@FXML
	private TableColumn<PrivatniKorisnik, String> kolonaTabliceZaPrezime = new TableColumn<PrivatniKorisnik, String>();

	@FXML
	private TableColumn<PrivatniKorisnik, String> kolonaTabliceZaMail = new TableColumn<PrivatniKorisnik, String>();
	
	@FXML
	private TableColumn<PrivatniKorisnik, String> kolonaTabliceZaMobitel = new TableColumn<PrivatniKorisnik, String>();
	
	@FXML
	private TextField imeId;

	@FXML
	private TextField prezimeId;
	
	@FXML
	private TextField emailId;

	@FXML
	private TextField telefonId;
	
	List<PrivatniKorisnik> listItems = Datoteke.dohvatiKorisnike().stream().filter(p -> p
			instanceof PrivatniKorisnik).map(sc -> (PrivatniKorisnik)sc).collect(Collectors.toList());
	
	@FXML
	public void initialize() {
		ObservableList<PrivatniKorisnik> listaKorisnika = FXCollections
				.observableArrayList(listItems);
		
		factories();
		
		tablicaKorisnika.setItems(listaKorisnika);

    }
	
	private void factories() {
		
		kolonaTabliceZaIme.setCellValueFactory(new PropertyValueFactory<PrivatniKorisnik, String>("ime"));
		
		kolonaTabliceZaPrezime.setCellValueFactory(new PropertyValueFactory<PrivatniKorisnik, String>("prezime"));
		
		kolonaTabliceZaMail.setCellValueFactory(new PropertyValueFactory<PrivatniKorisnik, String>("email"));
		
		kolonaTabliceZaMobitel.setCellValueFactory(new PropertyValueFactory<PrivatniKorisnik, String>("telefon"));
	}
	
	@FXML
	private void stisnutGumb() {
		
		List<PrivatniKorisnik> tempLista;
		
		String Ime = imeId.getText();
		
		String Prezime = prezimeId.getText();

		String Email = emailId.getText();
		
		String Telefon = telefonId.getText();



		tempLista = listItems.stream()
				.filter(o -> o.getIme().toUpperCase().contains(Ime.toUpperCase())
				&& o.getPrezime().toUpperCase().contains(Prezime.toUpperCase())
				&& o.getEmail().toUpperCase().contains(Email.toUpperCase())
				&& o.getTelefon().toUpperCase().contains(Telefon.toUpperCase()))
				.collect(Collectors.toList());
		
		ObservableList<PrivatniKorisnik> listaKorisnika = FXCollections
				.observableArrayList(tempLista);
		
		tablicaKorisnika.setItems(listaKorisnika);
		
	}
}