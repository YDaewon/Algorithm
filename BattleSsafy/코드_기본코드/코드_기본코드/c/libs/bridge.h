#ifndef BRIDGE_H
#define BRIDGE_H

#include <winsock2.h>
#include <wchar.h>

#define HOST "127.0.0.1"
#define PORT 8747

extern SOCKET sock;

void ErrorHandling(const char* message);
char* init(const wchar_t* nickname);
char* submit(const char* string_to_send);
char* receive();
void close();

#endif
