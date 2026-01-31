#ifndef STORE_H
#define STORE_H

#include "session.h"

typedef struct {
    Session *list;
    int count;
} SessionStore;

void store_init(SessionStore *st, int count);
Session* store_get(SessionStore *st, int id);
void store_free(SessionStore *st);

#endif
