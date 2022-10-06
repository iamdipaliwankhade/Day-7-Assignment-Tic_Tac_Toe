package com.tictactoe;

import java.util.Scanner;

/**
 * 
 * @author Dipali
 *
 */
public class TicTacToe {

	static char[] board = new char[10];

	/**
	 * @description
	 * 
	 */
	static void createBoard() {
		System.out.println("TicTacToe game board");
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
	}

	/**
	 * @taking input from user to choose the turn
	 */
	static void chooseLetter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the character X or O to choose the turn:");
		char ch = sc.next().charAt(0);
		if (ch == 'X' || ch == 'x') {
			System.out.println("player's turn to play the game");
		} else if (ch == 'O' || ch == 'o') {
			System.out.println("computer's turn to play the game");
		} else {
			System.out.println("Invalid input");
		}

	}
public static void main(String args[]) {
		
		createBoard();
		chooseLetter();
		
	}
}		