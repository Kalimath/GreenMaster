package ui;




import domain.Domein;
import domain.zaaibaar.*;


public class Controller {
    public static void main(String[] args) {
        Domein d = new Domein();
        Zaaibaar z = new Tomaat("Borghese", "kerstomaat", 2018, 200, 0.5, false,
                false, 4, "rood", "rood", "rond", false);
        d.zadenbak.voegZaadToe(z);
        d.getZadenbak().printZaden();

        /*try {

            Domein d = new Domein();

            Looppad pad = new Looppad("grond");
            Moestuin kserre = new Serre("Kleine serre", 4, 6);
            Moestuin gserre = new Serre("Grote serre", 6, 6);

            Zaaibaar z = new Tomaat("Borghese", "kerstomaat", 2018, 200, 0.5, false,
                    false, 4, "rood", "rood", "rond", false);
            Zaaibaar b = new Boon("Crusader", "pronkboon", false, 2019,
                    75, 4, false, true, 7, "groen", "langwerpig", true);
            Zaaibaar toga = new Aubergine("Striped Toga", "speciaal", 2020,
                    80, 26, false, false, 5, "oranje", "ovaal");
            Zaaibaar rain = new StandaardPeper("Rain Forest", "besachtig", 2022,
                    13, 10, false, false, 6, "bel", "rood", 40000);
            Zaaibaar ghost = new StandaardPeper("Ghost peper", 0.25, 0.5, 0, false,
                    true, 5, "rood", "langwerpig", 1042437).isPlant();
            Zaaibaar ananas = new Tomaat("Ananas Noir", "vleestomaat", 0.25, 3.0, 2.5,  false,
                    false, 5, "oranje", "rond", true, "oranje").isPlant();


            //String naam, String soort, double tussenafstand, int vervaljaar, int aantal, double hoogte,
            //boolean ziekteresistent, boolean hybride, int opbrengst, String kleur, String vorm
            // Writer writer = null;

            // try {
            //    writer = new BufferedWriter(new OutputStreamWriter(
            //            new FileOutputStream("filename.txt"), "utf-8"));
            //     writer.write("Something");
            //} catch (IOException ex) {

            //} finally {
            //    try {writer.close();} catch (Exception ex) {
            // }
            //}

            d.zadenbak.voegZaadToe(z);
            d.zadenbak.voegZaadToe(b);
            d.zadenbak.voegZaadToe(toga);
            d.zadenbak.voegZaadToe(rain);

            try {
                d.plantenbak.zaai(z,1);
                d.plantenbak.zaai(b,1);
            } catch (Exception e1) {
                e1.printStackTrace();
            }


            d.plantenbak.voegPlantToe(ghost);
            d.plantenbak.voegPlantToe(ananas);
            kserre.voegTuinObjectToe(ghost, 2, 2);
            kserre.voegTuinObjectToe(ananas, 3, 2);
            kserre.voegTuinObjectToe(pad, 1, 1);
            kserre.voegTuinObjectToe(pad, 1, 2);
            kserre.voegTuinObjectToe(pad, 1, 3);
            kserre.voegTuinObjectToe(pad, 1, 4);
            kserre.geefInfo();



            gserre.voegTuinObjectToe(ghost, 1, 5);
            gserre.voegTuinObjectToe(ananas, 4, 2);
            gserre.voegTuinObjectToe(d.plantenbak.get("Borghese"), 6, 5);
            gserre.voegTuinObjectToe(d.plantenbak.get("Crusader"), 6, 4);
            gserre.voegTuinObjectToe(pad, 1, 4);
            gserre.voegTuinObjectToe(pad, 3, 4);
            gserre.geefInfo();

            d.voegAanTuinenToe(gserre);
            d.voegAanTuinenToe(kserre);

            d.db.maakTxtFileAanIn(z.getNaam(), "zadenbak");
            d.db.schrijfData(z.getNaam(), "zadenbak",z.allDataInString());
            d.db.schrijfData(b.getNaam(), "zadenbak",b.allDataInString());
            d.db.schrijfData(toga.getNaam(), "zadenbak",toga.allDataInString());
            d.db.schrijfData(rain.getNaam(), "zadenbak",rain.allDataInString());
            d.db.schrijfData(ghost.getNaam(), "plantenbak",ghost.allDataInString());
            d.db.schrijfData(b.getNaam(), "plantenbak", b.allDataInString());
            d.db.schrijfData(ananas.getNaam(), "plantenbak",ananas.allDataInString());

            d.db.maakTxtFileAanIn(kserre.getNaam(), "serres");
            d.db.schrijfData(ananas.getNaam(), kserre.getNaam(),ananas.allDataInString());
            d.db.maakTxtFileAanIn(gserre.getNaam(), "moestuin");

            //System.out.println(d.zoekTuinobject("Ananas Noir", "zaad").toString());
            d.voegTuinObjectToeAanMoestuin("Grote serre", "Crusader", 6, 3);

            //menu
            boolean menuactief = true;
            while (menuactief) {
                int keuze=0;
                String k=(JOptionPane.showInputDialog(null,
                        "---TUINBEHEERSYSTEEM---" +
                                "\n\nMaak uw keuze: " +
                                "\n1 Zaden in zadenbak zonder info" +
                                "\n2 Zaden in zadenbak met info" +
                                "\n3 Planten in plantenbak opvragen" +
                                "\n4 Check de aanwezigheid van een soort in plantenbak" +
                                "\n5 Duid een enkel wandelpad aan" +
                                "\n6 Voeg zaad toe" +
                                "\n7 Vraag plan op" +
                                "\n8 Sluit af" +
                                "\n\n(Druk ok en laat leeg om af te sluiten)"
                ));
                try {
                    if(k.isEmpty()) throw new IllegalArgumentException();
                    keuze = Integer.parseInt(k);

                }catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Systeem wordt afgesloten.", "Waarschuwing", 0);
                    keuze = 8;
                }
                switch (keuze) {
                    case 1:
                        System.out.println(d.zadenbak.printZaden());
                        break;
                    case 2:
                        System.out.println(d.zadenbak.printZadenMetInfo());
                        break;
                    case 3:
                        System.out.println(d.plantenbak.printPlantenbak());
                        break;
                    case 4:
                        String naam = JOptionPane.showInputDialog(null, "Voer soort in");
                        try {
                            System.out.println(d.plantenbak.aantalPlantenVanSoort(naam));
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, null, e.getMessage(), JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 5:
                        int x = Integer.parseInt(JOptionPane.showInputDialog(null, "geef hoogte in"));
                        int y = Integer.parseInt(JOptionPane.showInputDialog(null, "geef breedte in"));
                        gserre.voegTuinObjectToe(pad, x, y);
                        gserre.geefInfo();
                        System.out.println("Pad succesvol toegevoegd");
                        break;
                    case 6:
                        d.voegZaadToe();
                        break;
                    case 7: d.geefDomeinPlan();
                        break;
                    case 8:
                        menuactief = false;
                        System.out.println("Tuinbeheersysteem succesvol afgesloten");
                        break;
                    case 8685:
                        boolean menuactief2 = true;
                        while (menuactief2) {
                            int keuze2;
                            String k2=(JOptionPane.showInputDialog(null,
                                    "---TUINBEHEERSYSTEEM---" +
                                            "\n\nMaak uw keuze: " +
                                            "\n1 Alle zaden opvragen in lijst" +
                                            "\n6 Sluit af" +
                                            "\n8685 Alle zaden opvragen in lijst"
                            ));
                            /*if(!k.isEmpty()) keuze2 = Integer.parseInt(k2);*/
                            /*keuze = 6;
                            //output keuze
                            switch (keuze2) {
                                case 1:
                                case 6:
                                    menuactief = false;
                                    System.out.println("Tuinbeheersysteem succesvol afgesloten");
                                    break;
                                case 8685:
                                    System.out.println("Administrator beheer succesvol afgesloten");
                                    menuactief2=false;
                                default: System.out.println("Keuze ongeldig");
                                    break;
                            }
                        }
                    default: System.out.println("Keuze ongeldig");
                        break;


                }
            }

        }catch(DomainException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(DatabaseException e) {

        }*/

    }
//} catch(FileNotFoundException ex) {
//	throw new DomainException("Fout bij het inlezen"+ ex);
}


