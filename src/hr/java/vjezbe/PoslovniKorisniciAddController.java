package hr.java.vjezbe;

import java.io.IOException;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;

import hr.java.vjezbe.util.Datoteke;
import hr.java.vjezbe.enitet.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

public class PoslovniKorisniciAddController {
	
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
	
	public void prikaziPrivatniKorisniciAdd() {
		try {
			BorderPane center = FXMLLoader.load(Main.class.getResource("PrivatniKorisnikAdd.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	@FXML
	private TextField unosNazivId;

	@FXML
	private TextField unosWebId;

	@FXML
	private TextField unosMailId;
	
	@FXML
	private TextField unosTelefonId;
	
	@FXML
	private Button okButton;
	
	List<Korisnik> allItems = Datoteke.dohvatiKorisnike();
	
	List<PoslovniKorisnik> listItems = allItems.stream().filter(p -> p
			instanceof PoslovniKorisnik).map(sc -> (PoslovniKorisnik)sc).collect(Collectors.toList());
	
	
	@FXML
	public void initialize() {
		
    }
	
	@FXML
	public void stisnutGumb() throws IOException {
		OptionalLong maxId = allItems.stream()
				 .mapToLong(Entitet::getId).max();
		String tempNaziv, tempWeb, tempTelefon, tempMail;
		tempNaziv = unosNazivId.getText();
		tempWeb = unosWebId.getText();
		tempTelefon = unosTelefonId.getText();
		tempMail = unosMailId.getText();
		
		if(validate()) {
			allItems.add(new PoslovniKorisnik(tempMail, tempTelefon, tempNaziv, tempWeb , maxId.getAsLong() + 1 ));
			Datoteke.zapisivanjeKorisnika(allItems);
			Alert alert = new Alert(AlertType.CONFIRMATION, "Uspjesno ste unijeli podatke", ButtonType.OK);
			alert.showAndWait();
		}
		
				
	}
	
	public boolean validate() {

        StringBuilder errors = new StringBuilder();

        // Confirm mandatory fields are filled out
        if (unosNazivId.getText().trim().isEmpty()) {
            errors.append("Niste unjeli naziv.\n");
        }
        if (unosWebId.getText().trim().isEmpty()) {
            errors.append("Niste unjeli opis.\n");
        }
        if (unosTelefonId.getText().trim().isEmpty()) {
            errors.append("Niste unjeli cijenu.\n");
        }
        if (unosMailId.getText().trim().isEmpty()) {
            errors.append("Niste unjeli kvadraturu.\n");
        }

        // If any missing information is found, show the error messages and return false
        if (errors.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Niste unjeli sve podatke.");
            alert.setContentText(errors.toString());

            alert.showAndWait();
            return false;
        }

        // No errors
        return true;
    }
}