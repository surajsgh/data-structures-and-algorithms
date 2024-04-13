public class EggDropPuzzle {
    public static void main(String[] args) {
        System.out.println(dropEgg(10, 2));
        System.out.println(dropEggDP(10, 2));
    }

    //  Time Complexity: O(exponential)
    //  Auxiliary Space: O(exponential)
    public static int dropEgg(int floors, int eggs) {
        if (floors==0 || floors==1) return floors;
        if(eggs==1) return floors;
        int res = Integer.MAX_VALUE;

        int i, val;
        for (i=1; i<=floors; i++) {
            val = Math.max(dropEgg(i-1, eggs-1), dropEgg(floors-i, eggs));
            res = Math.min(res, val);
        }

        return res + 1;
    }

    //  Time Complexity: O(Eggs*Floors*Floors)
    //  Auxiliary Space: O(Eggs*Floors)
    public static int dropEggDP(int floors, int eggs) {
        int[][] matrix = new int[eggs+1][floors+1];

        for (int i=1; i<=eggs; i++) {
            for (int j=0; j<2; j++) {
                matrix[i][j] = j;
            }
        }

        for (int i=1; i<=floors; i++) {
            matrix[0][i] = 0;
            matrix[1][i] = i;
        }

        for (int i=2; i<=eggs; i++) {
            for (int j=2; j<=floors; j++) {
                matrix[i][j] = Integer.MAX_VALUE;
                for (int k=1; k<=j; k++) {
                    int val = Math.max(matrix[i-1][k-1], matrix[i][j-k]) + 1;
                    matrix[i][j] = Math.min(val, matrix[i][j]);
                }
            }
        }

        return matrix[eggs][floors];
    }
}
