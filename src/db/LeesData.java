package db;

import domain.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class LeesData {

    ArrayList<Tuinobject> objecten = new ArrayList<>();


    public LeesData(String bestand) {
    }

	try {
        // scanner voor File

        objecten.add(p);
    }
} catch(FileNotFoundException e) {
        throw new DatabaseException(e.getMessage(), e);
        }
        }}

