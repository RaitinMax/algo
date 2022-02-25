class Main {
    public static final int SIZE = 10;

    public static void printField(char[][] field) {
        for (char[] row : field) {
            for (char column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    public static char whereFrom(char[][] field, int x, int y, char[][] memory) {
        if (memory[x][y] != 0) {
            return memory[x][y];
        }
        if (x > 0) {
            int left_x = x - 1;
            int left_y = y;
            if (left_x == 0 && left_y == 0) {
                memory[x][y] = 'L';
                return 'L';
            }
            if (field[left_x][left_y] != '*') {
                if (whereFrom(field, left_x, left_y, memory) != 'N') {
                    memory[x][y] = 'L';
                    return 'L';
                }
            }
        }
        if (y > 0) {
            int up_x = x;
            int up_y = y - 1;
            if (up_x == 0 && up_y == 0) {
                memory[x][y] = 'U';
                return 'U';
            }
            if (field[up_x][up_y] != '*') {
                if (whereFrom(field, up_x, up_y, memory) != 'N') {
                    memory[x][y] = 'U';
                    return 'U';
                }
            }
        }
        memory[x][y] = 'N';
        return 'N';
    }

    public static char[][] findPath(char[][] field, int x, int y) {
        boolean[][] path = new boolean[SIZE][SIZE];
        char[][] memory = new char[SIZE][SIZE];
        char[][] pathToHuman = new char[SIZE][SIZE];
        final int x0 = x;
        final int y0 = y;
        while (x != 0 || y != 0) {
            char direction = whereFrom(field, x, y, memory);
            if (direction == 'N') {
                System.out.println("Such path doesn't exist");
                break;
            } else if (direction == 'U') {
                path[x][y] = true;
                y -= 1;
            } else if (direction == 'L') {
                path[x][y] = true;
                x -= 1;
            }
            for (int i = 0; i < pathToHuman.length; i++) {
                for (int j = 0; j < pathToHuman.length; j++) {
                    if (i == x0 && j == y0) {
                        pathToHuman[i][j] = 'Ч';
                    } else if (path[i][j]) {
                        pathToHuman[i][j] = 'x';
                    } else {
                        pathToHuman[i][j] = field[i][j];
                    }
                }
            }
        }
        return pathToHuman;
    }

    public static void main(String[] args) {
        char[][] field = {{'Щ', '-', '-', '*', '*', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '*', '-', '*', '*', '-', '-'},
                {'-', '-', '-', '*', '-', '*', '-', '-', '-', '*'},
                {'-', '*', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-', '-', '*', '-', '-'},
                {'-', '-', '-', '*', '-', '-', '*', '-', '-', '-'},
                {'-', '-', '-', '-', '*', '-', '-', '*', '-', '-'},
                {'-', '-', '*', '-', '-', '-', '-', '*', '-', '-'},
                {'-', '-', '-', '-', '-', '-', '-', '*', '-', '*'},
                {'-', '-', '-', '-', '-', '*', '*', '-', '-', '-'}};

        printField(field);
        System.out.println();
        printField(findPath(field, 3, 8));
    }
}