class Main {
    public static void printTeam(int[] team) {
        for (int i = 0; i < team.length; i++) {
            System.out.print(team[i] + " ");
        }
    }

    public static int[] getNationalTeam(int[][] teams) {
        int[] team  = teams[0];

        for (int i = 0; i < teams.length; i++) {
            if (i + 1 == teams.length) {
                break;
            }
            team = merge(team, team, teams[i + 1]);
        }
        return team;
    }

    public static int[] merge(int[] team, int[] team1, int[] team2) {
        int[] resultTeam = new int[10];
        int i = 0, j = 0;
        for (int k = 0; k < resultTeam.length; k++) {
            if (i > team1.length - 1) {
                int a = team2[j];
                resultTeam[k] = a;
                j++;
            } else if (j > team2.length - 1) {
                int a = team1[i];
                resultTeam[k] = a;
                i++;
            } else if (team1[i] > team2[j]) {
                int a = team1[i];
                resultTeam[k] = a;
                i++;
            } else {
                int b = team2[j];
                resultTeam[k] = b;
                j++;
            }
        }
        return resultTeam;
    }

    public static void main(String[] args) {
        int[] firstTeam = new int[]{45, 31, 24, 22, 20, 17, 14, 13, 12, 10};
        int[] secondTeam = new int[]{31, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        int[] thirdTeam = new int[]{51, 30, 10, 9, 8, 7, 6, 5, 2, 1};
        int[][] nationalTeam = {firstTeam, secondTeam, thirdTeam};

        printTeam(getNationalTeam(nationalTeam));
    }
}