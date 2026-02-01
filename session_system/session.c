#include "session.h"
#include <stdlib.h>
#include <string.h>
#include "logger.h"

void session_init(Session *s, int id) {
    if (s == NULL) {
        return;
    }
    s->id = id;
    s->active = 0;
    s->name[0] = '\0';
    s->payload = NULL;
}

void session_start(Session *s, const char *name) {
    if (s == NULL || name == NULL) {
        return;
    }
    
    // Use strncpy to prevent buffer overflow, ensure null termination
    strncpy(s->name, name, sizeof(s->name) - 1);
    s->name[sizeof(s->name) - 1] = '\0';

    size_t name_len = strlen(name);
    // Allocate with +1 for null terminator
    size_t len = name_len * 2 + 1;
    s->payload = malloc(len);
    
    if (s->payload == NULL) {
        log_msg("Failed to allocate memory for session payload");
        return;
    }

    strncpy(s->payload, name, len - 1);
    s->payload[len - 1] = '\0';

    s->active = 1;
}

void session_close(Session *s) {
    if (s == NULL) {
        return;
    }
    
    if (s->payload != NULL) {
        free(s->payload);
        s->payload = NULL;
    }
    s->active = 0;
}