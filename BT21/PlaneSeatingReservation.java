package BT21;

public class PlaneSeatingReservation {
    public static int solution(int N, String S) {
        if (S.trim().isEmpty()) {
            return N*3;
        }
        int[][] seats = new int[N+1][10];
        String[] reservedSeats = S.split(" ");
        for (String seat : reservedSeats) {
            int row = Integer.parseInt(seat.substring(0, seat.length() - 1));
            int column = seat.charAt(seat.length() - 1) - 'A';
            if (column >= 9) {
                column--;
            }
            seats[row][column] = 1;
        }
        int count = 0;
        for (int i = 1; i < N+1; i++) {
            int[] row = seats[i];
            if (row[0] == 0 && row[1] == 0 && row[2] == 0) {
                count++;
            }
            if (row[7] == 0 && row[8] == 0 && row[9] == 0) {
                count++;
            }
            if (row[4] == 0 && row[5] == 0 && (row[3] == 0 || row[6] == 0)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, "1A 2F 1C")); // 4
        System.out.println(solution(2, " ")); // 6
        System.out.println(solution(2, "1D 2G")); // 6
        System.out.println(solution(2, "1D 1G 2D 2G")); // 4
        System.out.println(solution(2, "1A 1E 1H 2J 2B 2K 2F")); // 0
    }
}
