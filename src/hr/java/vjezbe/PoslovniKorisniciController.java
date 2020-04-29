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

public class PoslovniKorisniciController {
	
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
	
	public void prikaziPrivatniKorisnik() {
		try {
			BorderPane center = FXMLLoader.load(Main.class.getResource("PrivatniKorisnici.fxml"));
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
	private TableView<PoslovniKorisnik> tablicaKorisnika = new TableView<PoslovniKorisnik>();

	@FXML
	private TableColumn<PoslovniKorisnik, String> kolonaTabliceZaIme = new TableColumn<PoslovniKorisnik, String>();

	@FXML
	private TableColumn<PoslovniKorisnik, String> kolonaTabliceZaWeb = new TableColumn<PoslovniKorisnik, String>();

	@FXML
	private TableColumn<PoslovniKorisnik, String> kolonaTabliceZaMail = new TableColumn<PoslovniKorisnik, String>();
	
	@FXML
	private TableColumn<PoslovniKorisnik, String> kolonaTabliceZaMobitel = new TableColumn<PoslovniKorisnik, String>();
	
	@FXML
	private TextField imeId;

	@FXML
	private TextField webId;
	
	@FXML
	private TextField emailId;

	@FXML
	private TextField telefonId;
	
	List<Korisnik> allItems = Datoteke.dohvatiKorisnike();
	
	List<PoslovniKorisnik> listItems = allItems.stream().filter(p -> p
			instanceof PoslovniKorisnik).map(sc -> (PoslovniKorisnik)sc).collect(Collectors.toList());
	
	@FXML
	public void initialize() {
		allItems = Datoteke.dohvatiKorisnike();
		
		listItems = allItems.stream().filter(p -> p
				instanceof PoslovniKorisnik).map(sc -> (PoslovniKorisnik)sc).collect(Collectors.toList());
		
		ObservableList<PoslovniKorisnik> listaKorisnika = FXCollections
				.observableArrayList(listItems);
		
		factories();
		
		tablicaKorisnika.setItems(listaKorisnika);

    }
	
	private void factories() {
		
		kolonaTabliceZaIme.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("web"));
		
		kolonaTabliceZaWeb.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("naziv"));
		
		kolonaTabliceZaMail.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("email"));
		
		kolonaTabliceZaMobitel.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("telefon"));
	}
	
	@FXML
	private void stisnutGumb() {
		
		List<PoslovniKorisnik> tempLista;
		
		String Ime = imeId.getText();
		
		String Web = webId.getText();

		String Email = emailId.getText();
		
		String Telefon = telefonId.getText();



		tempLista = listItems.stream()
				.filter(o -> o.getNaziv().toUpperCase().contains(Ime.toUpperCase())
				&& o.getWeb().toUpperCase().contains(Web.toUpperCase())
				&& o.getEmail().toUpperCase().contains(Email.toUpperCase())
				&& o.getTelefon().toUpperCase().contains(Telefon.toUpperCase()))
				.collect(Collectors.toList());
		
		ObservableList<PoslovniKorisnik> listaKorisnika = FXCollections
				.observableArrayList(tempLista);
		
		tablicaKorisnika.setItems(listaKorisnika);
		
	}
}