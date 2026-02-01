#include "parser.h"
#include "logger.h"
#include <stdio.h>
#include <string.h>

void parse_command(char *cmd, SessionStore *store) {
    if (cmd == NULL || store == NULL) {
        return;
    }
    
    char action[8];
    int id;
    char name[64];

    // Use width specifiers to prevent buffer overflow
    int parsed = sscanf(cmd, "%7s %d %63s", action, &id, name);
    
    if (parsed < 2) {
        log_msg("Invalid command format");
        return;
    }

    if (!strcmp(action, "start")) {
        if (parsed < 3) {
            log_msg("Start command requires a name");
            return;
        }
        Session *s = store_get(store, id);
        if (s != NULL) {
            session_start(s, name);
            log_msg("started");
        }
    } 
    else if (!strcmp(action, "close")) {
        Session *s = store_get(store, id);
        if (s != NULL) {
            session_close(s);
            log_msg("closed");
        }
    }
    else {
        log_msg("Unknown command");
    }
}
