import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    public static void print(int sv, int[][] adj_matrix, boolean[] visited){
        int v = visited.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sv);
        visited[sv] = true;

        while(!queue.isEmpty()){
            int front = queue.poll();
            System.out.print(front + " ");

            for(int i = 0; i < v; i++){
                if(!visited[i] && adj_matrix[front][i] == 1){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of vertex");
        int v = sc.nextInt();
        System.out.println("Enter the no.of edges");
        int e = sc.nextInt();
        int[][] adj_matrix = new int[v][v];

        for(int i = 0; i < e; i++){
            int sv = sc.nextInt();
            int ev = sc.nextInt();
            adj_matrix[sv][ev] = 1;
            adj_matrix[ev][sv] = 1;
        }
        boolean[] visited = new boolean[v];
        for(int i = 0; i < v; i++){
            if(!visited[i]) {
                print(i,adj_matrix,visited);
                System.out.println();
            }
        }
    }
}
