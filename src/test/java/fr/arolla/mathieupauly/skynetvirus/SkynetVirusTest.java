package fr.arolla.mathieupauly.skynetvirus;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SkynetVirusTest {

    /**
     * Echo implementation used on CodinGame to extract the standard input
     */
    static class EchoPlayer {
        public static void main(String args[]) {
            Scanner in = new Scanner(System.in);
            while (true) {
                int N = in.nextInt();

                System.err.println(N);
            }
        }
    }

    @Test
    public void simple() {
        String input = "3\n" +
                "2\n" +
                "1\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "0\n" +
                "2\n" +
                "1";
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        new Player().play(
                new ByteArrayInputStream(input.getBytes()),
                new PrintStream(output));
        Assert.assertEquals("1 2", output.toString());
    }

}
