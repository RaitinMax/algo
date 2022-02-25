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
        int[] resultTeam = new int[team.length-2];
        int i = 0, j = 0;
        for (int k = 0; k < team.length-2; k++) {
            if (i > team1.length - 1) {
                int a = team2[j];
                resultTeam[k] = a;
                j++;
            } else if (j > team2.length - 1) {
                int a = team1[i];
                resultTeam[k] = a;
                i++;
            } else if (team1[i] < team2[j]) {
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
        int[] firstTeam = new int[]{1, 23, 24, 40, 75, 76, 78, 77, 900, 2100, 2200, 2300, 2400};
        int[] secondTeam = new int[]{10, 11, 41, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000};
        int[] thirdTeam = new int[]{2, 6, 8, 101, 120, 130, 554, 1000, 3233, 4455, 6000, 7000, 8000};
        int[][] nationalTeam = {firstTeam, secondTeam, thirdTeam};

        printTeam(getNationalTeam(nationalTeam));
    }
}