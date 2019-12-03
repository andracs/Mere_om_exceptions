/**
 * Developed by András Ács (acsandras@gmail.com)
 * Zealand / www.zealand.dk
 * Licensed under the MIT License
 * 03/12/2019
 */
package mus;

public class MuseSpil {

    // Mus begynder med at der genereres et antal pebernødder (ca. 60-120)
    public int minNuts = 60;
    public int maxNuts = 120;
    public int antalNuts;

    public void generateNuts() {
        antalNuts = (int) Math.random() * maxNuts - minNuts;
        System.out.println(antalNuts + " nødder er lavet.");
    }

}
