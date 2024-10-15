import java.util.Scanner;

public class Main {
	static int n;
	static int [][] node;
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   n = sc.nextInt();
	   node = new int [n][n];
	   for(int i = 0; i < n; i++) {
		   for(int j = 0; j < n; j++) {
			   node[i][j] = sc.nextInt();
		   }
	   }
	   for(int k = 0; k < n; k++) {
		   for(int i = 0; i < n; i++) {
			   for(int j = 0; j < n; j++) {
				   if((node[i][k] & node[k][j]) != 0) node[i][j] = 1;
			   }
		   }
	   }
	   
	   
	   for(int i = 0; i < n; i++) {
		   for(int j = 0; j < n; j++) {
			   System.out.print(node[i][j] + " ");
		   }
		   System.out.println();
	   }
   }

}