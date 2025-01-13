package shortestpath;

import java.util.List;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		int row = 0;
        int col = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Starting Node [row column] : ");
        row =  in.nextInt(); 
        col =  in.nextInt();
        Node initialNode = new Node(row, col);
        System.out.println("Enter Goal Node [row column] : ");
        row =  in.nextInt(); 
        col =  in.nextInt();
        Node finalNode = new Node(row, col);
        int rows = 15;
        int cols = 15;
        FindPath path = new FindPath(rows, cols, initialNode, finalNode);
        int[][] blocksArray = new int[][]{{(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), (int) (Math.random()*10)}, {(int) (Math.random()*10), (int) (Math.random()*10)}};
        row = 0;
        col = 0;
        /*  PRINT PATH */
        System.out.println("###### GRID ######\n");
        for(int i=0; i<rows; i++) {
        	
        	for (int j=0; j<cols; j++) {
//        		if(j==0)
//        			System.out.print(i+1+"- ");
//        		if(i==0) {
//        			System.out.print(j+1+" ");
//        		}
        		int block = 0;
        		for (int b = 0; b < blocksArray.length; b++) {
                    row = blocksArray[b][0];
                    col = blocksArray[b][1];
                    if(row==i && col==j) {
	                 	System.out.print("B"+" ");
	                 	block=1;
	                 }
                }
        		if(block==0)
             		System.out.print("-"+" ");
                 
        	}
        	System.out.println("\n");
        }
        
        path.setBlocks(blocksArray);
        List<Node> optimalPath = path.findPath();
        for (Node node : optimalPath) {
            System.out.print("["+node.getRow()+","+node.getCol()+"] ");
        }
	}
}