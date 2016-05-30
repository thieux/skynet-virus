package fr.arolla.mathieupauly.skynetvirus;

import org.junit.Assert;
import org.junit.Test;

public class SkynetVirusTest {

    @Test
    public void severGatewayLinkWhenAgentConnectedToIt() {
        SkynetSubnet subnet = new SkynetSubnet(3);

        subnet.createLink(1, 2);
        subnet.createLink(0, 1);

        int target = new SkynetVirus(subnet).linkToSever(1, 2);

        Assert.assertEquals(2, target);
    }

    @Test
    public void severNeighbourWhenNoAgentIsConnectedToGateway() {
        SkynetSubnet subnet = new SkynetSubnet(3);

        subnet.createLink(1, 2);
        subnet.createLink(0, 1);

        int target = new SkynetVirus(subnet).linkToSever(0, 2);

        Assert.assertEquals(1, target);
    }

    @Test
    public void doNothingWhenAgentIsIsolated() {
        SkynetSubnet subnet = new SkynetSubnet(3);

        int target = new SkynetVirus(subnet).linkToSever(0, 2);

        Assert.assertEquals(-1, target);
    }
}
