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

public class UslugeController {
	
	public void prikaziPretraguAutomobila() {
		try {
			BorderPane center = FXMLLoader.load(Main.class.getResource("Automobili.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void prikaziPretraguStanova() {
		try {
			BorderPane center = FXMLLoader.load(Main.class.getResource("Stanovi.fxml"));
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
	private TableView<Usluga> tablicaUsluga = new TableView<Usluga>();

	@FXML
	private TableColumn<Usluga, String> kolonaTabliceZaIme = new TableColumn<Usluga, String>();

	@FXML
	private TableColumn<Usluga, String> kolonaTabliceZaOpis = new TableColumn<Usluga, String>();


	
	@FXML
	private TableColumn<Usluga, String> kolonaTabliceZaCijenu = new TableColumn<Usluga, String>();
	
	@FXML
	private TableColumn<Usluga, String> kolonaTabliceZaStanje = new TableColumn<Usluga, String>();
	
	@FXML
	private TextField naslovId;

	@FXML
	private TextField opisId;

	@FXML
	private TextField cijenaId;
	
	List<Usluga> listItems = Datoteke.dohvatiArtikle().stream().filter(p -> p
			instanceof Usluga).map(sc -> (Usluga)sc).collect(Collectors.toList());
	
	
	@FXML
	public void initialize() {
		
		ObservableList<Usluga> listaUsluga = FXCollections
				.observableArrayList(listItems);
		
		factories();
		
		tablicaUsluga.setItems(listaUsluga);
		

    }
	
	private void factories() {
		
		kolonaTabliceZaIme.setCellValueFactory(new PropertyValueFactory<Usluga, String>("naslov"));
		
		kolonaTabliceZaOpis.setCellValueFactory(new PropertyValueFactory<Usluga, String>("opis"));
				
		kolonaTabliceZaCijenu.setCellValueFactory(new PropertyValueFactory<Usluga, String>("cijena"));
		
		kolonaTabliceZaStanje.setCellValueFactory(new PropertyValueFactory<Usluga, String>("stanje"));
	}
	
	@FXML
	private void stisnutGumb() {
		
		List<Usluga> tempLista;
		
		String Naslov = naslovId.getText();
		
		String Opis = opisId.getText();
		

		tempLista = listItems.stream()
				.filter(o -> o.getNaslov().toUpperCase().contains(Naslov.toUpperCase())
				&& o.getOpis().toUpperCase().contains(Opis.toUpperCase())
				&& Main.BDcompare(o.getCijena(), cijenaId.getText()))
				.collect(Collectors.toList());
		
		ObservableList<Usluga> listaUsluga = FXCollections
				.observableArrayList(tempLista);
		
		tablicaUsluga.setItems(listaUsluga);
		
	}
}