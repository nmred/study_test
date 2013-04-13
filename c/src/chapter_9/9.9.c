#include <stdio.h>
#include <stdbool.h>
#include <ctype.h>
#include <string.h>

const int SIZE = 4;
const char comp_c = '@';
const char player_c = 'O';

void display(char board[][SIZE]);
int valid_moves(char board[][SIZE], bool moves[][SIZE], char player);
void make_move(char board[][SIZE], int row, int col, char player);
void computer_move(char board[][SIZE], bool moves[][SIZE], char player);
int get_score(char board[][SIZE], char player);
int best_move(char board[][SIZE], bool moves[][SIZE], char player);

// {{{ main

/**
 * main  
 */
int main(void)
{
	char board [SIZE][SIZE];
	bool moves [SIZE][SIZE];
	int row = 0;
	int col = 0;
	int no_of_moves = 0;
	int no_of_games = 0;
	int invalid_moves = 0;
	int comp_score = 0;
	int user_score = 0;
	int again = 0;
	bool next_player = true;
	int x = 0;
	int y = 0;

	printf("\nREVERSI\n");
	printf("You can go first on the first game, then we will take turns.\n");
	printf("You will be write - (%c) \n I will be black - (%c).\n", player_c, comp_c);
	printf("select a square for your move by typing a digit for the row\n and a letter for the column with no spaces between.\n");
	printf("\nGood luck! Press Enter to start.\n");

	do {
		next_player = !next_player;
		no_of_moves = 4;	

		for (row = 0; row < SIZE; row++) {
			for (col = 0; col < SIZE; col++) {
				board[row][col] = ' ';	
				moves[row][col] = false;
			}
		}	

		int mid = SIZE / 2;
		board[mid - 1][mid - 1] = board[mid][mid] = player_c;
		board[mid - 1][mid] = board[mid][mid - 1] = comp_c;

		//loop
		do {
			if (next_player = !next_player) {
				// user		
				if (valid_moves(board, moves, player_c)) {
					for (;;) {
						display(board);
						printf("please enter your move (row column):");
						scanf(" %d%c", &x, &y);
						y = tolower(y) - 'a';
						x--;
						if (x >= 0 && y >= 0 && x < SIZE && y < SIZE && moves[x][y]) {
							make_move(board, x, y, player_c);
							no_of_moves++;
							break;	
						} else {
							printf("Not a valid move, try again.\n");	
						}
					}
				} else {
					if (++invalid_moves < 2) {
						printf("\n You have to pass, press return");
						scanf("%c", &again);	
					} else {
						printf("\n Neither of us can go, so the game is over.\n");	
					}
				}
			} else {
				// compter
				if (valid_moves(board, moves, comp_c)) {
					invalid_moves = 0;
					computer_move(board, moves, comp_c);
					no_of_moves++;
				} else {
					if (++invalid_moves < 2) {
						printf("\n You have to pass, press return");
					} else {
						printf("\n Neither of us can go, so the game is over.\n");	
					}
				}
			}
		} while(no_of_moves < SIZE * SIZE && invalid_moves < 2);

		display(board);

		comp_score = user_score = 0;
		for (row = 0; row < SIZE; row++) {
			for (col = 0; col < SIZE; col++) {
				comp_score += (board[row][col] == comp_c);
				user_score += (board[row][col] == player_c);
			}
		}

		printf("The final score is:\n");
		printf("Computer %d\n User %d\n\n", comp_score, user_score);
		printf("Do you want to play again (y/n):");
		scanf("%c", &again);
	} while(tolower(again) == 'y');
	
	printf("\nGoodBye\n");
	return 0;
}

// }}}
// {{{ display

/**
 * 显示棋盘 
 */
void display(char board[][SIZE])
{
	char col_label = 'a';
	printf("\n");
	for (int col = 0; col < SIZE; col++) {
		printf("   %c", col_label + col);	
	}
	printf("\n");

	for (int row = 0; row < SIZE; row++) {
		printf("  +");
		for (int col = 0; col < SIZE; col++) {
			printf("---+");	
		}
		printf("\n%2d|", row + 1);

		for (int col = 0; col < SIZE; col++) {
			printf(" %c |", board[row][col]);
		}
		printf("\n");	
	}

	printf("  +");
	for (int col = 0; col < SIZE; col++) {
		printf("---+");	
	}
	printf("\n");
}
// }}}
// {{{ valid_moves

/**
 * 获取有效的移动 
 */
int valid_moves(char board[][SIZE], bool moves[][SIZE], char player)
{
	int rowdelta = 0;
	int coldelta = 0;
	int x = 0; // 搜索的行 index
	int y = 0; //搜索的列 index	
	int no_of_moves = 0; // 合法的走法个数

	char oppopnent = (player == player_c) ? comp_c : player_c;

	for (int row = 0; row < SIZE; row++) {
		for (int col = 0; col < SIZE; col++) {
			moves[row][col] = false;	
		}	
	}

	for (int row = 0; row < SIZE; row++) {
		for (int col = 0; col < SIZE; col++) {
			if (board[row][col] != ' ') {
				continue;	
			}

			for (rowdelta = -1; rowdelta <= 1; rowdelta++) {
				for (coldelta = -1; coldelta <= 1; coldelta++) {
					if (row + rowdelta < 0 || row + rowdelta >= SIZE ||
						col + coldelta < 0 || col + coldelta >= SIZE ||
						(rowdelta == 0 && coldelta == 0)) {
						continue;	
					}	

					if (oppopnent == board[row + rowdelta][col + coldelta]) {
						x = row + rowdelta;
						y = col + coldelta;
						for (;;) {
							x += rowdelta;
							y += coldelta;
							if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
								break;	
							}

							if (board[x][y] == ' ') {
								break;	
							}

							if (board[x][y] == player) {
								moves[row][col] = true;
								no_of_moves++;
								break;	
							}
						}
					}
				}	
			}
		}	
	}

	return no_of_moves;
}

// }}}
// {{{ make_move

/**
 * 为用户下子 
 */
void make_move(char board[][SIZE], int row, int col, char player)
{
	int rowdelta = 0;
	int coldelta = 0;
	int x = 0; // 搜索的行 index
	int y = 0; //搜索的列 index	

	char oppopnent = (player == player_c) ? comp_c : player_c;

	board[row][col] = player;

	for (rowdelta = -1; rowdelta <= 1; rowdelta++) {
		for (coldelta = -1; coldelta <= 1; coldelta++) {
			if (row + rowdelta < 0 || row + rowdelta >= SIZE ||
				col + coldelta < 0 || col + coldelta >= SIZE ||
				(rowdelta == 0 && coldelta == 0)) {
				continue;	
			}	

			if (oppopnent == board[row + rowdelta][col + coldelta]) {
				x = row + rowdelta;
				y = col + coldelta;
				for (;;) {
					x += rowdelta;
					y += coldelta;
					if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
						break;	
					}

					if (board[x][y] == ' ') {
						break;	
					}

					if (board[x][y] == player) {
						while (board[x -= rowdelta][y -= coldelta] == oppopnent) {
							board[x][y] = player;	
						}
						break;	
					}
				}
			}
		}	
	}
}

// }}}
// {{{ get_score()

/**
 * 获取分数 
 */
int get_score(char board[][SIZE], char player)
{
	int score = 0;

	char oppopnent = (player == player_c) ? comp_c : player_c;

	for (int row = 0; row < SIZE; row++) {
		for (int col = 0; col < SIZE; col++) {
			score -= (board[row][col] == oppopnent);
			score += (board[row][col] == player);
		}	
	}

	return score;
}

// }}}
// {{{ best_move()

/**
 * 获取最好的走法 
 */
int best_move(char board[][SIZE], bool moves[][SIZE], char player)
{
	char oppopnent = (player == player_c) ? comp_c : player_c;
	char new_board[SIZE][SIZE];
	int score = 0;
	int new_score = 0;

	for (int row = 0; row < SIZE; row++) {
		for (int col = 0; col < SIZE; col++) {
			if (!moves[row][col]) {
				continue;	
			}

			memcpy(new_board, board, sizeof(new_board));

			make_move(new_board, row, col, player);

			new_score = get_score(new_board, player);
			if (score < new_score) {
				score = new_score;	
			}
		}
	}

	return score;
}

// }}}
// {{{ computer_move()

/**
 * 计算机下子 
 */
void computer_move(char board[][SIZE], bool moves[][SIZE], char player)
{
	int best_row = 0;
	int best_col = 0;
	int new_score = 0;
	int score = 100;
	char temp_board[SIZE][SIZE];
	bool temp_moves[SIZE][SIZE];

	char oppopnent = (player == player_c) ? comp_c : player_c;
	for (int row = 0; row < SIZE; row++) {
		for (int col = 0; col < SIZE; col++) {
			if (!moves[row][col]) {
				continue;	
			}	

			memcpy(temp_board, board, sizeof(temp_board));
			make_move(temp_board, row, col, player);

			valid_moves(temp_board, temp_moves, oppopnent);

			new_score = best_move(temp_board, temp_moves, oppopnent);

			if (new_score < score) {
				score = new_score;	
				best_row = row;
				best_col = col;
			}
		}
	}

	make_move(board, best_row, best_col, player);
}

// }}}
