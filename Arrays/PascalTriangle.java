import java.io.*;
import java.util.*;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int N = sc.nextInt();
            printPascal(N);
        }
    }

    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                ArrayList<Long> l = new ArrayList<>();
                l.add(1L);
                list.add(l);
            } else if (i == 2) {
                ArrayList<Long> l = new ArrayList<>();
                l.add(1L);
                l.add(1L);
                list.add(l);
            } else {
                ArrayList<Long> down = list.get(list.size() - 1);
                Long first = down.get(0);
                Long last = down.get(down.size() - 1);
                ArrayList<Long> l = new ArrayList<>();
                l.add(first);
                for (int j = 0; j < down.size() - 1; j++) {
                    long a = down.get(j);
                    long b = down.get(j + 1);
                    l.add(a + b);
                }
                l.add(last);
                list.add(l);
            }
        }
        return list;
    }
}
