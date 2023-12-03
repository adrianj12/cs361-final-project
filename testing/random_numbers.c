#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void generateRandomInts(FILE *file, int count) {
    for (int i = 0; i < count; i++) {
        fprintf(file, "%d\n", rand());
    }
}

void generateRandomDoubles(FILE *file, int count) {
    for (int i = 0; i < count; i++) {
        fprintf(file, "%f\n", (double)rand() / RAND_MAX);
    }
}

int main() {
    int choice, count;
    FILE *file;

    // Initialize random number generator
    srand((unsigned)time(NULL));

    printf("Enter 1 for integers, 2 for doubles: ");
    scanf("%d", &choice);

    printf("Enter the number of elements: ");
    scanf("%d", &count);

    file = fopen("output.txt", "w");
    if (file == NULL) {
        printf("Error opening file!\n");
        return 1;
    }

    if (choice == 1) {
        generateRandomInts(file, count);
    } else if (choice == 2) {
        generateRandomDoubles(file, count);
    } else {
        printf("Invalid choice.\n");
    }

    fclose(file);
    return 0;
}
