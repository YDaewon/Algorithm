#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <wchar.h>
#include "libs/bridge.h"

#pragma warning(disable : 4996)
#pragma comment(lib, "ws2_32.lib")

#define MAX_ROWS 100    // 최대 행 수 (입력 데이터 최대 행 수)
#define MAX_COLS 100    // map에서 각 행의 최대 열 수
#define MAX_LEN 10      // 각 문자열의 최대 길이
#define MAX_ALLY 100    // ally 배열의 최대 크기
#define MAX_ENEMY 100   // enemy 배열의 최대 크기
#define MAX_CODE 100    // code 배열의 최대 크기

// 전역 변수 선언
int map_height, map_width, num_of_allies, num_of_enemies, num_of_codes;  // 첫 번째 줄의 변수들
char lines[MAX_ROWS][MAX_LEN * MAX_COLS];  // 행별로 데이터를 저장할 배열
char map_data[MAX_ROWS][MAX_COLS][MAX_LEN];  // map 배열 (map_height행 map_width열을 저장)
char ally[MAX_ALLY][MAX_COLS][MAX_LEN];      // ally 배열 (num_of_allies개의 인덱스, 여러 행 가능)
char enemy[MAX_ENEMY][MAX_COLS][MAX_LEN];    // enemy 배열 (num_of_enemies개의 인덱스, 여러 행 가능)
char code[MAX_CODE][MAX_LEN];                // code 배열 (num_of_codes개의 인덱스)

// 입력데이터를 파싱하는 부분
void parse_data(char* game_data) {
	int line_index = 0;
	char* token = strtok(game_data, "\n");  // 줄바꿈 기준으로 행을 나눔
	while (token != NULL) {
		strcpy(lines[line_index], token);  // 각 행을 lines 배열에 저장
		line_index++;
		token = strtok(NULL, "\n");
	}

	// 첫 번째 줄에서 map_height, map_width, num_of_allies, num_of_enemies, num_of_codes 추출
	sscanf(lines[0], "%d %d %d %d %d", &map_height, &map_width, &num_of_allies, &num_of_enemies, &num_of_codes);

	// map 데이터 파싱 (map_height개의 행, map_width개의 열)
	for (int i = 0; i < map_height; i++) {
		char* token = strtok(lines[i + 1], " ");  // map 데이터는 두 번째 줄부터 시작
		for (int j = 0; j < map_width; j++) {
			if (token != NULL) {
				strcpy(map_data[i][j], token);
				token = strtok(NULL, " ");
			}
		}
	}

	// ally 데이터 파싱 (num_of_allies개의 데이터)
	for (int i = 0; i < num_of_allies; i++) {
		char* token = strtok(lines[map_height + 1 + i], " ");  // ally 데이터는 map 데이터 다음 줄
		int j = 0;
		while (token != NULL) {
			strcpy(ally[i][j], token);
			token = strtok(NULL, " ");
			j++;
		}
	}

	// enemy 데이터 파싱 (num_of_enemies개의 데이터)
	for (int i = 0; i < num_of_enemies; i++) {
		char* token = strtok(lines[map_height + 1 + num_of_allies + i], " ");  // enemy 데이터는 ally 데이터 다음 줄
		int j = 0;
		while (token != NULL) {
			strcpy(enemy[i][j], token);
			token = strtok(NULL, " ");
			j++;
		}
	}

	// code 데이터 파싱 (num_of_codes개의 데이터)
	for (int i = 0; i < num_of_codes; i++) {
		strcpy(code[i], lines[map_height + 1 + num_of_allies + num_of_enemies + i]);  // code는 enemy 데이터 다음 줄에 위치
	}
}

int* find_my_position() {
	int* my_position = (int*)malloc(2 * sizeof(int));
	my_position[0] = -1;  // 위치를 못 찾았을 경우 기본값
	my_position[1] = -1;

	for (int i = 0; i < map_height; ++i) {
		for (int j = 0; j < map_width; ++j) {
			if (strcmp(map_data[i][j], "A") == 0) {
				my_position[0] = i;
				my_position[1] = j;
				return my_position;  // 위치를 찾으면 반환
			}
		}
	}

	return my_position;  // 위치를 못 찾았을 경우 (-1, -1) 반환
}

int main() {
	 wchar_t nickname[] = L"기본코드";
	 char* game_data = init(nickname);


	 // while 반복문: 배틀싸피 메인 프로그램과 클라이언트(이 코드)가 데이터를 계속해서 주고받는 부분
	 while (game_data != NULL)
	 {
		 printf("----입력데이터----\n%s\n----------------", game_data);
		 char output[] = "A";
		 parse_data(game_data);

		 // 파싱한 데이터를 화면에 출력하여 확인
		 printf("map_height = %d, map_width = %d, num_of_allies = %d, num_of_enemies = %d, num_of_codes = %d\n",
			 map_height, map_width, num_of_allies, num_of_enemies, num_of_codes);

		 // Map 출력
		 printf("\nMap:\n");
		 for (int i = 0; i < map_height; i++) {
			 for (int j = 0; j < map_width; j++) {
				 printf("%s ", map_data[i][j]);
			 }
			 printf("\n");
		 }

		 // 아군 정보 출력
		 printf("\n아군 정보\n");
		 for (int i = 0; i < num_of_allies; i++) {
			 int j = 0;
			 while (strlen(ally[i][j]) > 0) {
				 printf("%s ", ally[i][j]);
				 j++;
			 }
			 printf("\n");
		 }

		 // Enemy 출력
		 printf("\n적군 정보\n");
		 for (int i = 0; i < num_of_enemies; i++) {
			 int j = 0;
			 while (strlen(enemy[i][j]) > 0) {
				 printf("%s ", enemy[i][j]);
				 j++;
			 }
			 printf("\n");
		 }

		 // Code 출력 (이 경우 num_of_codes = 1이므로 출력)
		 printf("\n[암호문 정보] (암호문 수 %d)\n", num_of_codes);
		 for (int i = 0; i < num_of_codes; i++) {
			 printf("%s\n", code[i]);
		 }

		 int* my_position = find_my_position();
		 if (my_position[0] < map_height - 1 && map_data[my_position[0] + 1][my_position[1]][0] == 'G') {
			 strcpy(output, "D A");
		 }
		 else {
			 strcpy(output, "R A");
		 }

		 game_data = submit(output);
	 }

	 close();
	 return 0;
}
