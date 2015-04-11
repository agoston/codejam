#include <stdio.h>
#include <math.h>
#include <stdlib.h>

const long double base = 5.23606797749978969640917366873127;
const long double modulo = 1000.0;

void mulmod1000(long double &in, long double &carryon) {
  in = (in * base) + carryon;
  long double intpart = (floor(in / modulo)) * modulo;
  in -= intpart;
  carryon = (intpart * base);
  intpart = (floor(carryon / modulo)) * modulo;
  carryon -= intpart;
}

int main(int argc, char **argv) {
  int numcase = -1;
  scanf("%d\n", &numcase);
  for (int j = 0; j < numcase; j++) {
    int actpow = -1;
    long double num = 1;
    long double carryon = 0;
    scanf("%d\n", &actpow);
    for (int i = 0; i < actpow; i++) {
      mulmod1000(num, carryon);
    }
    printf("Case #%d: %03.12f\n", j+1, (double)num);
  }
  return 0;
}
