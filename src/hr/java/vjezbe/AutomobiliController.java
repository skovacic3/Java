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

public class AutomobiliController {
	
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
	private TableView<Automobil> tablicaAutomobila = new TableView<Automobil>();

	@FXML
	private TableColumn<Automobil, String> kolonaTabliceZaIme = new TableColumn<Automobil, String>();

	@FXML
	private TableColumn<Automobil, String> kolonaTabliceZaOpis = new TableColumn<Automobil, String>();

	@FXML
	private TableColumn<Automobil, String> kolonaTabliceZaSnagu = new TableColumn<Automobil, String>();
	
	@FXML
	private TableColumn<Automobil, String> kolonaTabliceZaCijenu = new TableColumn<Automobil, String>();
	
	@FXML
	private TableColumn<Automobil, String> kolonaTabliceZaStanje = new TableColumn<Automobil, String>();
	
	@FXML
	private TextField naslovId;

	@FXML
	private TextField opisId;
	
	@FXML
	private TextField snagaId;

	@FXML
	private TextField cijenaId;
	
	List<Automobil> listItems = Datoteke.dohvatiArtikle().stream().filter(p -> p
			instanceof Automobil).map(sc -> (Automobil)sc).collect(Collectors.toList());
	
	@FXML
	public void initialize() {
		ObservableList<Automobil> listaAuti = FXCollections
				.observableArrayList(listItems);
		
		factories();
		
		tablicaAutomobila.setItems(listaAuti);

    }
	
	private void factories() {
		
		kolonaTabliceZaIme.setCellValueFactory(new PropertyValueFactory<Automobil, String>("naslov"));
		
		kolonaTabliceZaOpis.setCellValueFactory(new PropertyValueFactory<Automobil, String>("opis"));
		
		kolonaTabliceZaSnagu.setCellValueFactory(new PropertyValueFactory<Automobil, String>("snagaKs"));
		
		kolonaTabliceZaCijenu.setCellValueFactory(new PropertyValueFactory<Automobil, String>("cijena"));
		
		kolonaTabliceZaStanje.setCellValueFactory(new PropertyValueFactory<Automobil, String>("stanje"));
	}
	
	@FXML
	private void stisnutGumb() {
		
		List<Automobil> tempLista;
		
		String Naslov = naslovId.getText();
		
		String Opis = opisId.getText();



		tempLista = listItems.stream()
				.filter(o -> o.getNaslov().toUpperCase().contains(Naslov.toUpperCase())
				&& o.getOpis().toUpperCase().contains(Opis.toUpperCase())
				&& Main.BDcompare(o.getSnagaKs(), snagaId.getText())
				&& Main.BDcompare(o.getCijena(), cijenaId.getText()))
				.collect(Collectors.toList());
		
		ObservableList<Automobil> listaAuti = FXCollections
				.observableArrayList(tempLista);
		
		tablicaAutomobila.setItems(listaAuti);
		
	}
	
	
	@FXML
	public void clickItem()
	{
	        System.out.println(tablicaAutomobila.getSelectionModel().getSelectedItem().getNaslov());
	}
}