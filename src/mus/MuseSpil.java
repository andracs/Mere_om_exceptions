/**
 * Developed by András Ács (acsandras@gmail.com)
 * Zealand / www.zealand.dk
 * Licensed under the MIT License
 * 03/12/2019
 */
package mus;

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

    public void generateNuts() {
        // FORKERT antalNuts = (int) Math.random() * maxNuts - minNuts;
        // KORREKT antalNuts = ThreadLocalRandom.current().nextInt(minNuts, maxNuts + 1);
        // TAK Anders --> Den er fed til at lave tilfældige tal:
        Random random = new Random();
        antalNuts = random.nextInt(maxNuts - minNuts) + minNuts;
        System.out.println(antalNuts + " nødder er lavet.");
        nutCount = new boolean[antalNuts];
        Arrays.fill(nutCount, true); // Posen (arrayet) er fyldt med pebernødder
        System.out.println("Kurven med nødder : " + Arrays.toString(nutCount));
    }

    // Computeren vælger en pebernød
    protected int chooseNut() {
        Random random = new Random();
        valgteNut = random.nextInt(antalNuts - 1) + 1;
        System.out.println("Den valgte nød er " + valgteNut + ".");
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
                System.out.println("Muuuus!");
                System.out.println("En ny nød er valgt.");
                chooseNut();
            } else {
                System.out.println("Haps, brugeren har spist nødden.");
            }
            boolean erAltSpist = true;
            for (int i = 0; i < nutCount.length; i++) {
                if (nutCount[i] == true) {
                    erAltSpist = false;
                }
            }
            if (erAltSpist) {
                System.out.println("I har spist alt");
                System.exit(1);
            }
        }
    }


}
