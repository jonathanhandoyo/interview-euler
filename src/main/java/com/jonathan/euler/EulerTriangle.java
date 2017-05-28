package com.jonathan.euler;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class EulerTriangle {

    /**
     * <p>Reads all the lines of the input file and convert them into 2 dimensional array.</p>
     * <p>Starting from the bottom of the triangle, for every 2 neighboring numbers, find the larger number and fold to the above number.</p>
     * <p>Keep folding until reached the top.</p>
     *
     * @param file  filename of the input
     * @return aggregated result of the maximum possible sum or {@code -1} if any exception occurred
     */
    public int solve(String file) {
        try {
            int[][] data =
                    //read the text file and stream per line
                    Files.lines(Paths.get(this.getClass().getClassLoader().getResource(file).toURI()))
                    //for each line, convert to array (1 dimension) of integers, tokenized by whitespace
                    .map(s -> Arrays.stream(s.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray())
                    //collect to a 2 dimension array
                    .toArray(int[][]::new);

            //start from the BOTTOM of the triangle to the TOP of the triangle
            for (int row = data.length - 1; row > 0; row--) {
                //start from the LEFT of the triangle to the RIGHT of the triangle
                for (int cell = 0; cell < data[row].length - 1; cell++) {
                    //for every neighboring number, find the larger of the two and fold to the number above it
                    int max = Math.max(data[row][cell], data[row][cell + 1]);
                    data[row - 1][cell] = data[row - 1][cell] + max;
                }
            }

            return data[0][0];
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return -1;
        }

    }
}
