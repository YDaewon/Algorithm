#include<cstdio>
#include<cmath>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	scanf("%d", &T);
	for(test_case = 1; test_case <= T; ++test_case){
		double a, b, c;
        scanf("%lf %lf %lf", &a, &b, &c);
        double l = b-a;
        double r = c-b;
        printf("#%d %.1f\n", test_case, abs(l - r) / 2);
	}
	return 0;
}