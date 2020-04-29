package hr.java.vjezbe;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;

import hr.java.vjezbe.util.Datoteke;
import hr.java.vjezbe.enitet.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class UslugeAddContoller {
	
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
	private TextField unosNazivId;

	@FXML
	private TextField unosOpisId;
	

	@FXML
	private TextField unosCijenaId;
	
	@FXML
	private ComboBox<String> unosStanjeId;
	
	@FXML
	private Button okButton;
	
	List<Artikl> allItems = Datoteke.dohvatiArtikle();
	
	List<Usluga> listItems = allItems.stream().filter(p -> p
			instanceof Usluga).map(sc -> (Usluga)sc).collect(Collectors.toList());
	
	
	@FXML
	public void initialize() {
		
		unosStanjeId.getItems().clear();
		
		unosStanjeId.getItems().addAll("novo", "izvrsno", "rabljeno", "neispravno");
		
    }
	
	@FXML
	public void stisnutGumb() throws IOException {
		OptionalLong maxId = allItems.stream()
				 .mapToLong(Entitet::getId).max();
		String tempNaziv, tempOpis;
		BigDecimal tempCijena = null;
		Stanje tempStanje = null;
		tempNaziv = unosNazivId.getText();
		tempOpis = unosOpisId.getText();
		try {
			tempCijena = new BigDecimal(Integer.parseInt(unosCijenaId.getText()));
		}
		catch(Exception e) {
			System.out.println("");
		}
		
		if(unosStanjeId.getValue() == "novo") {
			tempStanje = Stanje.values()[0];
		}
		else if(unosStanjeId.getValue() == "izvrsno") {
			tempStanje = Stanje.values()[1];
		}
		else if(unosStanjeId.getValue() == "rabljeno") {
			tempStanje = Stanje.values()[2];
		}
		else if(unosStanjeId.getValue() == "neispravno") {
			tempStanje = Stanje.values()[3];
		};
		
		if(validate()) {
			allItems.add(new Usluga(tempNaziv, tempOpis, tempCijena, tempStanje, maxId.getAsLong() + 1 ));
			Datoteke.zapisivanjeArtikala(allItems);
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
        if (unosOpisId.getText().trim().isEmpty()) {
            errors.append("Niste unjeli opis.\n");
        }
        if (unosCijenaId.getText().trim().isEmpty()) {
            errors.append("Niste unjeli cijenu.\n");
        }
        if (unosStanjeId.getValue() == null) {
            errors.append("Niste unjeli stanje.\n");
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