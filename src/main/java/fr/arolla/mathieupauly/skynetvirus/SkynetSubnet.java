package fr.arolla.mathieupauly.skynetvirus;

import java.util.ArrayList;
import java.util.List;

class SkynetSubnet {

    private final boolean[][] links;

    SkynetSubnet(int nodeCount) {
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

    List<Integer> neighbours(int node) {
        List<Integer> neighbours = new ArrayList<>();

        for (int potentialNeighbour = 0; potentialNeighbour < links.length; potentialNeighbour++) {
            if (links[node][potentialNeighbour]) {
                neighbours.add(potentialNeighbour);
            }
        }

        return neighbours;
    }
}
