package mus;

import junit.framework.TestCase;

public class MuseSpilTest extends TestCase {


    public void testGenerateNuts() {
        // TODO - Lav testen rigtig med AssertEquals og en løkke, der trækker titusinde antal gange
        // TODO - Testen vil nok påvise fejl. Ret fejlen.
        MuseSpil spil = new MuseSpil();
        spil.generateNuts();

    }

    public void testValgNut() {
        // TODO - Lav testen rigtig med AssertEquals og en løkke, der trækker titusinde antal gange
        // TODO - Testen vil nok påvise fejl. Ret fejlen.
        MuseSpil spil = new MuseSpil();
        spil.generateNuts();
        spil.chooseNut();

    }

    // TODO - Skriv tests til de resterende metoder også
}
