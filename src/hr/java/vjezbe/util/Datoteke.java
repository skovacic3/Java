package hr.java.vjezbe.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hr.java.vjezbe.enitet.Artikl;
import hr.java.vjezbe.enitet.Automobil;
import hr.java.vjezbe.enitet.Kategorija;
import hr.java.vjezbe.enitet.Korisnik;
import hr.java.vjezbe.enitet.PoslovniKorisnik;
import hr.java.vjezbe.enitet.PrivatniKorisnik;
import hr.java.vjezbe.enitet.Prodaja;
import hr.java.vjezbe.enitet.Stan;
import hr.java.vjezbe.enitet.Stanje;
import hr.java.vjezbe.enitet.Usluga;

public class Datoteke {

	public static List<Korisnik> dohvatiKorisnike() {
		int brojac = 0;
		String tempIme = null, tempPrezime = null, tempMail = null, tempTelefon = null;
		int vrstaKorisnika = 0;
		long tempId = 0;
		String line;
		List<Korisnik> tempKorisnici = new ArrayList<>();
		try (BufferedReader in = new BufferedReader(new FileReader("dat/korisnici.txt"))) {
			while ((line = in.readLine()) != null) {
				if (brojac == 0) {
					vrstaKorisnika = Integer.parseInt(line);
					brojac++;
					continue;
				}
				if (vrstaKorisnika == 1) {
					if (brojac == 1) {
						tempIme = line;
						brojac++;
					} else if (brojac == 2) {
						tempPrezime = line;
						brojac++;
					} else if (brojac == 3) {
						tempMail = line;
						brojac++;
					} else if (brojac == 4) {
						tempTelefon = line;
						brojac++;
					} else if (brojac == 5) {
						tempId = Long.parseLong(line);
						tempKorisnici.add(new PrivatniKorisnik(tempMail, tempTelefon, tempIme, tempPrezime, tempId));
						brojac = 0;
					}
				} else if (vrstaKorisnika == 2) {
					if (brojac == 1) {
						tempIme = line;
						brojac++;
					} else if (brojac == 2) {
						tempPrezime = line;
						brojac++;
					} else if (brojac == 3) {
						tempMail = line;
						brojac++;
					} else if (brojac == 4) {
						tempTelefon = line;
						brojac++;
					} else if (brojac == 5) {
						tempId = Long.parseLong(line);
						tempKorisnici.add(new PoslovniKorisnik(tempMail, tempTelefon, tempPrezime, tempIme, tempId));
						brojac = 0;
					}

				}
			}
			return tempKorisnici;
		} catch (IOException e) {
			System.err.println(e);
		}
		return null;
	}

	public static List<Kategorija<Artikl>> dohvatiKategorije() {
		int brojac = 0, brojacKategorija = 0;
		long tempId = 0;
		String tempNaziv = null;
		List<String> artikli = new ArrayList<>();
		List<Kategorija<Artikl>> kategorije = new ArrayList<>();
		try (BufferedReader in = new BufferedReader(new FileReader("dat/kategorije.txt"))) {
			String line;
			while ((line = in.readLine()) != null) {
				if (brojac == 0) {
					tempId = Integer.parseInt(line);
					brojac++;
				} else if (brojac == 1) {
					tempNaziv = line;
					brojac++;
				} else if (brojac == 2) {
					artikli = Arrays.asList(line.split(" "));
					kategorije.add(new Kategorija<Artikl>(tempNaziv, tempId));
					punjenjeKategorije(kategorije.get(brojacKategorija), artikli);
					brojacKategorija++;
					brojac = 0;
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}

		return kategorije;
	}

	public static void punjenjeKategorije(Kategorija<Artikl> kategorija, List<String> artikliId) {
		List<Artikl> tempArtikli = new ArrayList<>();
		tempArtikli = dohvatiArtikle();

		for (String i : artikliId) {
			for (Artikl j : tempArtikli) {
				if (j.getId() == Long.parseLong(i)) {
					kategorija.dodajArtikl(j);
				}
			}
		}
	}

	public static List<Artikl> dohvatiArtikle() {
		int brojac = 0;
		int vrstaArtikla = 0;
		int tempKvadratura = 0;
		String tempArtikl = null, tempOpis = null;
		BigDecimal tempCijena = null, tempSnaga = null;
		Stanje tempStanje;
		long tempId = 0;
		List<Artikl> tempArtikli = new ArrayList<>();
		try (BufferedReader in = new BufferedReader(new FileReader("dat/artikli.txt"))) {
			String line;
			while ((line = in.readLine()) != null) {
				if (brojac == 0) {
					vrstaArtikla = Integer.parseInt(line);
					brojac++;
					continue;
				}
				if (vrstaArtikla == 1) {
					if (brojac == 1) {
						tempId = Long.parseLong(line);
						brojac++;
					} else if (brojac == 2) {
						tempArtikl = line;
						brojac++;
					} else if (brojac == 3) {
						tempOpis = line;
						brojac++;
					} else if (brojac == 4) {
						tempCijena = new BigDecimal(Integer.parseInt(line));
						brojac++;
					} else if (brojac == 5) {
						tempStanje = Stanje.values()[Integer.parseInt(line) - 1];
						brojac = 0;
						tempArtikli.add(new Usluga(tempArtikl, tempOpis, tempCijena, tempStanje, tempId));
					}
				}
				if (vrstaArtikla == 2) {
					if (brojac == 1) {
						tempId = Long.parseLong(line);
						brojac++;
					} else if (brojac == 2) {
						tempArtikl = line;
						brojac++;
					} else if (brojac == 3) {
						tempOpis = line;
						brojac++;
					} else if (brojac == 4) {
						tempSnaga = new BigDecimal(Long.parseLong(line));
						brojac++;
					} else if (brojac == 5) {
						tempCijena = new BigDecimal(Long.parseLong(line));
						brojac++;
					} else if (brojac == 6) {
						tempStanje = Stanje.values()[Integer.parseInt(line) - 1];
						brojac = 0;
						tempArtikli.add(new Automobil(tempArtikl, tempOpis, tempCijena, tempStanje, tempSnaga, tempId));
					}
				}
				if (vrstaArtikla == 3) {
					if (brojac == 1) {
						tempId = Long.parseLong(line);
						brojac++;
					} else if (brojac == 2) {
						tempArtikl = line;
						brojac++;
					} else if (brojac == 3) {
						tempOpis = line;
						brojac++;
					} else if (brojac == 4) {
						tempKvadratura = Integer.parseInt(line);
						brojac++;
					} else if (brojac == 5) {
						tempCijena = new BigDecimal(Long.parseLong(line));
						brojac++;
					} else if (brojac == 6) {
						tempStanje = Stanje.values()[Integer.parseInt(line) - 1];
						brojac = 0;
						tempArtikli.add(new Stan(tempArtikl, tempOpis, tempCijena, tempStanje, tempKvadratura, tempId));
					}
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return tempArtikli;
	}

	public static List<Prodaja> dohvatiProdaje(List<Korisnik> korisnici, List<Kategorija<Artikl>> kategorije) {
		Artikl tempArtikl = null;
		Korisnik tempKorisnik = null;
		LocalDate tempDatum = null;
		Kategorija<Artikl> tempKategorija = null;
		int brojac = 0;
		List<Prodaja> prodaje = new ArrayList<>();
		try (BufferedReader in = new BufferedReader(new FileReader("dat/prodaje.txt"))) {
			String line;
			while ((line = in.readLine()) != null) {
				if (brojac == 0) {
					tempKorisnik = korisnici.get(Integer.parseInt(line) - 1);
					brojac++;
				} else if (brojac == 1) {
					tempKategorija = kategorije.get(Integer.parseInt(line) - 1);
					brojac++;
				} else if (brojac == 2) {
					tempArtikl = tempKategorija.dohvatiListuArtikala().get(Integer.parseInt(line) - 1);
					brojac++;
				} else if (brojac == 3) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
					String datumic = line;
					tempDatum = LocalDate.parse(datumic, formatter);
					prodaje.add(new Prodaja(tempArtikl, tempKorisnik, tempDatum, 0));
					brojac = 0;
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return prodaje;

	}
	
	public static void zapisivanjeArtikala(List<Artikl> artikli) throws IOException {
		FileWriter fileWriter = new FileWriter("dat/artikli.txt");
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.print("");
		for(Artikl i : artikli) {
			if(i instanceof Automobil) {
				printWriter.println("2");
				printWriter.println(i.getId());
				printWriter.println(i.getNaslov());
				printWriter.println(i.getOpis());
				printWriter.println(((Automobil) i).getSnagaKs().toString());
				printWriter.println(i.getCijena().toString());
				if(i.getStanje().toString().equals("novo")) {
					printWriter.println("1");
				}
				else if(i.getStanje().toString().equals("izvrsno")) {
					printWriter.println("2");
				}
				else if(i.getStanje().toString().equals("rabljeno")) {
					printWriter.println("3");
				}
				else if(i.getStanje().toString().equals("neispravno")) {
					printWriter.println("4");
				}
			}
			
			else if(i instanceof Stan) {
				printWriter.println("3");
				printWriter.println(i.getId());
				printWriter.println(i.getNaslov());
				printWriter.println(i.getOpis());
				printWriter.println(((Stan) i).getKvadratura());
				printWriter.println(i.getCijena().toString());
				if(i.getStanje().toString().equals("novo")) {
					printWriter.println("1");
				}
				else if(i.getStanje().toString().equals("izvrsno")) {
					printWriter.println("2");
				}
				else if(i.getStanje().toString().equals("rabljeno")) {
					printWriter.println("3");
				}
				else if(i.getStanje().toString().equals("neispravno")) {
					printWriter.println("4");
				}
			}
			
			else if(i instanceof Usluga) {
				printWriter.println("1");
				printWriter.println(i.getId());
				printWriter.println(i.getNaslov());
				printWriter.println(i.getOpis());
				printWriter.println(i.getCijena().toString());
				if(i.getStanje().toString().equals("novo")) {
					printWriter.println("1");
				}
				else if(i.getStanje().toString().equals("izvrsno")) {
					printWriter.println("2");
				}
				else if(i.getStanje().toString().equals("rabljeno")) {
					printWriter.println("3");
				}
				else if(i.getStanje().toString().equals("neispravno")) {
					printWriter.println("4");
				}
			}	
		}
		printWriter.close();
	}
	
	public static void zapisivanjeKorisnika(List<Korisnik> korisnici) throws IOException {
		FileWriter fileWriter = new FileWriter("dat/korisnici.txt");
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.print("");
		for(Korisnik i : korisnici) {
			if(i instanceof PrivatniKorisnik) {
				printWriter.println("1");
				printWriter.println(((PrivatniKorisnik) i).getIme());
				printWriter.println(((PrivatniKorisnik) i).getPrezime());
				printWriter.println(i.getEmail());
				printWriter.println(i.getTelefon());
				printWriter.println(i.getId());
			}
			
			else if(i instanceof PoslovniKorisnik) {
				printWriter.println("2");
				printWriter.println(((PoslovniKorisnik) i).getNaziv());
				printWriter.println(((PoslovniKorisnik) i).getWeb());
				printWriter.println(i.getEmail());
				printWriter.println(i.getTelefon());
				printWriter.println(i.getId());
			}
				
		}
		printWriter.close();
	}
}
