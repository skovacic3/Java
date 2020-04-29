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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class StanoviController {
	
	public void prikaziPretraguAutomobila() {
		try {
			BorderPane center = FXMLLoader.load(Main.class.getResource("Automobili.fxml"));
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
	
	public void prikaziPrivatniKorisnik() {
		try {
			BorderPane center = FXMLLoader.load(Main.class.getResource("PrivatniKorisnici.fxml"));
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
	
	public void prikaziStanoviAdd() {
		try {
			BorderPane center = FXMLLoader.load(Main.class.getResource("StanAdd.fxml"));
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
	private TableView<Stan> tablicaStanova = new TableView<Stan>();

	@FXML
	private TableColumn<Stan, String> kolonaTabliceZaIme = new TableColumn<Stan, String>();

	@FXML
	private TableColumn<Stan, String> kolonaTabliceZaOpis = new TableColumn<Stan, String>();

	@FXML
	private TableColumn<Stan, String> kolonaTabliceZaKvadraturu = new TableColumn<Stan, String>();
	
	@FXML
	private TableColumn<Stan, String> kolonaTabliceZaCijenu = new TableColumn<Stan, String>();
	
	@FXML
	private TableColumn<Stan, String> kolonaTabliceZaStanje = new TableColumn<Stan, String>();
	
	@FXML
	private TextField naslovId;

	@FXML
	private TextField opisId;
	
	@FXML
	private TextField kvadraturaId;
	
	@FXML
	private TextField cijenaId;
	
	@FXML
	private TextField unosNazivId;

	@FXML
	private TextField unosOpisId;
	
	@FXML
	private TextField unosKvadraturaId;

	@FXML
	private TextField unosCijenaId;
	
	@FXML
	private ComboBox<String> unosStanjeId;
	
	List<Artikl> allItems = Datoteke.dohvatiArtikle();
	
	List<Stan> listItems = allItems.stream().filter(p -> p
			instanceof Stan).map(sc -> (Stan)sc).collect(Collectors.toList());
	
	
	@FXML
	public void initialize() {
		
		allItems = Datoteke.dohvatiArtikle();
		
		listItems = allItems.stream().filter(p -> p
				instanceof Stan).map(sc -> (Stan)sc).collect(Collectors.toList());
		
		ObservableList<Stan> listaStanova = FXCollections
				.observableArrayList(listItems);
		
		factories();
		
		tablicaStanova.setItems(listaStanova);
		

    }
	
	private void factories() {
		
		kolonaTabliceZaIme.setCellValueFactory(new PropertyValueFactory<Stan, String>("naslov"));
		
		kolonaTabliceZaOpis.setCellValueFactory(new PropertyValueFactory<Stan, String>("opis"));
		
		kolonaTabliceZaKvadraturu.setCellValueFactory(new PropertyValueFactory<Stan, String>("kvadratura"));
		
		kolonaTabliceZaCijenu.setCellValueFactory(new PropertyValueFactory<Stan, String>("cijena"));
		
		kolonaTabliceZaStanje.setCellValueFactory(new PropertyValueFactory<Stan, String>("stanje"));
	}
	
	@FXML
	private void stisnutGumb() {
		
		List<Stan> tempLista;
		
		String Naslov = naslovId.getText();
		
		String Opis = opisId.getText();
		
		tempLista = listItems.stream()
				.filter(o -> o.getNaslov().toUpperCase().contains(Naslov.toUpperCase())
				&& o.getOpis().toUpperCase().contains(Opis.toUpperCase())
				&& Main.intCompare(o.getKvadratura(), kvadraturaId.getText())
				&& Main.BDcompare(o.getCijena(), cijenaId.getText()))
				.collect(Collectors.toList());
		
		ObservableList<Stan> listaStanova = FXCollections
				.observableArrayList(tempLista);
		
		tablicaStanova.setItems(listaStanova);
		
	}
	
}