#include "store.h"
#include <stdlib.h>

void store_init(SessionStore *st, int count) {
    st->count = count;
    st->list = malloc(count * sizeof(Session));

    for (int i = 0; i < count; i++)
        session_init(&st->list[i], i);
}

Session* store_get(SessionStore *st, int id) {
    return &st->list[id];
}

void store_free(SessionStore *st) {
    free(st->list);
}
