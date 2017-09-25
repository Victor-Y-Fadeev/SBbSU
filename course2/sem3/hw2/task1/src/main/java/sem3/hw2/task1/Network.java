package sem3.hw2.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/** Network class. */
public class Network {
    private boolean[][] matrix;
    private Computer[] computers;

    /** Load network card from file. */
    public Network(final String path) {
        try(FileReader reader = new FileReader(path)) {
            BufferedReader in = new BufferedReader(reader);

            final int size = Integer.parseInt(in.readLine());

            computers = loadComputers(in, size);
            matrix = loadMatrix(in, size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** To do progress. */
    public void timeGoes() {
        HashSet<Computer> toInfect = new HashSet<>();

        for (int i = 0; i < computers.length; i++) {
            if (computers[i].isVirus()) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] && !computers[j].isVirus()) {
                        toInfect.add(computers[j]);
                    }
                }
            }
        }

        toInfect.forEach(computer -> computer.tryInfect());
    }

    /** Get computers status. */
    public String getStatus() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < computers.length; i++) {
            builder.append(i + 1);
            builder.append(") ");
            builder.append(computers[i].getOS());

            if (computers[i].isVirus()) {
                builder.append(" (virus)");
            }
            builder.append("\n");
        }

        builder.append("\n");
        return builder.toString();
    }

    /** Get network structure. */
    public String getStructure() {
        StringBuilder builder = new StringBuilder();

        builder.append(" ");
        for (int i = 0; i < matrix.length; i++) {
            builder.append("    ");
            builder.append(i + 1);
        }
        builder.append("\n");

        for (int i = 0; i < matrix.length; i++) {
            builder.append(i + 1);
            builder.append("    ");

            for (int j = 0; j < matrix.length; j++) {
                builder.append(matrix[i][j] ? 1 : 0);
                builder.append("    ");
            }
            builder.append("\n");
        }

        builder.append("\n");
        return builder.toString();
    }

    private static Computer[] loadComputers(BufferedReader in, final int size) {
        Computer[] computers = new Computer[size];

        try {
            for (int i = 0; i < size; i++) {
                computers[i] = new Computer(in.readLine());
            }

            in.readLine();

            final String infect = in.readLine();
            final String[] infectList = infect.split(" ");
            for (int i = 0; i < infectList.length; i++) {
                final int x = Integer.parseInt(infectList[i]) - 1;
                computers[x].infect();
            }

            in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return computers;
    }

    private static boolean[][] loadMatrix(BufferedReader in, final int size) {
        boolean[][] matrix = new boolean[size][size];

        try {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = false;
                }
            }

            final int connections = Integer.parseInt(in.readLine());
            for (int i = 0; i < connections; i++) {
                final String connect = in.readLine();
                final String[] connectionPoint = connect.split(" ");
                final int x = Integer.parseInt(connectionPoint[0]) - 1;
                final int y = Integer.parseInt(connectionPoint[1]) - 1;

                matrix[x][y] = true;
                matrix[y][x] = true;
            }

            in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matrix;
    }
}
