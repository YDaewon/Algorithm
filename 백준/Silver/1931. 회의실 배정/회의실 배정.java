import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int [][] conference;
	public static void main(String[] args) {
		int n;
	    n = sc.nextInt();
	    conference = new int [n][2]; // 0: start,   1: end
	    for (int i =0; i <n; i++){
	    	conference[i][0] = sc.nextInt();
	    	conference[i][1] = sc.nextInt();
	    }
	    Arrays.sort(conference, (o1,o2) -> {
	    	if(o1[1] > o2[1]) return 1;
	    	else if(o1[1] == o2[1]){
	    		if(o1[0] > o2[0]) return 1;
	    	}
	    	return -1;
	    });
	    //for(int i=0; i < n; i++) System.out.println(conference[i][0] + ", " + conference[i][1]);

	    int end = conference[0][1];
	    int count = 1;
	    for(int i=1;i<n;i++){
	        if (end <= conference[i][0]){
	            end = conference[i][1];
	            count++;        
	        }
	    }
	       
	    System.out.println(count);
	}
}



    