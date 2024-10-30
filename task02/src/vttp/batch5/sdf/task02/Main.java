package vttp.batch5.sdf.task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static String[][] board = new String[3][3];
	static String PLAYER = "X";
	static String AI = "O";

	public static void main(String[] args) throws Exception {

		// System.out.printf("hello, world\n");
		// task02/TTT/board0.txt
		if (args.length < 1 ) {
			System.out.println("Please provide TTT configuration file.");
		} 

		String dirPathFileName = args[0];
		FileReader reader = new FileReader(dirPathFileName);
		BufferedReader br = new BufferedReader(reader);

		// initializeBoard();
		// printBoard();

		String[][] board = new String[3][3];
		// save it to a variable that we can access
		List<String[]> saveTheChars = new ArrayList<>();

		String line;
		while ((line = br.readLine()) != null) {
			// line = line.replace("", " ").trim();
			// line = line.trim().split("(?!^)");
			// String[] characters = line.split(" ");
			String[] characters = line.split("(?!^)");

			// // need to do this in a loop
			// for(int i = 0; i < 3 ; i ++) {
			// for (int j = 0; j < 3; j++) {
			// board[i][j] = characters[j];

			// }
			// }
			saveTheChars.add(characters);

		}

		// to get and assign the characters to the board
		String[] firstLineInput = saveTheChars.get(0);
		String[] secondLineInput = saveTheChars.get(1);
		String[] thirdLineInput = saveTheChars.get(2);

		board[0][0] = firstLineInput[0];
		board[0][1] = firstLineInput[1];
		board[0][2] = firstLineInput[2];
		board[1][0] = secondLineInput[0];
		board[1][1] = secondLineInput[1];
		board[1][2] = secondLineInput[2];
		board[2][0] = thirdLineInput[0];
		board[2][1] = thirdLineInput[1];
		board[2][2] = thirdLineInput[2];

		System.out.print(Arrays.deepToString(board));
		findLegalPlaces(board);

		br.close();

		// need to find the legal places
		// legal places have "."

	}

	static void findLegalPlaces(String[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == ".") {
					System.out.println("Row:  " + i + " Col: " + j + " is legal");
				} else {
					System.out.println("No legal places");
				}
			}
		}

	}

	static void determineUtility(String[][] board, String player) {


	}

	static boolean checkWin(String player) {
		// Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true; // rows
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true; // columns
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true; // down diagonal
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true; // up diagonal
        return false;
	}


	static void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ".";
			}
		}
	}

	static void printBoard() {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

}
