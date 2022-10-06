package com.tictactoe;

import java.util.Random;
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
	private static void showBoard() {
		for (int i = 1; i < board.length; i++) {
			board[i] = (char) i;
		}
		System.out.println("_" + board[1] + "_|_" + board[2] + "_|_" + board[3] + "_");
		System.out.println("_" + board[4] + "_|_" + board[5] + "_|_" + board[6] + "_");
		System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9] + " ");

	}

	/**
	 * user has already made a move
	 */
	private static void madeMove() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter your slot number from 1 to 9: ");
			int move = sc.nextInt();
			if (!(move > 0) && (move < 10)) {
				System.out.println("Invalid move, Re-enter the slot number:");
				continue;
			} else if (board[move] == ' ') {
				board[move] = turn;
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

	/**
	 * Tossing the coin to check who plays first
	 */
	private static boolean tossToStartGame() {
		Random random = new Random();
		return random.nextBoolean();
	}

	public static void main(String args[]) {

		createBoard();
		chooseLetter();
		showBoard();
		madeMove();

	}
}
