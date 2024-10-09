#include "bridge.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <wchar.h>
#include <winsock2.h>

#pragma warning(disable : 4996)
#pragma comment(lib, "ws2_32.lib")

SOCKET sock;

void ErrorHandling(const char* message) {
    fprintf(stderr, "[ERROR] %s\n", message);
    exit(1);
}

char* utf8_encode(const wchar_t* wstr) {
    int size_needed = WideCharToMultiByte(CP_UTF8, 0, wstr, -1, NULL, 0, NULL, NULL);
    char* str_to = (char*)malloc(size_needed);
    WideCharToMultiByte(CP_UTF8, 0, wstr, -1, str_to, size_needed, NULL, NULL);
    return str_to;
}

wchar_t* utf8_decode(const char* str) {
    int size_needed = MultiByteToWideChar(CP_UTF8, 0, str, -1, NULL, 0);
    wchar_t* wstr_to = (wchar_t*)malloc(size_needed * sizeof(wchar_t));
    MultiByteToWideChar(CP_UTF8, 0, str, -1, wstr_to, size_needed);
    return wstr_to;
}

char* init(const wchar_t* nickname) {
    WSADATA wsaData;
    SOCKADDR_IN sockAddr;
    wchar_t init_command[256] = L"INIT ";
    wcscat(init_command, nickname);
    char* enc_command = utf8_encode(init_command);

    if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0)
        ErrorHandling("WSAStartup failure.");

    sock = socket(PF_INET, SOCK_STREAM, 0);
    if (sock == INVALID_SOCKET)
        ErrorHandling("Socket Creating Failure.");

    memset(&sockAddr, 0, sizeof(sockAddr));
    sockAddr.sin_family = AF_INET;
    sockAddr.sin_addr.s_addr = inet_addr(HOST);
    sockAddr.sin_port = htons(PORT);

    printf("[STATUS] Trying to connect to %s:%d\n", HOST, PORT);
    if (connect(sock, (SOCKADDR*)&sockAddr, sizeof(sockAddr)) == SOCKET_ERROR) {
        ErrorHandling("Failed to connect. Please check if Battle SSAFY is waiting for connection.");
    } else {
        printf("[STATUS] Connected\n");
        return submit(enc_command);
    }

    free(enc_command);
    return NULL;
}

char* submit(const char* string_to_send) {
    if (send(sock, string_to_send, strlen(string_to_send), 0) == SOCKET_ERROR) {
        ErrorHandling("Failed to send data. Please check if Battle SSAFY is waiting for connection.");
    }

    return receive();
}

char* receive() {
    char buffer[1024];
    int strLen = recv(sock, buffer, sizeof(buffer) - 1, 0);

    if (strLen == -1) {
        ErrorHandling("Failed to receive data. Please check if Battle SSAFY is waiting for connection.");
    }

    buffer[strLen] = '\0';
    char* game_data = strdup(buffer);

    wchar_t* decoded_data = utf8_decode(game_data);

    free(decoded_data);

    if (game_data[0] > 0) {
        return game_data;
    } else {
        close();
        return NULL;
    }
}

void close() {
    if (sock != INVALID_SOCKET) {
        closesocket(sock);
        WSACleanup();
        printf("[STATUS] Connection closed\n");
    } else {
        fprintf(stderr, "[ERROR] Network connection has been corrupted.\n");
    }
}
