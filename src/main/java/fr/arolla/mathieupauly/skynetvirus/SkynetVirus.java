package fr.arolla.mathieupauly.skynetvirus;

import java.util.ArrayList;
import java.util.List;

/**
 * Program designed to attack a Skynet subnet.
 * It should prevent a Skynet agent from accessing any gateway.
 * Depending on the agent position on the subnet it decides what link to sever.
 */
class SkynetVirus {
    private final boolean[][] links;

    SkynetVirus(int nodeCount) {
        links = new boolean[nodeCount][nodeCount];
    }

    /**
     * Declares a bidirectional link between to nodes.
     *
     * @param n1 0-index of the link start
     * @param n2 0-index of the link end
     */
    void createLink(int n1, int n2) {
        links[n1][n2] = true;
        links[n2][n1] = true;
    }

    /**
     * Computes the skynet link to cut.
     *
     * @param agent position (node index) of the skynet agent
     * @param gateway position (node index) of the subnet gateway
     * @return the target node of the link to sever
     */
    int linkToSever(int agent, int gateway) {
        List<Integer> neighbourhood = neighbours(agent);

        for (Integer neighbour : neighbourhood) {
            if (gateway == neighbour) {
                return neighbour;
            }
        }

        return -1;
    }


    private List<Integer> neighbours(int node) {
        List<Integer> neighbours = new ArrayList<>();

        for (int potentialNeighbour = 0; potentialNeighbour < links.length; potentialNeighbour++) {
            if (links[node][potentialNeighbour]) {
                neighbours.add(potentialNeighbour);
            }
        }

        return neighbours;
    }

}
