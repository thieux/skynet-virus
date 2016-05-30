package fr.arolla.mathieupauly.skynetvirus;

import org.junit.Assert;
import org.junit.Test;

public class SkynetVirusTest {

    @Test
    public void simple() {
        SkynetVirus skynetVirus = new SkynetVirus(3);

        skynetVirus.createLink(1, 2);
        skynetVirus.createLink(0, 1);

        int target = skynetVirus.linkToSever(1, 2);

        Assert.assertEquals(2, target);
    }
}
