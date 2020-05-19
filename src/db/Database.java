package db;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Database {
    File tuinen;
    File serres;
    File velden;
    File bakken;
    File zadenbak;
    File plantenbak;

    public Database() {
        maakDirectoryAan();
    }

    public void maakDirectoryAan() {
        tuinen = new File("D:\\MoestuinData/moestuin");
        serres = new File("D:\\MoestuinData/moestuin/serres");
        velden = new File("D:\\MoestuinData/moestuin/velden");
        bakken = new File("D:\\MoestuinData/moestuin/bakken");
        zadenbak = new File("D:\\MoestuinData/moestuin/Bakken/zadenbak");
        plantenbak = new File("D:\\MoestuinData/moestuin/Bakken/plantenbak");

        tuinen.mkdir();
        serres.mkdir();
        velden.mkdir();
        bakken.mkdir();
        zadenbak.mkdir();
        plantenbak.mkdir();
    }

    public void maakTxtFileAanIn(String naam, String map) {
        if(naam==null||naam.equals("")){
            throw new IllegalArgumentException("File aanmaken mislukt, ongeldige naam");
        }
        String m = map.trim().toLowerCase();
        if(m.equals("moestuin")||m.equals("serres")||m.equals("bakken")||m.equals("zadenbak")||m.equals("plantenbak")||m.equals("velden")) {
            if(m.equals("moestuin")) {
                new File("D:\\MoestuinData/moestuin/"+naam+".txt");
            }
            if(m.equals("zadenbak")||m.equals("plantenbak")) {
                new File("D:\\MoestuinData/moestuin/bakken/"+m+"/"+naam+".txt");
            }else{
                new File("D:\\MoestuinData/moestuin/"+m+"/"+naam+".txt");
            }
        }else {
            throw new IllegalArgumentException("File aanmaken mislukt, ongeldige locatie");

        }

    }


    public void schrijfData(String naam, String map, String data) throws FileNotFoundException{
        List<String> lines = Arrays.asList(data);
        if(naam==null||naam.equals("")){
            throw new IllegalArgumentException("File aanmaken mislukt, ongeldige naam");
        }
        String m = map.trim().toLowerCase();
        if(m.contains("serre")||m.contains("veld")||m.equals("spullenbak")||
                m.equals("moestuin")||m.equals("bakken")||m.equals("zadenbak")||
                m.equals("plantenbak")||m.equals("velden")) {
            if(m.equals("zadenbak")||m.equals("plantenbak")) {
                Path file = Paths.get("D:\\MoestuinData/moestuin/bakken/"+m+"/"+naam+".txt");
                try {
                    Files.write(file, lines, Charset.forName("UTF-8"));
                } catch (IOException e) {
                    throw new DatabaseException(e.getMessage(), e);
                }
            }

            if(m.equals("moestuin")) {
                Path file = Paths.get("D:\\MoestuinData/"+m+"/"+naam+".txt");
                try {
                    Files.write(file, lines, Charset.forName("UTF-8"));
                } catch (IOException e) {
                    throw new DatabaseException(e.getMessage(), e);

                }
            }
            Path fil = Paths.get("D:\\MoestuinData/moestuin/bakken/"+m+"/"+naam+".txt");

        }else {
            throw new IllegalArgumentException("File aanmaken mislukt, ongeldige locatie");

        }}//else{
    //Path file = Paths.get("D:\\MoestuinData/moestuin/"+m+"/"+naam+".txt");
				/*try {
					Files.write(file, lines, Charset.forName("UTF-8"));
				} catch (IOException e) {
					e.printStackTrace();
				}*/

    public void maakFolderAanIn(String naam, String map) {
        if(naam==null||naam.equals("")){
            throw new IllegalArgumentException("File aanmaken mislukt, ongeldige naam");
        }
        String m = map.trim().toLowerCase();
        if(m.equals("moestuin")||m.equals("serres")||m.equals("bakken")||m.equals("zadenbak")||m.equals("plantenbak")||m.equals("velden")) {
            if(m.equals("moestuin")) {
                new File("D:\\MoestuinData/moestuin/"+naam);
            }
            if(m.equals("zadenbak")||m.equals("plantenbak")) {
                new File("D:\\MoestuinData/moestuin/bakken/"+m+"/"+naam);
            }else{
                new File("D:\\MoestuinData/moestuin/"+m+"/"+naam);
            }
        }else {
            throw new IllegalArgumentException("File aanmaken mislukt, ongeldige locatie");

        }


    }










    public String leesDataMetNaam(File bestand, String n) throws FileNotFoundException{
        Scanner scannerFile = new Scanner(bestand);
        Scanner scannerLijn = new Scanner(scannerFile.nextLine());
        String uit = "";

        if(scannerLijn.hasNext(n)) 	{
            while (scannerFile.hasNextLine()) { 							// voor elke lijn van het bestand
                // scanner voor lijn
                scannerLijn.useDelimiter(" / ");
                // scheidingstekens van verschillende delen in de huidige lijn

                scannerLijn.close();
            }

        }
        scannerLijn.close();
        scannerFile.close();
        return uit;
    }

//	public Object translateData(String data) {
//		char[] c = data.toCharArray();
//		String naam = char[0]-c.;
//		String soort = scannerLijn.next() ;
//		double tussenafstand  = Double.parseDouble(scannerLijn.next());
//		int vervaljaar  = Integer.parseInt(scannerLijn.next());
//		int aantal = Integer.parseInt(scannerLijn.next());
//		double hoogte = Double.parseDouble(scannerLijn.next());
//		boolean ziekteresistent = Boolean.parseBoolean(scannerLijn.next());
//		boolean hybride  = Boolean.parseBoolean(scannerLijn.next());
//		int opbrengst  = Integer.parseInt(scannerLijn.next());
//		String vorm = scannerLijn.next();
//		String kleur = scannerLijn.next();
//		int scoville = Integer.parseInt(scannerLijn.next());							// tweede deel huidige lijn tot aan /
//		Peper pep = new Peper(naam, soort, tussenafstand, vervaljaar, aantal, hoogte, ziekteresistent, hybride, opbrengst, vorm, kleur, scoville);
//
//		return o;
//
//	}


}
