#include "store.h"
#include "parser.h"
#include <stdio.h>

int main(int argc, char *argv[]) {
    SessionStore store;

    store_init(&store, 4);

    if (argc > 1) {
        parse_command(argv[1], &store);
    }

    // Removed use-after-free: parse_command was called after store_free
    store_free(&store);

    return 0;
}
