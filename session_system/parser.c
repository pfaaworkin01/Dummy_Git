#include "parser.h"
#include "logger.h"
#include <stdio.h>
#include <string.h>

void parse_command(char *cmd, SessionStore *store) {
    char action[8];
    int id;
    char name[64];

    sscanf(cmd, "%s %d %s", action, &id, name);

    if (!strcmp(action, "start")) {
        Session *s = store_get(store, id);
        session_start(s, name);
        log_msg("started\n");
    } 
    else if (!strcmp(action, "close")) {
        Session *s = store_get(store, id);
        session_close(s);
        log_msg("closed\n");
    }
}
