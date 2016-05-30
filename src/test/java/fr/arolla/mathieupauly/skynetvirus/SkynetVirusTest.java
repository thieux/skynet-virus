package fr.arolla.mathieupauly.skynetvirus;

import org.junit.Assert;
import org.junit.Test;

public class SkynetVirusTest {

    @Test
    public void severGatewayLinkWhenAgentConnectedToIt() {
        SkynetVirus skynetVirus = new SkynetVirus(3);

        skynetVirus.createLink(1, 2);
        skynetVirus.createLink(0, 1);

        int target = skynetVirus.linkToSever(1, 2);

        Assert.assertEquals(2, target);
    }

    @Test
    public void severNeighbourWhenNoAgentIsConnectedToGateway() {
        SkynetVirus skynetVirus = new SkynetVirus(3);

        skynetVirus.createLink(1, 2);
        skynetVirus.createLink(0, 1);

        int target = skynetVirus.linkToSever(0, 2);

        Assert.assertEquals(1, target);
    }

    @Test
    public void doNothingWhenAgentIsIsolated() {
        SkynetVirus skynetVirus = new SkynetVirus(3);

        int target = skynetVirus.linkToSever(0, 2);

        Assert.assertEquals(-1, target);
    }
}
