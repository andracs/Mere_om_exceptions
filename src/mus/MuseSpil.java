/**
 * Developed by András Ács (acsandras@gmail.com)
 * Zealand / www.zealand.dk
 * Licensed under the MIT License
 * 03/12/2019
 */
package mus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MuseSpil {

    // Mus begynder med at der genereres et antal pebernødder (ca. 60-120)
    public int minNuts = 5;
    public int maxNuts = 10;
    public int antalNuts;
    private int valgteNut;
    public int brugerensGaet;
    public boolean nutCount[];
    private String log;

    public void generateNuts() {
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
        log = log + "\n" + logbesked;

        return valgteNut;
    }

    // Nu skal brugeren gætte, hvilken pebernød computeren har valgt.
    public void brugerenGaetter() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            brugerensGaet = scanner.nextInt();
            nutCount[brugerensGaet-1] = false;
            System.out.println("Kurven med nødder : " + Arrays.toString(nutCount));
            if (brugerensGaet == valgteNut) {
                String logbesked = "Muuuus! En ny nød er valgt.";
                System.out.println(logbesked);
                log = log + "\n" + logbesked;
                chooseNut();
            } else {
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
                String logbesked = "I har spist alt";
                System.out.println(logbesked);
                log = log + "\n" + logbesked;
                saveToFile();
                System.exit(1);
            }
        }
    }

    public void saveToFile() {
        try {
            File file = new File("src/mus/log.txt");
            PrintWriter output = new PrintWriter(file);
            output.print(log);
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
