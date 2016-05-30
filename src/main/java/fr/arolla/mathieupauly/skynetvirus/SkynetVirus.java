package fr.arolla.mathieupauly.skynetvirus;

import java.util.List;

/**
 * Program designed to attack a Skynet subnet.
 * It should prevent a Skynet agent from accessing any gateway.
 * Depending on the agent position on the subnet it decides what link to sever.
 */
class SkynetVirus {
    private final SkynetSubnet subnet;

    SkynetVirus(SkynetSubnet subnet) {
        this.subnet = subnet;
    }

    /**
     * Computes the skynet link to cut.
     *
     * @param agent   position (node index) of the skynet agent
     * @param gateway position (node index) of the subnet gateway
     * @return the target node of the link to sever
     */
    Link linkToSever(int agent, int gateway) {
        List<Integer> neighbourhood = subnet.neighbours(agent);

        for (Integer neighbour : neighbourhood) {
            if (gateway == neighbour) {
                return new Link(agent, gateway);
            }
        }

        if (!neighbourhood.isEmpty()) {
            Integer neighbour = neighbourhood.get(0);

            return new Link(agent, neighbour);
        }

        return Link.NONE;
    }


}
