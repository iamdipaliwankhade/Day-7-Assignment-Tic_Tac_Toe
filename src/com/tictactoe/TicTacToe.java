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
	static String winner = null;
	static int userInput;

	/**
	 * Creating the game board
	 * 
	 */
	private static void createBoard() {
		System.out.println("TicTacToe game board");
		for (int i = 1; i < 10; i++) {
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
			System.out.println("Computer's turn to play the game");
			turn = 'O';
		} else if (turn == 'O' || turn == 'o') {
			System.out.println("Player's turn to play the game");
			turn = 'X';
		} else {
			System.out.println("Invalid input");
		}

	}

	/**
	 * Displaying the tictactoe game board
	 */
	private static void showBoard() {
		for (int i = 1; i < 10; i++) {
			board[i] = (char) i;
		}
		System.out.println("| " + board[1] + "_|_" + board[2] + "_|_" + board[3] + " |");
		System.out.println("| " + board[4] + "_|_" + board[5] + "_|_" + board[6] + " |");
		System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");

	}

	/**
	 * user has already made a move
	 */
	private static void madeMove(boolean firstPlayer) {
		Scanner sc = new Scanner(System.in);
		if (firstPlayer == true) {
			turn = 'X';
		} else {
			turn = 'O';
		}
		while (winner == null) {
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
				winner = checkWiningCombinations();

			} else {
				System.out.println("Slot is taken already; Re-enter the slot number: ");
				showBoard();
				continue;
			}
		}

		if (winner.equalsIgnoreCase("tie")) {
			System.out.println("It's a tie| Thanks for playing");
		} else {
			System.out.println("Congratulations! " + winner + " has won.");
		}
	}

	/**
	 * Tossing the coin to check who plays first
	 */
	private static boolean tossToStartGame() {
		Random random = new Random();
		return random.nextBoolean();
	}

	/**
	 * Checking after move the winner or the tie or change in turn
	 */
	private static String checkWiningCombinations() {
		for (int a = 1; a < 9; a++) {
			StringBuilder sb = new StringBuilder();
			String line;

			switch (a) {
			case 1:
				line = Character.toString(board[1] + board[2] + board[3]);
				break;
			case 2:
				line = Character.toString(board[4] + board[5] + board[6]);
				break;
			case 3:
				line = Character.toString(board[7] + board[8] + board[9]);
				break;
			case 4:
				line = Character.toString(board[1] + board[4] + board[7]);
				break;
			case 5:
				line = Character.toString(board[2] + board[5] + board[8]);
				break;
			case 6:
				line = Character.toString(board[3] + board[6] + board[9]);
				break;
			case 7:
				line = Character.toString(board[1] + board[5] + board[9]);
				break;
			case 8:
				line = Character.toString(board[3] + board[5] + board[7]);
				System.out.println("String is: " + line);
				break;

			}
			if (sb.equals("XXX")) {
				return "Computer";
			} else if (sb.equals("OOO")) {
				return "Player";
			}
		}
		for (int i = 1; i < 10; i++) {
			if (board[i] == ' ') {
				break;
			} else if (i == 9)
				return "tie";

		}
		System.out.println(turn + "turn; enter a slot number to place the " + turn + " in: ");
		return null;

	}

	/**
	 * checking to move for win or tie or change the turn
	 */
	private static void computerCheckToWin() {
		board[turn] = 'X';
	}

	/**
	 * @param userInput is taking the arguments of the row, column and diagonals
	 *                  Checking that opponent can win then can block it's win
	 */
	private static int blockOpponent(int userInput) {
		for (int a = 1; a < 9; a++) {
			String str;
			switch (a) {
			case 1: {
				str = Character.toString(board[1]) + Character.toString(board[2]) + Character.toString(board[3]);
				if (str == "XX") {
					for (int i = 1; i <= 3; i++) {
						if (board[i] == ' ') {
							turn = 'O';
							userInput = i;
							return userInput;
						}
					}
				}
				break;
			}

			case 2: {
				str = Character.toString(board[4]) + Character.toString(board[5]) + Character.toString(board[6]);
				if (str == "XX") {
					for (int i = 4; i <= 6; i++) {
						if (board[i] == ' ') {
							turn = 'O';
							userInput = i;
							return userInput;
						}
					}
				}
				break;
			}

			case 3: {
				str = Character.toString(board[7]) + Character.toString(board[8]) + Character.toString(board[9]);
				if (str == "XX") {
					for (int i = 7; i < 9; i++) {
						if (board[i] == ' ') {
							turn = 'O';
							userInput = i;
							return userInput;
						}
					}
				}
				break;
			}

			case 4: {
				str = Character.toString(board[1]) + Character.toString(board[4]) + Character.toString(board[7]);
				if (str == "XX") {
					for (int i = 1; i <= 7; i += 3) {
						if (board[i] == ' ') {
							turn = 'O';
							userInput = i;
							return userInput;
						}
					}
				}
				break;
			}

			case 5: {
				str = Character.toString(board[2]) + Character.toString(board[5]) + Character.toString(board[8]);
				if (str == "XX") {
					for (int i = 2; i <= 8; i += 3) {
						if (board[i] == ' ') {
							turn = 'O';
							userInput = i;
							return userInput;
						}
					}
				}
				break;
			}

			case 6: {
				str = Character.toString(board[3]) + Character.toString(board[6]) + Character.toString(board[9]);
				if (str == "XX") {
					for (int i = 3; i <= 9; i += 3) {
						if (board[i] == ' ') {
							turn = 'O';
							userInput = i;
							return userInput;
						}
					}
				}
				break;
			}

			case 7: {
				str = Character.toString(board[1]) + Character.toString(board[5]) + Character.toString(board[9]);
				if (str == "XX") {
					for (int i = 1; i <= 9; i += 4) {
						if (board[i] == ' ') {
							turn = 'O';
							userInput = i;
							return userInput;
						}
					}
				}
				break;
			}

			case 8: {
				str = Character.toString(board[3]) + Character.toString(board[5]) + Character.toString(board[7]);
				if (str == "XX") {
					for (int i = 3; i <= 7; i += 2) {
						if (board[i] == ' ') {
							turn = 'O';
							userInput = i;
							return userInput;
						}
					}
				}
				break;
			}
			}
		}
		return userInput;
	}

	/**
	 * If no one is winning then taking corner slots
	 */
	private static void winnerCondition() {
		if (winner == null) {
			if (board[1] == ' ') {
				userInput = 1;
				return;
			} else if (board[3] == ' ') {
				userInput = 3;
				return;
			} else if (board[7] == ' ') {
				userInput = 7;
				return;
			} else if (board[9] == ' ') {
				userInput = 9;
				return;
			}
		} else if (winner == "Player") {
			computerCheckToWin();
			winner = null;
		}
	}

	public static void main(String args[]) {

		createBoard();
		chooseLetter();
		showBoard();
		madeMove(true);
	}
}