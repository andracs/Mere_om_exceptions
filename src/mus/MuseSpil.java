/**
 * Developed by András Ács (acsandras@gmail.com)
 * Zealand / www.zealand.dk
 * Licensed under the MIT License
 * 03/12/2019
 */
package mus;
// TODO lav en flot readme.md
// TODO ryd op i imports
// TODO træk ASCII-juletræet ind som en juletrae() metode

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MuseSpil {

    // TODO ret de nuværende kommentarer og skriv bedre kommentarer
    // Mus begynder med at der genereres et antal pebernødder (ca. 60-120)
    public int minNuts = 5;
    public int maxNuts = 10;
    public int antalNuts;
    private int valgteNut;
    public int brugerensGaet;
    // TODO refaktorer således, så arrayet hedder kurven og ikke nutCount
    public boolean nutCount[];
    private String log = "Musespillets log \n ***************";

    public void generateNuts() {
        // TODO Ryd op i kommentarer herunder
        // FORKERT antalNuts = (int) Math.random() * maxNuts - minNuts;
        // KORREKT antalNuts = ThreadLocalRandom.current().nextInt(minNuts, maxNuts + 1);
        // TAK Anders --> Den er fed til at lave tilfældige tal:
        Random random = new Random();
        antalNuts = random.nextInt(maxNuts - minNuts) + minNuts;
        String logbesked =  antalNuts + " nødder er lavet.";
        System.out.println(logbesked);
        log = log + "\n" + logbesked;
        nutCount = new boolean[antalNuts];
        Arrays.fill(nutCount, true); // Posen (arrayet) er fyldt med pebernødder
        System.out.println("Kurven med nødder : " + Arrays.toString(nutCount));
    }

    // Computeren vælger en pebernød
    protected int chooseNut() {
        Random random = new Random();
        valgteNut = random.nextInt(antalNuts - 1) + 1;
        String logbesked = "Den valgte nød er " + valgteNut + ".";
        System.out.println(logbesked);
        // TODO - skal loggen ikke ud i sin egen log() metode?
        log = log + "\n" + logbesked;
        return valgteNut;
    }

    // Nu skal brugeren gætte, hvilken pebernød computeren har valgt.
    public void brugerenGaetter() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // TODO gør input mere brugervenlig tved at skrive "Hvilken nød vil du spise?"
            // TODO håndter forkert indtastning med InvalidParameterException eller din egen PeppernutExceprion som extender InvalidParameterException
            brugerensGaet = scanner.nextInt();
            // TODO Hvilken nød har brugeren spist? Skriv "Brugeren spiser nød x." i loggen og på skærmen.
            nutCount[brugerensGaet-1] = false;
            // TODO fjern visning af array
            System.out.println("Kurven med nødder : " + Arrays.toString(nutCount));
            if (brugerensGaet == valgteNut) {
                String logbesked = "Muuuus! En ny nød er valgt.";
                System.out.println(logbesked);
                log = log + "\n" + logbesked;
                chooseNut();
            } else {
                // TODO Hvilken nød har brugeren spist? Skriv tallet...
                String logbesked = "Haps, brugeren har spist nødden.";
                System.out.println(logbesked);
                log = log+ "\n"  + logbesked;
            }
            boolean erAltSpist = true;
            for (int i = 0; i < nutCount.length; i++) {
                if (nutCount[i] == true) {
                    erAltSpist = false;
                }
            }
            if (erAltSpist) {
                String logbesked = "I har spist alle pebernødder!";
                System.out.println(logbesked);
                log = log + "\n" + logbesked;
                saveToFile();
                System.exit(1);
            }
        }
    }

    public void saveToFile() {
        try {
            // TODO Træk filnavnet ud en variable (konstant)
            File file = new File("src/mus/nutlog.txt");
            PrintWriter output = new PrintWriter(file);
            output.print(log);
            output.close();
        } catch (FileNotFoundException e) {
            // TODO håndter fejeln bedre
            e.printStackTrace();
        }

    }

}

// TODO  For viderekomne: Man skulle kunne gemme spillet undervejs i filen nut.save og indlæse det igen når programmet starter!
// TODO Allersidst - lav en klassediagram som dokumentation
// TODO Allersidst - javadoc