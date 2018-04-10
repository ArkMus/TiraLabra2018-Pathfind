package pathfinding;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MapReader {

    private final String fileName;

    public MapReader(String fileName) {
        this.fileName = fileName;
    }

    public char[][] generateMap() {
        int height = 0;
        int width = 0;
        char[][] map = new char[1][1];
        int ix = 0;

        BufferedReader buffreader = null;
        try {
            String line;
            FileReader input = new FileReader(fileName);
            buffreader = new BufferedReader(input);

            while ((line = buffreader.readLine()) != null) {
                if (line.contains("height")) {
                    height = Integer.parseInt(line.substring(7));
                }
                if (line.contains("width")) {
                    width = Integer.parseInt(line.substring(6));
                    map = new char[height][width];
                }
                if (!line.contains("type") && !line.contains("height") && !line.contains("width") && !line.contains("map")) {
                    for (int i = 0; i < line.length(); i++) {
                        map[ix][i] = line.charAt(i);
                    }
                    ix++;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not find file " + fileName + "! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName + ". " + e.getMessage());
        }
        if (buffreader != null) {
            try {
                buffreader.close();
            } catch (IOException ex) {
                System.out.println("Error closing buffreader: " + ex.getMessage());
            }
        }
        return map;
    }
}
