package mus;

import junit.framework.TestCase;

public class MuseSpilTest extends TestCase {


    public void testGenerateNuts() {
        // TODO - Lav testen rigtig med AssertEquals og en løkke, der trækker titusinde antal gange
        MuseSpil spil = new MuseSpil();
        spil.generateNuts();

    }

    public void testValgNut() {
        // TODO - Lav testen rigtig med AssertEquals og en løkke, der trækker titusinde antal gange
        MuseSpil spil = new MuseSpil();
        spil.generateNuts();
        spil.chooseNut();

    }
}