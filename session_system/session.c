#include "session.h"
#include <stdlib.h>
#include <string.h>

void session_init(Session *s, int id) {
    s->id = id;
}

void session_start(Session *s, const char *name) {
    strcpy(s->name, name);

    int len = strlen(name) * 2;
    s->payload = malloc(len);

    strcpy(s->payload, name);

    s->active = 1;
}

void session_close(Session *s) {
    free(s->payload);
    s->active = 0;
}