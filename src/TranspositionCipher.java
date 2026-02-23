public class TranspositionCipher {

    public static String encrypt(String text, int key) {
        int rows = (int) Math.ceil((double) text.length() / key);
        int cols = key;
        char[][] grid = new char[rows][cols];

        int index = 0;

        // Fill column by column
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (index < text.length()) {
                    grid[j][i] = text.charAt(index++);
                }
            }
        }

        // Read row by row
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != '\0') {
                    result.append(grid[i][j]);
                }
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, int key) {
        int rows = (int) Math.ceil((double) text.length() / key);
        int cols = key;
        char[][] grid = new char[rows][cols];

        int index = 0;

        // Fill row by row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (index < text.length()) {
                    grid[i][j] = text.charAt(index++);
                }
            }
        }

        // Read column by column
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                if (grid[i][j] != '\0') {
                    result.append(grid[i][j]);
                }
            }
        }

        return result.toString();
    }

    public static String printMatrix(String text, int key) {
        int rows = (int) Math.ceil((double) text.length() / key);
        int cols = key;
        char[][] grid = new char[rows][cols];

        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (index < text.length()) {
                    grid[i][j] = text.charAt(index++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(grid[i][j] == '\0' ? "  " : grid[i][j] + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}