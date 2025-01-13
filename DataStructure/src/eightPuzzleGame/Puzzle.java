package eightPuzzleGame;

import java.io.File;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.LinkedList;

import java.util.Queue;

import java.util.Scanner;

import java.util.Stack;

public class Puzzle {
	public static class Node
	    {
	        public PuzzleState currentState;
	        public Node parent;
	        public double cost; // cost to get to this state
	        public double hValue; // heuristic cost value
	        public double fValue; // f(n) cost
	        //First node to start with root node
	        public Node(PuzzleState s)
	        {
	            currentState = s;
	            parent = null;
	            cost = 0;
	            hValue = 0;
	            fValue = 0;
	        }
	        //And the rest are child nodes using this constructor
	        public Node(Node prev, PuzzleState s, double c, double h)
	        {
	            parent = prev;
	            currentState = s;
	            cost = c;
	            hValue = h;
	            fValue = cost + h;
	        }
	        //returns the puzzleconfig after moves
	        public PuzzleState getCurrentState()
	        {
	            return currentState;
	        }
	        public Node getParent()
	        {
	            return parent;
	        }
	         
	        public double getCost()
	        {
	            return cost;
	        }
	         
	        public double getHeuristicValue()
	        {
	            return hValue;
	        }
	        public double getFTotal()
	        {
	            return fValue;
	        }
	         
	        public double getFCost()
	        {
	            return fValue;
	        }
	    }
	    public static class PuzzleState
	    {
	        //initialization of state values
	        int puzzleSize = 9;
	        int piecesOutOfPlace = 0;
	        int manhattanDistance = 0;
	        //defining goal state
	        int[] goal = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0};
	        int[] currentBoard;
	        //Set cost
	        int cost = 1;
	   
	        public PuzzleState(int[] puzzleBoard)
	        {
	            currentBoard = puzzleBoard;
	        }
	      
	        public boolean isGoal()
	        {
	            if (Arrays.equals(currentBoard, goal))
	            {
	                return true;
	            }
	            return false;
	        }
	         
	        public ArrayList<PuzzleState> generateSuccessors()
	        {
	            ArrayList<PuzzleState> successors = new ArrayList<PuzzleState>();
	            int hole = getHole();
	            //testing to move Left
	            if (hole != 0 && hole != 3 && hole != 6)
	            {
	                swapAndStore(hole - 1, hole, successors);
	            }
	            // try to generate a state by sliding a tile up
	            if (hole != 6 && hole != 7 && hole != 8)
	            {
	                swapAndStore(hole + 3, hole, successors);
	            }
	 
	            // try to generate a state by sliding a tile down
	            if (hole != 0 && hole != 1 && hole != 2)
	            {
	                swapAndStore(hole - 3, hole, successors);
	            }
	            // try to generate a state by sliding a tile right
	            if (hole != 2 && hole != 5 && hole != 8)
	            {
	                swapAndStore(hole + 1, hole, successors);
	            }
	 
	            return successors;
	        }
	 
	        /*
	         * Switches the data at indices d1 and d2, in a copy of the current board
	         * creates a new state based on this new board and pushes into s.
	         */
	        public void swapAndStore(int d1, int d2, ArrayList<PuzzleState> s)
	        {
	            int[] cpy = copyBoard(currentBoard);
	            int temp = cpy[d1];
	            cpy[d1] = currentBoard[d2];
	            cpy[d2] = temp;
	            s.add((new PuzzleState(cpy)));
	        }
	         
	        public int[] copyBoard(int[] state)
	        {
	            int[] ret = new int[puzzleSize];
	            for (int i = 0; i < puzzleSize; i++)
	            {
	                ret[i] = state[i];
	            }
	            return ret;
	        }
	         
	
	        public int getHole()
	
	        {
	
	            // If returning -1, an error has occured. The "hole" should always exist
	
	            // on the board and should always be found by the below loop.
	
	            int holeIndex = -1;
	
	 
	
	            for (int i = 0; i < puzzleSize; i++)
	
	            {
	
	                if (currentBoard[i] == 0)
	
	                    holeIndex = i;
	
	            }
	
	            return holeIndex;
	
	        }
	
	         
	
	        public void setManDist()
	
	        {
	
	            // linearly search the array independent of the nested for's below
	
	            int index = -1;
	
	 
	
	            // just keeps track of where we are on the board (relatively, can't use
	
	            // 0 so these
	
	            // values need to be shifted to the right one place)
	
	            for (int y = 0; y < 3; y++)
	
	            {
	
	                for (int x = 0; x < 3; x++)
	
	                {
	
	                    index++;
	
	 
	
	                    // sub 1 from the val to get the index of where that value
	
	                    // should be
	
	                    int val = (currentBoard[index] - 1);
	
	 
	
	                    /*
	
	                     * If we're not looking at the hole. The hole will be at
	
	                     * location -1 since we subtracted 1 before to turn val into the
	
	                     * index
	
	                     */
	
	                    if (val != -1)
	
	                    {
	
	                        // Horizontal offset, mod the tile value by the horizontal
	
	                        // dimension
	
	                        int horiz = val % 3;
	
	                        // Vertical offset, divide the tile value by the vertical
	
	                        // dimension
	
	                        int vert = val / 3;
	
	 
	
	                        manhattanDistance += Math.abs(vert - (y)) + Math.abs(horiz - (x));
	
	                    }
	
	                    // If we are looking at the hole, skip it
	
	                }
	
	            }
	
	        }
	
	        public void printState()
	
	        {
	
	            System.out.println(currentBoard[0] + " | " + currentBoard[1] + " | "
	
	                    + currentBoard[2]);
	
	            System.out.println("---------");
	
	            System.out.println(currentBoard[3] + " | " + currentBoard[4] + " | "
	
	                    + currentBoard[5]);
	
	            System.out.println("---------");
	
	            System.out.println(currentBoard[6] + " | " + currentBoard[7] + " | "
	
	                    + currentBoard[8]);
	
	 
	
	        }
	
	         
	
	     
	
	     
	
	         
	
	    }
	
	     
	
	     
	
	     
	
	    public static void main(String[] args) throws IOException
	
	    {
	
	         
	
	        int collumnInput = 0;
	
	        int rowInput = 0;
	
	        if (args.length == 0)
	
	        {
	
	            System.out.println("Give 8-puzzle as 3x3 matrix (a space between digits, hit Enter after each line:  " );
	
	            Scanner scan = new Scanner (System.in);
	
	            int[][] puzzleArray = new int[3][3];
	
	             
	
	            for (collumnInput=0; collumnInput < 3; collumnInput++)
	
	            {
	
	                for (rowInput = 0; rowInput < 3; rowInput++)
	
	                {
	
	                    try
	
	                    {
	
	                        puzzleArray[collumnInput][rowInput] = scan.nextInt();
	
	                     
	
	                        if ((puzzleArray[collumnInput][rowInput] > 8) || (puzzleArray[collumnInput][rowInput] < 0))
	
	                        {
	
	                            System.out.println("Invalid 8-puzzle entered!");
	
	                            System.exit(0);
	
	                        }
	
	                         
	
	                         
	
	                    }
	
	                    catch (java.util.InputMismatchException exception)
	
	                    {
	
	                        System.out.println("Invalid 8-puzzle entered!");
	
	                        System.exit(0);
	
	                    }
	
	                     
	
	                }
	
	            }
	
	            scan.close();
	
	                  
	
	            for(int column = 0; column < 3; column++)
	
	            {
	
	                for(int row = 0; row < 3; row++)
	
	                {
	
	                    System.out.print(puzzleArray[column][row] + " "); //Outputs the array in a 3x3 grid.
	
	                }
	
	                System.out.println();
	
	            }
	
	            boolean []check = new boolean[9];
	
	 
	
	            for (int collumnCheck = 0; collumnCheck < collumnInput; collumnCheck++){
	
	                 for (int rowCheck = 0; rowCheck < rowInput; rowCheck++)
	
	                 {
	
	                      if (check[puzzleArray[collumnCheck][rowCheck]]){
	
	                          System.out.println("Invalid 8-puzzle entered!");
	
	                          System.exit(0);
	
	                      }else
	
	                      {
	
	                          check[ puzzleArray[collumnCheck][rowCheck]] = true;
	
	                      } 
	
	                 }
	
	                 
	
	            }
	
	            int[] oneDArray = convertToOneD(puzzleArray);
	
	            boolean possible=isSolvable(oneDArray);
	
	            if (possible == true)
	
	            {
	
	                System.out.println("Is solvable");
	
	                AStarSolve(oneDArray);
	
	            }
	
	            else
	
	                System.out.println("Not solvable");
	
	        }
	
	     
	
	 
	
	             
	
	        /*else if (args.length == 1)
	
	        {
	
	     
	
	        }
	
	        else if (args.length == 2)
	
	        {
	
	             
	
	        }
	
	        else
	
	        {
	
	            System.out.println("Invalid number of arguments, halting execution.");
	
	        }
	
	        */
	
	    }
	
	     
	
	     
	
	    public static boolean isSolvable(int [] p)
	
	    {  
	
	        int i, j, n, inversions = 0;
	
	        n = p.length;
	
	        for(i = 0; i < n - 1; i++)
	
	            for(j = i+1; j < n; j++)
	
	                if(p[i] > p[j]) {
	
	                    //System.out.println("("+p[i]+", "+p[j]+")");
	
	                    inversions++;
	
	                }
	
	    //System.out.println("Number of inversions are: "+inversions);
	
	        return !((inversions > 0) && (inversions % 2 == 0));
	
	    }
	
	     
	
	    public static int[] convertToOneD(int[][] theArray)
	
	    {
	
	        int[] singleD = new int[9];
	
	        int k=0;
	
	        for (int i=0; i < 3; i++)
	
	        {
	
	            for (int j=0; j < 3; j++)
	
	            {
	
	                singleD[k] = theArray[i][j];
	
	                k++;
	
	            }
	
	         
	
	        }
	
	        for (k = 0; k < 9; k++)
	
	        {
	
	            System.out.print(singleD[k]+" ");
	
	             
	
	        }
	
	        return singleD;
	
	    }
	
	     
	
	    /*
	
	     * Helper method to check to see if a SearchNode has already been evaluated.
	
	     * Returns true if it has, false if it hasn't.
	
	     */
	
	    public static boolean checkRepeats(Node n)
	
	    {
	
	        boolean retValue = false;
	
	        Node checkNode = n;
	
	 
	
	        // While n's parent isn't null, check to see if it's equal to the node
	
	        // we're looking for.
	
	        while (n.getParent() != null && !retValue)
	
	        {
	
	            if (n.getParent().getCurrentState().equals(checkNode.getCurrentState()))
	
	            {
	
	                retValue = true;
	
	            }
	
	            n = n.getParent();
	
	        }
	
	 
	
	        return retValue;
	
	    }
	
	     
	
	     
	
	    public static void AStarSolve(int[] puzzleBoard)
	
	    {
	
	        Node rootNode = new Node(new PuzzleState(puzzleBoard));
	
	        Queue<Node> q = new LinkedList<Node>();
	
	        q.add(rootNode);
	
	         
	
	        int searchIteration = 1;
	
	         
	
	        while (!q.isEmpty())//Do if queue is not empty
	
	        {
	
	            Node temporaryNode = (Node) q.poll();
	
	            if (!temporaryNode.getCurrentState().isGoal())
	
	            {
	
	                //generate successors to temporary node
	
	                ArrayList<PuzzleState>successorsToTempNode = temporaryNode.getCurrentState().generateSuccessors();
	
	                ArrayList<Node> nodeSuccessors = new ArrayList<Node>();
	
	                 
	
	                for (int i=0; i< successorsToTempNode.size(); i++)
	
	                {
	
	                    Node visitedNode;
	
	                    visitedNode = new Node(temporaryNode, successorsToTempNode.get(i), temporaryNode.getCost() + successorsToTempNode.get(i).cost,
	
	                            ((PuzzleState) successorsToTempNode.get(i)).manhattanDistance);
	
	                     
	
	                    // Check for repeats before adding the new node
	
	                    if (!checkRepeats(visitedNode))
	
	                    {
	
	                        nodeSuccessors.add(visitedNode);
	
	                    }
	
	                }
	
	                 
	
	                if (nodeSuccessors.size() == 0)
	
	                    continue;//continue loop from top
	
	                 
	
	                Node lowestNode = nodeSuccessors.get(0);
	
	                 
	
	                for (int i = 0; i < nodeSuccessors.size(); i++)
	
	                {
	
	                    if (lowestNode.getFCost() > nodeSuccessors.get(i)
	
	                            .getFCost())
	
	                    {
	
	                        lowestNode = nodeSuccessors.get(i);
	
	                    }
	
	                }
	
	                 
	
	                int lowestValue = (int) lowestNode.getFCost();
	
	                 
	
	                for (int i = 0; i < nodeSuccessors.size(); i++)
	
	                {
	
	                    if (nodeSuccessors.get(i).getFCost() == lowestValue)
	
	                    {
	
	                        q.add(nodeSuccessors.get(i));
	
	                    }
	
	                }
	
	                 
	
	                 
	
	                 
	
	
	
	                searchIteration++;
	
	            }
	
	            else
	
	                // The goal state has been found. Print the path it took to get to
	
	                // it.
	
	                {
	
	                    // Use a stack to track the path from the starting state to the
	
	                    // goal state
	
	                    Stack<Node> solutionPath = new Stack<Node>();
	
	                    solutionPath.push(temporaryNode);
	
	                    temporaryNode = temporaryNode.getParent();
	
	 
	
	                    while (temporaryNode.getParent() != null)
	
	                    {
	
	                        solutionPath.push(temporaryNode);
	
	                        temporaryNode = temporaryNode.getParent();
	
	                    }
	
	                    solutionPath.push(temporaryNode);
	
	                    // The size of the stack before looping through and emptying it.
	                    int loopSize = solutionPath.size();
	                    for (int i = 0; i < loopSize; i++)
	                    {
	                        temporaryNode = solutionPath.pop();
	                        temporaryNode.getCurrentState().printState();
	                        System.out.println();
	                        System.out.println();
	                    }
	                    System.out.println("The cost was: " + temporaryNode.getCost());

	                    System.out.println("The number of nodes examined: " + searchIteration);
	                }
	                    System.exit(0);
	            }
	    }
	}

