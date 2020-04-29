package hr.java.vjezbe;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class OglasnikController {
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
}
