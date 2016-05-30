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

    @Test
    public void tripleStar() {
        String input = "38\n" +
                "79\n" +
                "3\n" +
                "28\n" +
                "36\n" +
                "0\n" +
                "2\n" +
                "3\n" +
                "34\n" +
                "29\n" +
                "21\n" +
                "37\n" +
                "35\n" +
                "28\n" +
                "32\n" +
                "0\n" +
                "10\n" +
                "37\n" +
                "2\n" +
                "4\n" +
                "5\n" +
                "13\n" +
                "14\n" +
                "34\n" +
                "35\n" +
                "27\n" +
                "19\n" +
                "28\n" +
                "34\n" +
                "30\n" +
                "31\n" +
                "18\n" +
                "26\n" +
                "0\n" +
                "9\n" +
                "7\n" +
                "8\n" +
                "18\n" +
                "24\n" +
                "18\n" +
                "23\n" +
                "0\n" +
                "5\n" +
                "16\n" +
                "17\n" +
                "29\n" +
                "30\n" +
                "10\n" +
                "11\n" +
                "0\n" +
                "12\n" +
                "15\n" +
                "16\n" +
                "0\n" +
                "11\n" +
                "0\n" +
                "17\n" +
                "18\n" +
                "22\n" +
                "23\n" +
                "24\n" +
                "0\n" +
                "7\n" +
                "35\n" +
                "23\n" +
                "22\n" +
                "23\n" +
                "1\n" +
                "2\n" +
                "0\n" +
                "13\n" +
                "18\n" +
                "27\n" +
                "25\n" +
                "26\n" +
                "32\n" +
                "33\n" +
                "28\n" +
                "31\n" +
                "24\n" +
                "25\n" +
                "28\n" +
                "35\n" +
                "21\n" +
                "22\n" +
                "4\n" +
                "33\n" +
                "28\n" +
                "29\n" +
                "36\n" +
                "22\n" +
                "18\n" +
                "25\n" +
                "37\n" +
                "23\n" +
                "18\n" +
                "21\n" +
                "5\n" +
                "6\n" +
                "19\n" +
                "20\n" +
                "0\n" +
                "14\n" +
                "35\n" +
                "36\n" +
                "9\n" +
                "10\n" +
                "0\n" +
                "6\n" +
                "20\n" +
                "21\n" +
                "0\n" +
                "3\n" +
                "33\n" +
                "34\n" +
                "14\n" +
                "15\n" +
                "28\n" +
                "33\n" +
                "11\n" +
                "12\n" +
                "12\n" +
                "13\n" +
                "17\n" +
                "1\n" +
                "18\n" +
                "19\n" +
                "36\n" +
                "29\n" +
                "0\n" +
                "4\n" +
                "0\n" +
                "15\n" +
                "0\n" +
                "1\n" +
                "18\n" +
                "20\n" +
                "2\n" +
                "3\n" +
                "0\n" +
                "16\n" +
                "8\n" +
                "9\n" +
                "0\n" +
                "8\n" +
                "26\n" +
                "27\n" +
                "28\n" +
                "30\n" +
                "3\n" +
                "4\n" +
                "31\n" +
                "32\n" +
                "6\n" +
                "7\n" +
                "37\n" +
                "1\n" +
                "37\n" +
                "24\n" +
                "35\n" +
                "2\n" +
                "0\n" +
                "18\n" +
                "28\n" +
                "37\n" +
                "35\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "33\n" +
                "34\n" +
                "35\n" +
                "23\n" +
                "22\n" +
                "21\n" +
                "29\n" +
                "36\n" +
                "29\n" +
                "30\n" +
                "31\n" +
                "32\n" +
                "33\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "10\n" +
                "11\n" +
                "12\n" +
                "13\n" +
                "14\n" +
                "15\n" +
                "16\n" +
                "17\n" +
                "1\n" +
                "2\n" +
                "37\n" +
                "24\n" +
                "25\n" +
                "26\n" +
                "27\n" +
                "19\n" +
                "20\n";

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        new Player().play(
                new ByteArrayInputStream(input.getBytes()),
                new PrintStream(output));

        Assert.assertEquals("37 1\n" +
                        "35 28\n" +
                        "2 0\n" +
                        "3 0\n" +
                        "4 0\n" +
                        "33 28\n" +
                        "34 28\n" +
                        "35 28\n" +
                        "23 18\n" +
                        "22 18\n" +
                        "21 18\n" +
                        "29 28\n" +
                        "36 28\n" +
                        "29 28\n" +
                        "30 28\n" +
                        "31 28\n" +
                        "32 28\n" +
                        "33 28\n" +
                        "4 0\n" +
                        "5 0\n" +
                        "6 0\n" +
                        "7 0\n" +
                        "8 0\n" +
                        "9 0\n" +
                        "10 0\n" +
                        "11 0\n" +
                        "12 0\n" +
                        "13 0\n" +
                        "14 0\n" +
                        "15 0\n" +
                        "16 0\n" +
                        "17 0\n" +
                        "1 0\n" +
                        "2 0\n" +
                        "37 1\n" +
                        "24 18\n" +
                        "25 18\n" +
                        "26 18\n" +
                        "27 18\n" +
                        "19 18\n" +
                        "20 18\n",
                output.toString());
    }

}
