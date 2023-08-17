#include <cstdio>
long long int s, i, n;
void f() {
    s = 1;
    for (i = 1; i <= n; i++) {
        s *= i;
        while (s % 10 == 0)s /= 10;
        s %= 1000000000000;
    }
}
int main() {
    scanf("%lld", &n);
    f();
    printf("%05lld", s % 100000);
}