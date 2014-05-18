package env;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static int[][] board;
	public static int[][] board2;
	public static ArrayList<Integer> maxXmaxer;
	public static ArrayList<Integer> maxYmaxer;

	public static ArrayList<Integer> maxXminer;
	public static ArrayList<Integer> maxYminer;

	//1 represents an X square
	//2 represents an O square
	//0 represents a blank square
	public static int score = 0;
	public static int opposcore = 0;
	public static int score2 = 0;
	public static int opposcore2 = 0;
	
	//plays as X
	public static int[][] Maximizer(int[][] board)	{
		int move;
		int maxX = 0;
		int maxY = 0;
		int maxScoreInc = 0;
		for(int i = 0; i < 3; i++)
		{	
			for(int j = 0; j<3; j++)	{
				
				if(board[i][j]==0)	{
					if(maxScoreInc==0)	{
						maxScoreInc = 5;
						maxX=i;
						maxY=j;
						//System.out.println("X Played at position: "  +i+", " +j);
					}
					
				
					
					
					if(i>0)	{
						if(board[i-1][j] == 1)	{ //potential two in a row
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							maxXmaxer.add(maxX);
							maxYmaxer.add(maxY);
							//System.out.println("Double X Played at position: "  +i+", " +j);

							if(i==1)	{
								if(board[i+1][j] == 1)	{//winning move
									maxScoreInc = 100;//100
									maxX = i;
									maxY = j;
									board[maxX][maxY] = 1;
									return board;
									//System.out.println("Winning X Played at position: "  +i+", " +j);
								}
							} else if(i==2) {
								if(board[i-2][j] == 1)	{//winning move
									maxScoreInc = 100;//100
									maxX = i;
									maxY = j;
									board[maxX][maxY] = 1;
									return board;
									//System.out.println("Winning X Played at position: "  +i+", " +j);
								}
							}
						}
					}
					
					if(i<2)	{
						if(board[i+1][j] == 1)	{
							if(maxScoreInc<10)	{
								maxScoreInc = 10;
								maxX = i;
								maxY = j;
								maxXmaxer.add(maxX);
								maxYmaxer.add(maxY);
							}
						}
					}
				
					
					if(j>0)	{
						if(board[i][j-1] == 1)	{ //potential two in a row
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							//System.out.println("Double X Played at position: "  +i+", " +j);
							maxXmaxer.add(maxX);
							maxYmaxer.add(maxY);
							if(j==1)	{
								if(board[i][j+1] == 1)	{//winning move
									maxScoreInc = 100;//0;
									maxX = i;
									maxY = j;
									board[maxX][maxY] = 1;
									return board;
									//System.out.println("Winning X Played at position: "  +i+", " +j);
								}
							} else if(j==2) {
								if(board[i][j-2] == 1)	{//winning move
									maxScoreInc = 100;//0;
									maxX = i;
									maxY = j;
									board[maxX][maxY] = 1;
									return board;
									//System.out.println("Winning X Played at position: "  +i+", " +j);
								}
							}
						}
					}
					
					if(j<2)	{
						if(board[i][j+1] == 1)	{
							if(maxScoreInc<10)	{
								maxScoreInc = 10;
								maxX = i;
								maxY = j;
								maxXmaxer.add(maxX);
								maxYmaxer.add(maxY);
							}
						}
					}
				
					if(i == 0 && j == 0 )   {
						if(board[i+1][j+1] == 1){
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							maxXmaxer.add(maxX);
							maxYmaxer.add(maxY);
							if(board[i+2][j+2] == 1){
								maxScoreInc = 100;
								maxX = i;
								maxY = j;
								board[maxX][maxY] = 1;
								return board;
							}
						}
						
					}
				    if(i == 2 && j == 2 )   {
						if(board[i-1][j-1] == 1){
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							maxXmaxer.add(maxX);
							maxYmaxer.add(maxY);
							if(board[i-2][j-2] == 1){
								maxScoreInc = 100;
								maxX = i;
								maxY = j;
								board[maxX][maxY] = 1;
								return board;
							}
						}
						
					}
					
					if(i == 1 && j == 1 )   {
						
						if(board[i-1][j-1] == 1)  {
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							maxXmaxer.add(maxX);
							maxYmaxer.add(maxY);
							if(board[i+1][j+1] == 1){
								maxScoreInc = 100;
								maxX = i;
								maxY = j;
								board[maxX][maxY] = 1;
								return board;
							}
							
						}
						
						if(board[i+1][j+1] == 1){
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							maxXmaxer.add(maxX);
							maxYmaxer.add(maxY);
						}
						


						
						if(board[i-1][j+1] == 1)  {
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							maxXmaxer.add(maxX);
							maxYmaxer.add(maxY);
							if(board[i+1][j-1] == 1){
								maxScoreInc = 100;
								maxX = i;
								maxY = j;
								board[maxX][maxY] = 1;
								return board;
							}
							
						}
						
						if(board[i+1][j-1] == 1){
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							maxXmaxer.add(maxX);
							maxYmaxer.add(maxY);
						}
					}
					
			
				}
				
				
			}
		}/*
		if(maxScoreInc == 10)  {
			maxX = (int)(Math.random() * maxXmaxer.size());
			maxY = maxYmaxer.get(maxX);
			maxX = maxXmaxer.get(maxX);;// (int)(Math.random() * 4;
			//System.out.println("Arraylist size:" +maxXmaxer.size());
			maxXmaxer.clear();
			maxYmaxer.clear();
		}*/
		////System.out.println("X Played at position: "  +maxX+", " +maxY);
		board[maxX][maxY] = 1;
		score += maxScoreInc;
		opposcore -= maxScoreInc;
		return board;
	}
	
	
	//plays as X
	public static int[][] Minimizer(int[][] board)	{
		int move;
		int maxX = 0;
		int maxY = 0;
		int maxScoreInc = 0;
		for(int i = 0; i < 3; i++)
		{	
			for(int j = 0; j<3; j++)	{
				
				if(board[i][j]==0)	{
					if(maxScoreInc==0)	{
						maxScoreInc = 5;
						maxX=i;
						maxY=j;
						////System.out.println("X Played at position: "  +i+", " +j);
					}
					
				
					
					
					if(i>0)	{
						if(board[i-1][j] == 1)	{ //potential two in a row
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							maxXminer.add(maxX);
							maxYminer.add(maxY);
							//System.out.println("Double X Played at position: "  +i+", " +j);

							if(i==1)	{
								if(board[i+1][j] == 1)	{//winning move
									maxScoreInc = 100;//100
									maxX = i;
									maxY = j;
									board[maxX][maxY] = 2;
									return board;
									//System.out.println("Winning X Played at position: "  +i+", " +j);
								}
							} else if(i==2) {
								if(board[i-2][j] == 1)	{//winning move
									maxScoreInc = 100;//100
									maxX = i;
									maxY = j;
									board[maxX][maxY] = 2;
									return board;
									//System.out.println("Winning X Played at position: "  +i+", " +j);
								}
							}
						}
					}
					
					if(i<2)	{
						if(board[i+1][j] == 1)	{
							if(maxScoreInc<10)	{
								maxScoreInc = 10;
								maxX = i;
								maxY = j;
								maxXminer.add(maxX);
								maxYminer.add(maxY);
							}
						}
					}
				
					
					if(j>0)	{
						if(board[i][j-1] == 1)	{ //potential two in a row
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							//System.out.println("Double X Played at position: "  +i+", " +j);
							maxXminer.add(maxX);
							maxYminer.add(maxY);
							if(j==1)	{
								if(board[i][j+1] == 1)	{//winning move
									maxScoreInc = 100;//0;
									maxX = i;
									maxY = j;
									board[maxX][maxY] = 2;
									return board;
									//System.out.println("Winning X Played at position: "  +i+", " +j);
								}
							} else if(j==2) {
								if(board[i][j-2] == 1)	{//winning move
									maxScoreInc = 100;//0;
									maxX = i;
									maxY = j;
									board[maxX][maxY] = 2;
									return board;
									//System.out.println("Winning X Played at position: "  +i+", " +j);
								}
							}
						}
					}
					
					if(j<2)	{
						if(board[i][j+1] == 1)	{
							if(maxScoreInc<10)	{
								maxScoreInc = 10;
								maxX = i;
								maxY = j;
								maxXminer.add(maxX);
								maxYminer.add(maxY);
							}
						}
					}
				
					if(i == 0 && j == 0 )   {
						if(board[i+1][j+1] == 1){
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							maxXminer.add(maxX);
							maxYminer.add(maxY);
							if(board[i+2][j+2] == 1){
								maxScoreInc = 100;
								maxX = i;
								maxY = j;
								board[maxX][maxY] = 2;
								return board;
							}
						}
						
					}
				    if(i == 2 && j == 2 )   {
						if(board[i-1][j-1] == 1){
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							maxXminer.add(maxX);
							maxYminer.add(maxY);
							if(board[i-2][j-2] == 1){
								maxScoreInc = 100;
								maxX = i;
								maxY = j;
								board[maxX][maxY] = 2;
								return board;
							}
						}
						
					}
					
					if(i == 1 && j == 1 )   {
						
						if(board[i-1][j-1] == 1)  {
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							maxXminer.add(maxX);
							maxYminer.add(maxY);
							if(board[i+1][j+1] == 1){
								maxScoreInc = 100;
								maxX = i;
								maxY = j;
								board[maxX][maxY] = 2;
								return board;
							}
							
						}
						
						if(board[i+1][j+1] == 1){
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							maxXminer.add(maxX);
							maxYminer.add(maxY);
						}
						


						
						if(board[i-1][j+1] == 1)  {
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							maxXminer.add(maxX);
							maxYminer.add(maxY);
							if(board[i+1][j-1] == 1){
								maxScoreInc = 100;
								maxX = i;
								maxY = j;
								board[maxX][maxY] = 2;
								return board;
							}
							
						}
						
						if(board[i+1][j-1] == 1){
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							maxXminer.add(maxX);
							maxYminer.add(maxY);
						}
					}
					
			
				}
				
				
			}
		}/*
		if(maxScoreInc == 10)  {
			maxX = (int)(Math.random() * maxXminer.size());
			maxY = maxYminer.get(maxX);
			maxX = maxXminer.get(maxX);;// (int)(Math.random() * 4;
			//System.out.println("Arraylist size:" +maxXminer.size());
			maxXminer.clear();
			maxYminer.clear();
		}*/
		////System.out.println("X Played at position: "  +maxX+", " +maxY);
		if(board[0][0] == 1 && board[0][1] == 1){
			maxX = 0;
			maxY = 2;
		} else if(board[1][0] == 1 && board[0][0] == 1) {
			maxX=2;
			maxY=0;
		}
		
		
		board[maxX][maxY] = 2;
		score -= maxScoreInc;
		opposcore += maxScoreInc;
		return board;
		
		
	}
	
	
	public static int[][] MaxAlphaBeta(int[][] board)	{
		int move;
		int maxX = 0;
		int maxY = 0;
		int maxScoreInc = 0;
		for(int i = 0; i < 3; i++)
		{	
			for(int j = 0; j<3; j++)	{
				
				if(board[i][j]==0)	{
					if(maxScoreInc==0)	{
						maxScoreInc = 5;
						maxX=i;
						maxY=j;
						////System.out.println("X Played at position: "  +i+", " +j);
					}
					
				
					
					
					if(i>0)	{
						if(board[i-1][j] == 1)	{ //potential two in a row
						 if(maxScoreInc<10)	{
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							//System.out.println("Double X Played at position: "  +i+", " +j);
						 }
							if(i==1)	{
								if(board[i+1][j] == 1)	{//winning move
								 if(maxScoreInc<100)	{
									maxScoreInc = 100;//100
									maxX = i;
									maxY = j;
									//System.out.println("Winning X Played at position: "  +i+", " +j);
								}
								}
							} else if(i==2) {
								if(board[i-2][j] == 1)	{//winning move
								 if(maxScoreInc<100)	{
									maxScoreInc = 100;//100
									maxX = i;
									maxY = j;
									//System.out.println("Winning X Played at position: "  +i+", " +j);
								 }
								}
							}
						}
					}
					
					if(i<2)	{
						if(board[i+1][j] == 1)	{
							if(maxScoreInc<10)	{
								maxScoreInc = 10;
								maxX = i;
								maxY = j;
							}
						}
					}
				
					
					if(j>0)	{
						if(board[i][j-1] == 1)	{ //potential two in a row
					     if(maxScoreInc<10)	{
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							//System.out.println("Double X Played at position: "  +i+", " +j);
					     }
							if(j==1)	{
								if(board[i][j+1] == 1)	{//winning move
								 if(maxScoreInc<100)	{
									maxScoreInc = 100;//0;
									maxX = i;
									maxY = j;
									//System.out.println("Winning X Played at position: "  +i+", " +j);
								  }
								}
							} else if(j==2) {
								if(board[i][j-2] == 1)	{//winning move
								 if(maxScoreInc<100)	{
									maxScoreInc = 100;
									maxX = i;
									maxY = j;
									//System.out.println("Winning X Played at position: "  +i+", " +j);
								}
								}
							}
						}
					}
					
					if(j<2)	{
						if(board[i][j+1] == 1)	{
							if(maxScoreInc<10)	{
								maxScoreInc = 10;
								maxX = i;
								maxY = j;
							}
						 
						}
					}
				
					if(i == 0 && j == 0 )   {
						if(board[i+1][j+1] == 1){
						 if(maxScoreInc<10)	{
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
						 }
							if(board[i+2][j+2] == 1){
							 if(maxScoreInc<100)	{
								maxScoreInc = 100;
								maxX = i;
								maxY = j;
							 }
							}
						}
						
					}
					else if(i == 2 && j == 2 )   {
						if(board[i-1][j-1] == 1){
						 if(maxScoreInc<10)	{
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
						 }
							if(board[i-2][j-2] == 1){
							 if(maxScoreInc<100)	{
								maxScoreInc = 100;
								maxX = i;
								maxY = j;
							 }
							}
						}
						
					}
					
					else if(i == 1 && j == 1 )   {
						
						if(board[i-1][j-1] == 1)  {
						  if(maxScoreInc<10)	{
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
						  }
							
							if(board[i+1][j+1] == 1){
						     if(maxScoreInc<100)	{		
								maxScoreInc = 100;
								maxX = i;
								maxY = j;
						     }
							}
							
						}
						
						if(board[i+1][j+1] == 1){
						 if(maxScoreInc<10)	{	
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
						 }
						}
						


						
						if(board[i-1][j+1] == 1)  {
						  if(maxScoreInc<10)	{
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
						  }
							if(board[i+1][j-1] == 1){
						      if(maxScoreInc<100)	{	
								maxScoreInc = 100;
								maxX = i;
								maxY = j;
						      }
							}
							
						}
						
						if(board[i+1][j-1] == 1){
						  if(maxScoreInc<10)	{
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
						  }
						}
					}
					
			
				}
				
				
			}
		}
		////System.out.println("X Played at position: "  +maxX+", " +maxY);
		board[maxX][maxY] = 1;
		score += maxScoreInc;
		opposcore -= maxScoreInc;
		return board;
	}

	public static int[][] MinAlphaBeta(int[][] board)	{
		int move;
		int maxX = 0;
		int maxY = 0;
		int maxScoreInc = 0;
		for(int i = 0; i < 3; i++)
		{	
			for(int j = 0; j<3; j++)	{
				
				if(board[i][j]==0)	{
					if(maxScoreInc==0)	{
						maxScoreInc = 5;
						maxX=i;
						maxY=j;
						////System.out.println("X Played at position: "  +i+", " +j);
					}
					
				
					
					
					if(i>0)	{
						if(board[i-1][j] == 1)	{ //potential two in a row
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							//System.out.println("Double X Played at position: "  +i+", " +j);

							if(i==1)	{
								if(board[i+1][j] == 1)	{//winning move
									maxScoreInc = 10;//100
									maxX = i;
									maxY = j;
									//System.out.println("Winning X Played at position: "  +i+", " +j);
								}
							} else if(i==2) {
								if(board[i-2][j] == 1)	{//winning move
									maxScoreInc = 10;//100
									maxX = i;
									maxY = j;
									//System.out.println("Winning X Played at position: "  +i+", " +j);
								}
							}
						}
					}
					
					if(i<2)	{
						if(board[i+1][j] == 1)	{
							if(maxScoreInc<10)	{
								maxScoreInc = 10;
								maxX = i;
								maxY = j;
							}
						}
					}
				
					
					if(j>0)	{
						if(board[i][j-1] == 1)	{ //potential two in a row
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							//System.out.println("Double X Played at position: "  +i+", " +j);

							if(j==1)	{
								if(board[i][j+1] == 1)	{//winning move
									maxScoreInc = 10;//0;
									maxX = i;
									maxY = j;
									//System.out.println("Winning X Played at position: "  +i+", " +j);
								}
							} else if(j==2) {
								if(board[i][j-2] == 1)	{//winning move
									maxScoreInc = 10;//0;
									maxX = i;
									maxY = j;
									//System.out.println("Winning X Played at position: "  +i+", " +j);
								}
							}
						}
					}
					
					if(j<2)	{
						if(board[i][j+1] == 1)	{
							if(maxScoreInc<10)	{
								maxScoreInc = 10;
								maxX = i;
								maxY = j;
							}
						}
					}
				
					if(i == 0 && j == 0 )   {
						if(board[i+1][j+1] == 1){
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							if(board[i+2][j+2] == 1){
								maxScoreInc = 100;
								maxX = i;
								maxY = j;
							}
						}
						
					}
					else if(i == 2 && j == 2 )   {
						if(board[i-1][j-1] == 1){
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							if(board[i-2][j-2] == 1){
								maxScoreInc = 100;
								maxX = i;
								maxY = j;
							}
						}
						
					}
					
					else if(i == 1 && j == 1 )   {
						
						if(board[i-1][j-1] == 1)  {
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							
							if(board[i+1][j+1] == 1){
								maxScoreInc = 100;
								maxX = i;
								maxY = j;
							}
							
						}
						
						if(board[i+1][j+1] == 1){
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
						}
						


						
						if(board[i-1][j+1] == 1)  {
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
							
							if(board[i+1][j-1] == 1){
								maxScoreInc = 100;
								maxX = i;
								maxY = j;
							}
							
						}
						
						if(board[i+1][j-1] == 1){
							maxScoreInc = 10;
							maxX = i;
							maxY = j;
						}
					}
					
			
				}
				
				
			}
		}

		//System.out.println("X Played at position: "  +maxX+", " +maxY);
		board[maxX][maxY] = 2;
		opposcore += maxScoreInc;
		score -= maxScoreInc;
		return board;
	}
	
	
	
	public static int WinFinder(int[][] board)	{
		int winner = 0;
		int fullcount =0;
		
	
		if(board[0][0] == board[1][1] && board[2][2] == board[1][1]){
			return board[1][1];
		} else if(board[0][2]== board[1][1] && board[2][0] == board[1][1])
		{return board[1][1];}
		for(int i = 0;i<3;i++)  {
			if(board[i][1]==board[i][0] && board[i][0]==board[i][2]) {
				return board[i][1];
			}
			else if(board[1][i]==board[0][i] && board[0][i]==board[2][i]) {
				return board[1][i];
			}
		}
		
		for(int i = 0;i<3;i++)  {

			for(int j = 0;j<3;j++)  {
				if(board[i][j] != 0) {
					fullcount ++;
				}
			}
			
		}
		if(fullcount == 9)	{
			return 3;
		}
		return winner;
	}
		
		
	public static void main(String args[])	{
		
		maxXmaxer = new ArrayList<Integer>(); 
		maxYmaxer = new ArrayList<Integer>();
		maxXminer = new ArrayList<Integer>();
		maxYminer = new ArrayList<Integer>();
		int Xinput = 0;
		int Yinput = 0;
		int check = 0;

		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));	
		board = new int[3][3];
	//	System.out.print(board[0][0]);
		
		System.out.print("\n");
		System.out.println("~~~~~~~~~~~~~~~~~Start of MaxMin~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("\n");
		System.out.print("\n");

		
		
		board2 = new int[3][3];
		//	System.out.print(board[0][0]);
			
			//while(score<100){
			for(int c = 0; c<20; c++)	{
				board2 = Minimizer(board2);
				check = WinFinder(board2);
				if(check==1)	{
					System.out.print("X WINS");
					break;
				}
				if(check==2) {
					System.out.print("O WINS");
					break;
				}
				if(check == 3)	{
					System.out.print("TIE");
					break;				
				}
				
for(int i=0 ; i<3;i++)	{
	System.out.print("\n");
	System.out.print("boardMinMax[" + i+ "][0]");
	if(1 ==board2[i][0])
	{	System.out.print(" X"); }
	else if(2 ==board2[i][0])
	{	System.out.print(" O"); }
	else
	{	System.out.print("  "); }
	System.out.print("      boardMinMax[" + i+ "][1]");// + board[i][1]);
	if(1 ==board2[i][1])
	{	System.out.print(" X"); }
	else if(2 ==board2[i][1])
	{	System.out.print(" O"); }
	else
	{	System.out.print("  "); }

	System.out.print("    boardMinMax[" + i+ "][2]");// + board[i][2]);
	if(1 ==board2[i][2])
	{	System.out.print(" X"); }
	else if(2 ==board2[i][2])
	{	System.out.print(" O"); }
	else
	{	System.out.print("  "); }

}
System.out.print("\n");
System.out.print("\n");

System.out.println("Please enter the X location of your move");
try	{
	Xinput = Integer.parseInt(input.readLine());
} catch(IOException E)	{
	E.printStackTrace();
}
System.out.println("Please enter the Y location of your move");
try	{
	Yinput = Integer.parseInt(input.readLine());
} catch(IOException E)	{
	E.printStackTrace();
}
board2[Xinput][Yinput] = 1;		
check = WinFinder(board);
if(check==1)	{
	System.out.print("X WINS");
	break;
}
if(check==2) {
	System.out.print("O WINS");
	break;
}
if(check == 3)	{
	System.out.print("TIE");
	break;				
}

				
			}
			
			for(int i=0 ; i<3;i++)	{
				System.out.print("\n");
				System.out.print("boardAlphaBeta[" + i+ "][0]");
				if(1 ==board2[i][0])
				{	System.out.print(" X"); }
				else if(2 ==board2[i][0])
				{	System.out.print(" O"); }
				else
				{	System.out.print("  "); }
				System.out.print("      boardAlphaBeta[" + i+ "][1]");// + board[i][1]);
				if(1 ==board2[i][1])
				{	System.out.print(" X"); }
				else if(2 ==board2[i][1])
				{	System.out.print(" O"); }
				else
				{	System.out.print("  "); }
				System.out.print("    boardAlphaBeta[" + i+ "][2]");// + board[i][2]);
				if(1 ==board2[i][2])
				{	System.out.print(" X"); }
				else if(2 ==board2[i][2])
				{	System.out.print(" O"); }
				else
				{	System.out.print("  "); }
			}
			System.out.print("\n");
		//	System.out.println("Optimized AlphaBeta Pruning Maximizer Wins");
		
			
			
		System.out.print("\n");
		System.out.print("\n");
		System.out.println("~~~~~~~~~~~~~~~~~Start of Min Max~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("\n");
		//while(score<100){
		for(int c = 0; c<20; c++)	{
			
			
			board = Maximizer(board);		
			check = WinFinder(board);
if(check==1)	{
	System.out.print("X WINS");
	break;
}
if(check==2) {
	System.out.print("O WINS");
	break;
}
if(check == 3)	{
	System.out.print("TIE");
	break;				
}


for(int i=0 ; i<3;i++)	{
	System.out.print("\n");
	System.out.print("boardMinMax[" + i+ "][0]");
	if(1 ==board[i][0])
	{	System.out.print(" X"); }
	else if(2 ==board[i][0])
	{	System.out.print(" O"); }
	else
	{	System.out.print("  "); }
	System.out.print("      boardMinMax[" + i+ "][1]");// + board[i][1]);
	if(1 ==board[i][1])
	{	System.out.print(" X"); }
	else if(2 ==board[i][1])
	{	System.out.print(" O"); }
	else
	{	System.out.print("  "); }

	System.out.print("    boardMinMax[" + i+ "][2]");// + board[i][2]);
	if(1 ==board[i][2])
	{	System.out.print(" X"); }
	else if(2 ==board[i][2])
	{	System.out.print(" O"); }
	else
	{	System.out.print("  "); }

}
System.out.print("\n");
System.out.print("\n");

System.out.println("Please enter the X location of your move");
try	{
	Xinput = Integer.parseInt(input.readLine());
} catch(IOException E)	{
	E.printStackTrace();
}
System.out.println("Please enter the Y location of your move");
try	{
	Yinput = Integer.parseInt(input.readLine());
} catch(IOException E)	{
	E.printStackTrace();
}
board[Xinput][Yinput] = 2;
			//board = Minimizer(board);

			check = WinFinder(board);
			if(check==1)	{
				System.out.print("X WINS");
				break;
			}
			if(check==2) {
				System.out.print("O WINS");
				break;
			}
			if(check == 3)	{
				System.out.print("TIE");
				break;				
			}
			

		}
		
		for(int i=0 ; i<3;i++)	{
			System.out.print("\n");
			System.out.print("boardMinMax[" + i+ "][0]");
			if(1 ==board[i][0])
			{	System.out.print(" X"); }
			else if(2 ==board[i][0])
			{	System.out.print(" O"); }
			else
			{	System.out.print("  "); }
			System.out.print("      boardMinMax[" + i+ "][1]");// + board[i][1]);
			if(1 ==board[i][1])
			{	System.out.print(" X"); }
			else if(2 ==board[i][1])
			{	System.out.print(" O"); }
			else
			{	System.out.print("  "); }

			System.out.print("    boardMinMax[" + i+ "][2]");// + board[i][2]);
			if(1 ==board[i][2])
			{	System.out.print(" X"); }
			else if(2 ==board[i][2])
			{	System.out.print(" O"); }
			else
			{	System.out.print("  "); }

		}
		System.out.print("\n");
		System.out.print("\n");
if(check==0) {
		System.out.println("MinMax Simulation ends in a tie");
} else if(check ==1) {
	System.out.println("MinMax Simulation ends in a Maximizer Victory");
}else if(check==2)	{
	System.out.println("MinMax Simulation ends in a Minimizer Victory");

}

		
		

	}
	
}
	
