import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class white {

	private static final String FILENAME = "C:\\Users\\Johnny Tsao\\eclipse-workspace\\Reversi\\src\\test.txt";

	public static void storeData(final int[][] board) {

		BufferedWriter bw = null;
		FileWriter fw = null;
		System.out.println("data stored");
		String data = "";
		for (int k = 0; k < 8; k++) {
			for (int j = 0; j < 8; j++) {
				data += board[k][j];
				data += "\r\n";
			}
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));
			writer.write(data);
			writer.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static void main(String[] args) {

		java.util.Scanner number = new java.util.Scanner(System.in);
		java.util.Scanner numeral = new java.util.Scanner(System.in);
		boolean player1 = true;
		int n, i;
		int total = 0;
		int countw = 0;
		int countb = 0;
		int[][] board = new int[8][8];
		boolean begin = false;
		boolean cando = true;
		if (begin == false) {
			for (int k = 0; k < 8; k++) {
				for (int j = 0; j < 8; j++) {
					board[k][j] = 0;
				}
			}
			board[3][3] = 1;
			board[3][4] = -1;
			board[4][4] = 1;
			board[4][3] = -1;
			begin = true;
		}
		for (int k = 0; k < 8; k++) {
			for (int j = 0; j < 8; j++) {
				System.out.println(board[k][j]);
			}
		}
		storeData(board);
		while (player1 == true) {
			n = number.nextInt();
			i = numeral.nextInt();
			cando = true;
			if (board[n][i] != 0) {
				cando = false;
			}
			if (board[n][i + 1] != -1 && board[n][i - 1] != -1 && board[n + 1][i] != -1 && board[n - 1][i] != -1
					&& i + 1 <= 8 && i - 1 >= 0 && n - 1 >= 0 && n + 1 <= 8 && board[n + 1][i + 1] != -1 && board[n - 1][i -1] != -1
							&& board[n + 1][i - 1] != -1 && board[n - 1][i + 1] != -1) {
				cando = false;
			}
			if (cando == true) {
				
				boolean change = false;
				int k = 0;
				while (n + k <= 7 && i + k <= 7) {
					if(board[n + k + 1][i + k + 1] == 0) {
						break;
					}
					if (board[n + k][i + k] == 1) {
						for (int j = 1; j <= k; j++) {
							if (board[n + j][i + j] == -1) {
								change = true;
								board[n][i] = 1;
							}
							if (board[n + j][i + j] == -1) {
								board[n + j][i + j] = 1;
							}
							if (board[n + j][i + j] == 0) {
								board[n + j][i + j] = 0;
							}
							countw++;
						}
					}
					k++;
				}

				// 左下角

				k = 0;
				while (n - k >= 0 && i - k >= 0) {
					if(board[n - k -1][i - k - 1] == 0) {
						break;
					}
					if (board[n - k][i - k] == 1) {
						for (int j = 1; j <= k; j++) {
							if (board[n - j][i - j] == -1) {
								change = true;
								board[n][i] = 1;
							}
							if (board[n - j][i - j] == -1) {
								board[n - j][i - j] = 1;
							}
							if(board[n - j][i - j] == 0) {
								board[n - j][i - j] = 0;
							}
							countw++;
						}
					}
					k++;
				}

				// 右下角
				k = 0;
				while (n + k <= 7 && i - k >= 0) {
					if(board[n + k + 1][i - k - 1] == 0) {
						break;
					}
					if (board[n + k][i - k] == 1) {
						for (int j = 1; j <= k; j++) {
							if (board[n + j][i - j] == -1) {
								change = true;
								board[n][i] = 1;
							}
							if(board[n + j][i - j] == -1) {
								board[n + j][i - j] = 1;
							}
							if(board[n + j][i - j] == 0) {
								board[n + j][i - j] = 0;
							}
							countw++;
						}
					}
					k++;
				}

				// 左上角
				k = 0;
				while (n - k >= 0 && i + k <= 7) {
					if(board[n - k - 1][i + k + 1] == 0) {
						break;
					}
					if (board[n - k][i + k] == 1) {
						for (int j = 1; j <= k; j++) {
							if (board[n - j][i + j] == -1) {
								change = true;
								board[n][i] = 1;
							}
							if(board[n - j][i + j] == -1) {
								board[n - j][i + j] = 1;
							}
							if(board[n - j][i + j] == 0) {
								board[n - j][i + j] = 0;
							}
						
							countw++;
						}
					}
					k++;
				}
				for (k = i; k <= 7; k++) {
					if(board[n][i + 1] == 0) {
						break;
					}
					if (board[n][k] == 1) {
						for (int z = i + 1; z <= k; z++) {
							if (board[n][z] == -1) {
								change = true;
								board[n][i] = 1;
							}
							if(board[n][z] == -1) {
								board[n][z] = 1;
							}
							if(board[n][z] == 0) {
								board[n][z] = 0;
							}
							countw++;
						}
					}
				}
				for (int j = n ; j <= 7; j++) {
					if(board[n + 1][i] ==0) {
						break;
					}
					if (board[j][i] == 1) {
						for (int z = n + 1; z <= j; z++) {
							if (board[z][i] == -1) {
								change = true;
								board[n][i] = 1;
							}
							if(board[z][i] == -1) {
								board[z][i] = 1;
							}
							if(board[z][i] == 0) {
								board[z][i] = 0;
							}
							
							countw++;
						}
					}
				}
				for (k = i; k >= 0; k--) {
					if(board[n][i - 1] == 0) {
						break;
					}
					if (board[n][k] == 1) {
						for (int z = i - 1; z >= k; z--) {
							if (board[n][z] == -1) {
								change = true;
								board[n][i] = 1;
							}
							if(board[n][z] == -1) {
								board[n][z] = 1;
							}
							if(board[n][z] == 0) {
								board[n][z] = 0;
							}
							
							countw++;
						}
					}
				}
				for (int j = n; j >= 0; j--) {
					if(board[n - 1][i] == 0) {
						break;
					}
					if (board[j][i] == 1) {
						for (int z = n - 1; z >= j; z--) {
							if (board[z][i] == -1) {
								change = true;
								board[n][i] = 1;
							}
							if(board[z][i] == -1) {
								board[z][i] = 1;
								
							}
							if(board[z][i] == 0) {
								board[z][i] = 0;
							}
							
							countw++;
						}
					}
				}
				if (change == true && cando == true) {
					for (k = 0; k < 8; k++) {
						for (int j = 0; j < 8; j++) {
							System.out.printf("%2d",board[k][j]);
							System.out.print(" ");
							player1 = false;
						}
						System.out.println("");
					}
					total += 1;
					if (total >= 60) {
						break;
					}
				}
				if (change == false && cando == true) {
					board[n][i] = 0;
					for (k = 0; k < 8; k++) {
						for (int j = 0; j < 8; j++) {
							System.out.printf("%2d",board[k][j]);
							System.out.print(" ");
						}
						System.out.println("");
					}
					player1 = true;
				}
				storeData(board);
			}
			if (cando == false) {
				System.out.println("nope");
				player1 = true;
				int count = 0;
				count += 1;
				if (count >= 3) {
					player1 = false;
				}
			}

			while (player1 == false) {
				boolean change = false;
				n = number.nextInt();
				i = numeral.nextInt();
				cando = true;
				if (board[n][i] != 0) {
					cando = false;
				}
				if (board[n][i + 1] != 1 && board[n][i - 1] != 1 && board[n + 1][i] != 1 && board[n - 1][i] != 1
						&& i + 1 <= 8 && i - 1 >= 0 && n - 1 >= 0 && n + 1 <= 8 && board[n + 1][i + 1] != 1 && board[n - 1][i -1] != 1
								&& board[n + 1][i - 1] != 1 && board[n - 1][i + 1] != 1) {
					cando = false;
				}
				if (cando == true) {
					int k = 0;
					while (n + k <= 7 && i + k <= 7) {
						if (board[n + k][i + k] == -1) {
							for (int j = 0; j <= k; j++) {
								if (board[n + j][i + j] == 1) {
									change = true;
								}
								if(board[n + j][i + j] == 1) {
									board[n + j][i + j] = -1;
								}
								if(board[n + j][i + j] == 0) {
									board[n][i] = -1;
									break;
								}
								board[n + j][i + j] = -1;
								countb++;
							}
						}
						k++;
					}

					// 左下角

					k = 0;
					while (n - k >= 0 && i - k >= 0) {
						if (board[n - k][i - k] == 1) {
							for (int j = 0; j <= k; j++) {
								if (board[n - j][i - j] == 1) {
									change = true;
								}
								board[n - j][i - j] = -1;
								countb++;

							}
						}
						k++;
					}

					// 右下角
					k = 0;
					while (n + k <= 7 && i - k >= 0) {
						if (board[n + k][i - k] == 1) {
							for (int j = 0; j <= k; j++) {
								if (board[n + j][i - j] == 1) {
									change = true;
								}
								board[n + j][i - j] = -1;
								countb++;

							}
						}
						k++;
					}

					// 左上角
					k = 0;
					while (n - k >= 0 && i + k <= 7) {
						if (board[n - k][i + k] == 1) {
							for (int j = 0; j <= k; j++) {
								if (board[n - j][i + j] == 1) {
									change = true;
								}
								board[n - j][i + j] = -1;
								countb++;

							}
						}
						k++;
					}
					for (k = i; k <= 7; k++) {
						if (board[n][k] == -1) {
							for (int z = i; z <= k; z++) {
								if (board[n][z] == 1) {
									change = true;
								}
								board[n][z] = -1;
								countb++;

							}
						}
					}
					for (int j = n; j <= 7; j++) {
						if (board[j][i] == -1) {
							for (int z = n; z <= j; z++) {
								if (board[z][i] == 1) {
									change = true;
								}
								board[z][i] = -1;
								countb++;

							}
						}
					}
					for (k = i; k >= 0; k--) {
						if (board[n][k] == -1) {
							for (int z = i; z >= k; z--) {
								if (board[n][z] == 1) {
									change = true;
								}
								board[n][z] = -1;
								countb++;

							}
						}
					}

					for (int j = n; j >= 0; j--) {
						if (board[j][i] == -1) {

							for (int z = n; z >= j; z--) {
								if (board[z][i] == 1) {
									change = true;
								}
								board[z][i] = -1;
								countb++;

							}
						}

					}

				}
				if (change == true && cando == true) {
					for (int k = 0; k < 8; k++) {
						for (int j = 0; j < 8; j++) {
							System.out.printf("%2d",board[k][j]);
							System.out.print(" ");

						}
						System.out.println("");
					}
					player1 = true;
					total += 1;
					if (total >= 60) {
						break;
					}
				}
				if (change == false && cando == true) {
					board[n][i] = 0;
					for (int k = 0; k < 8; k++) {
						for (int j = 0; j < 8; j++) {
							System.out.printf("%2d",board[k][j]);
							System.out.print(" ");

						}
						System.out.println("");
					}
					player1 = false;

				}
				storeData(board);
				if (cando == false) {
					System.out.println("nope");
					if (total >= 60) {
						break;
					}
				}

			}
			if (total >= 60) {
				break;
			}
		}
		System.out.println("game end");
		System.out.println("white's point:");
		System.out.println(countw);
		System.out.println("black's point");
		System.out.println(countb);
	}
}