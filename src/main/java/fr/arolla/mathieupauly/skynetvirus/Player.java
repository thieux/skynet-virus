package fr.arolla.mathieupauly.skynetvirus;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

class Player {

    public static void main(String args[]) {
        InputStream input = System.in;
        PrintStream output = System.out;

        new Player().play(input, output);
    }

    public void play(InputStream input, PrintStream output) {
        Scanner in = new Scanner(input);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways

        SkynetSubnet subnet = new SkynetSubnet(N);

        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();

            subnet.createLink(N1, N2);
        }

        int gateway = -1;
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node

            gateway = EI;
        }

        SkynetVirus virus = new SkynetVirus(subnet);

        // game loop
        while (in.hasNext()) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn

            // Write an action using System.output.println()
            // To debug: System.err.println("Debug messages...");
            Link linkToSever = virus.linkToSever(SI, new int[]{gateway});

            subnet.severLink(linkToSever.n1, linkToSever.n2);

            // Example: 0 1 are the indices of the nodes you wish to sever the link between
            output.printf("%d %d\n", linkToSever.n1, linkToSever.n2);
            output.flush();
        }
    }
}