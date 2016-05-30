package fr.arolla.mathieupauly.skynetvirus;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class PlayerTest {

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
        Assert.assertEquals("1 2\n", output.toString());
    }

    @Test
    public void manyPaths() {
        String input = "4\n" +
                "4\n" +
                "1\n" +
                "1\n" +
                "3\n" +
                "2\n" +
                "3\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "2\n" +
                "3\n" +
                "0\n" +
                "2\n";
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        new Player().play(
                new ByteArrayInputStream(input.getBytes()),
                new PrintStream(output));
        Assert.assertEquals("0 1\n2 3\n", output.toString());
    }

    @Test
    public void star() {
        String input = "12\n" +
                "23\n" +
                "1\n" +
                "11\n" +
                "6\n" +
                "0\n" +
                "9\n" +
                "1\n" +
                "2\n" +
                "0\n" +
                "1\n" +
                "10\n" +
                "1\n" +
                "11\n" +
                "5\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "8\n" +
                "9\n" +
                "6\n" +
                "7\n" +
                "7\n" +
                "8\n" +
                "0\n" +
                "6\n" +
                "3\n" +
                "4\n" +
                "0\n" +
                "2\n" +
                "11\n" +
                "7\n" +
                "0\n" +
                "8\n" +
                "0\n" +
                "4\n" +
                "9\n" +
                "10\n" +
                "0\n" +
                "5\n" +
                "0\n" +
                "7\n" +
                "0\n" +
                "3\n" +
                "0\n" +
                "10\n" +
                "5\n" +
                "6\n" +
                "0\n" +
                "11\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "10\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n";


        ByteArrayOutputStream output = new ByteArrayOutputStream();
        new Player().play(
                new ByteArrayInputStream(input.getBytes()),
                new PrintStream(output));

        Assert.assertEquals("11 5\n" +
                        "6 0\n" +
                        "7 0\n" +
                        "8 0\n" +
                        "9 0\n" +
                        "10 0\n" +
                        "1 0\n" +
                        "2 0\n" +
                        "3 0\n" +
                        "4 0\n" +
                        "5 0\n",
                output.toString());
    }

}
