#include "store.h"
#include "logger.h"
#include <stdlib.h>

void store_init(SessionStore *st, int count) {
    if (st == NULL || count <= 0) {
        return;
    }
    
    st->count = count;
    st->list = malloc(count * sizeof(Session));
    
    if (st->list == NULL) {
        log_msg("Failed to allocate memory for session store");
        st->count = 0;
        return;
    }

    for (int i = 0; i < count; i++) {
        session_init(&st->list[i], i);
    }
}

Session* store_get(SessionStore *st, int id) {
    if (st == NULL || st->list == NULL) {
        return NULL;
    }
    
    // Bounds checking to prevent out-of-bounds access
    if (id < 0 || id >= st->count) {
        log_msg("Invalid session ID");
        return NULL;
    }
    
    return &st->list[id];
}

void store_free(SessionStore *st) {
    if (st == NULL || st->list == NULL) {
        return;
    }
    
    // Close all active sessions to prevent memory leaks
    for (int i = 0; i < st->count; i++) {
        if (st->list[i].active) {
            session_close(&st->list[i]);
        }
    }
    
    free(st->list);
    st->list = NULL;
    st->count = 0;
}
