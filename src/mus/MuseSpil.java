/**
 * Developed by András Ács (acsandras@gmail.com)
 * Zealand / www.zealand.dk
 * Licensed under the MIT License
 * 03/12/2019
 */
package mus;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MuseSpil {

    // Mus begynder med at der genereres et antal pebernødder (ca. 60-120)
    public int minNuts = 60;
    public int maxNuts = 120;
    public int antalNuts;
    private int valgteNut;
    public int brugerensGaet;

    public void generateNuts() {
        // FORKERT antalNuts = (int) Math.random() * maxNuts - minNuts;
        // KORREKT antalNuts = ThreadLocalRandom.current().nextInt(minNuts, maxNuts + 1);
        // TAK Anders --> Den er fed til at lave tilfældige tal:
        Random random = new Random();
        antalNuts = random.nextInt(maxNuts - minNuts) + minNuts;
        System.out.println(antalNuts + " nødder er lavet.");
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
            if (brugerensGaet == valgteNut) {
                System.out.println("Muuusss!");
                break;
            } else {
                System.out.println("Haps, brugeren har spist nødden.");
            }
        }
    }


}
