package com.tictactoe;

import java.util.Scanner;

/**
 * 
 * @author Dipali
 *
 */
public class TicTacToe {

	static char[] board = new char[10];
	static char turn;

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

	/**
	 * user is going to make a move to the desired location
	 */
	public static void checkMove() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your slot number from 1 to 9: ");
		int userInput = sc.nextInt();
	}

	/**
	 * checking for the free spaces in the board
	 */
	public static void madeMove() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter your slot number from 1 to 9: ");
			int userInput = sc.nextInt();
			if (!(userInput > 0) && (userInput < 10)) {
				System.out.println("Invalid move, Re-enter the slot number:");
				continue;
			} else if (board[userInput] == ' ') {
				board[userInput] = turn;
				showBoard();
				if (turn == 'X') {
					turn = 'O';
				} else {
					turn = 'X';
				}
			} else {
				System.out.println("Re-enter the slot number: ");
				showBoard();
				continue;
			}
		}
	}

	public static void main(String args[]) {

		createBoard();
		chooseLetter();
		showBoard();
		madeMove();

	}
}