#ifndef SESSION_H
#define SESSION_H

typedef struct {
    int id;
    int active;
    char name[16];
    char *payload;
} Session;

void session_init(Session *s, int id);
void session_start(Session *s, const char *name);
void session_close(Session *s);

#endif