package fr.arolla.mathieupauly.skynetvirus;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class SkynetVirusTest {

    @Test
    public void severGatewayLinkWhenAgentConnectedToIt() {
        SkynetSubnet subnet = new SkynetSubnet(3);

        subnet.createLink(1, 2);
        subnet.createLink(0, 1);

        Link linkToSever = new SkynetVirus(subnet).linkToSever(1, new int[]{2});

        Assert.assertEquals(1, linkToSever.n1);
        Assert.assertEquals(2, linkToSever.n2);
    }

    @Test
    public void severNeighbourWhenNoAgentIsConnectedToGateway() {
        SkynetSubnet subnet = new SkynetSubnet(3);

        subnet.createLink(1, 2);
        subnet.createLink(0, 1);

        Link linkToSever = new SkynetVirus(subnet).linkToSever(0, new int[]{2});

        Assert.assertEquals(0, linkToSever.n1);
        Assert.assertEquals(1, linkToSever.n2);
    }

    @Test
    public void doNothingWhenAgentIsIsolated() {
        SkynetSubnet subnet = new SkynetSubnet(3);

        Link linkToSever = new SkynetVirus(subnet).linkToSever(0, new int[]{2});

        Assert.assertEquals(-1, linkToSever.n1);
        Assert.assertEquals(-1, linkToSever.n2);
    }

    @Test
    public void severLinkRemoveNeighbours() {
        SkynetSubnet subnet = new SkynetSubnet(2);

        subnet.createLink(0, 1);
        subnet.severLink(0, 1);

        Assert.assertArrayEquals(
                Collections.<Integer>emptyList().toArray(),
                subnet.neighbours(0).toArray());

        Assert.assertArrayEquals(
                Collections.<Integer>emptyList().toArray(),
                subnet.neighbours(1).toArray());

    }

    @Test
    public void multipleGateways() {
        SkynetSubnet subnet = new SkynetSubnet(4);

        subnet.createLink(0, 1);
        subnet.createLink(0, 2);
        subnet.createLink(2, 3);

        subnet.severLink(0, 1);

        Link linkToSever = new SkynetVirus(subnet).linkToSever(2, new int[]{1, 3});

        Assert.assertEquals(2, linkToSever.n1);
        Assert.assertEquals(3, linkToSever.n2);
    }
}
