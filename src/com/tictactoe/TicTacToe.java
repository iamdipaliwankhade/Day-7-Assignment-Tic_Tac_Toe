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
	 * Creating the game board
	 * 
	 */
	private static void createBoard() {
		System.out.println("TicTacToe game board");
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
	}

	/**
	 * taking input from user to choose the turn
	 */
	private static void chooseLetter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the character X or O to choose the turn:");
		char turn = sc.next().charAt(0);
		if (turn == 'X' || turn == 'x') {
			System.out.println("player's turn to play the game");
			turn = 'O';
		} else if (turn == 'O' || turn == 'o') {
			System.out.println("computer's turn to play the game");
			turn = 'X';
		} else {
			System.out.println("Invalid input");
		}

	}

	/**
	 * Displaying the tictactoe game board
	 */
	public static void showBoard() {

		System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");

	}

	public static void main(String args[]) {

		createBoard();
		chooseLetter();
		showBoard();

	}
}