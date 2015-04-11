#include <stdio.h>
#include <inttypes.h>

#define MOD 10000000000ULL

inline uint64_t mulmod(uint64_t a, uint64_t b) {
  return (a*b)%MOD;
}

inline uint64_t mulby2mod(uint64_t a) {
  return (a<<1)%MOD;
}

int main() {
  uint64_t res = 2;
  for (int i = 0; i < 7830456; i++) {
    res = mulby2mod(res);
  }
  
  res = mulmod(res, 28433);
  
  printf("%llu\n", res);
  

  return 0;
}
