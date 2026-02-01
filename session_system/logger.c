#include "logger.h"
#include <stdio.h>

void log_msg(const char *msg) {
    if (msg == NULL) {
        return;
    }
    printf("%s\n", msg);
}
