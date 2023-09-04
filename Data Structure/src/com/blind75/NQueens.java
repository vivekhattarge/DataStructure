package com.blind75;

import java.util.ArrayList;
import java.util.List;

class NQueens {
	 
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> ans = new ArrayList<>();

		char [][] board = new char[n][n];
		for(int i=0;i<n;i++){
			for(int j=0; j<n;j++){
				board[i][j]='.';
			}
		}
		help(0,ans,board);

		return ans;
	}

	public static void help(int row,List<List<String>> ans,char [][] board){
			if(row ==board.length){
				ans.add( construct(board));
				return;
			}
			for(int j=0; j<board.length;j++){
			if(NQueens.isSafe(row, j, board)){
					board [row][j] = 'Q';
					help(row+1,ans,board);
					board[row][j] = '.';
			}
			}
}

public static List<String> construct(char [][] board){
		List<String> res = new ArrayList<>();
		for(int i=0;i<board.length;i++){
				String temp = new String(board[i]);
				res.add(temp);
		}
		return res;
}

public static boolean isSafe(int i,int j,char [][] board){

		//left upward direction
		int x=i;
		int y=j;
		while(x>=0&&y>=0){
			if(board[x][y] == 'Q'){
				return false;
			}
			x--;
			y--;
		}	

		//upward direction
		x=i;
		y=j;
		while(x>=0){
			if (board[x][y] == 'Q') return false;
			x--;
		}	

	//right upward direction
		x=i;
		y=j;
		while(x>=0 && y<board.length){
			if(board[x][y] == 'Q'){
				return false;
			}
			x--;
			y++;
		}
	return true;
}
	public static void main(String args[]) {
		int N = 4;
		List < List < String >> queen = solveNQueens(N);
		int i = 1;
		for (List < String > it: queen) {
			System.out.println("Arrangement " + i);
			for (String s: it) {
				System.out.println(s);
			}
			System.out.println();
			i += 1;
		}

	}

}