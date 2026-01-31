#include "store.h"
#include "parser.h"
#include <stdio.h>

int main(int argc, char *argv[]) {
    SessionStore store;

    store_init(&store, 4);

    if (argc > 1) {
        parse_command(argv[1], &store);
    }

    store_free(&store);
    parse_command("start 1 test", &store);

    return 0;
}
