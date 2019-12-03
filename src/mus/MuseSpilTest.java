package mus;

import junit.framework.TestCase;

public class MuseSpilTest extends TestCase {


    public void testGenerateNuts() {

        MuseSpil spil = new MuseSpil();
        spil.generateNuts();

    }

    public void testValgNut() {

        MuseSpil spil = new MuseSpil();
        spil.generateNuts();
        spil.chooseNut();

    }
}