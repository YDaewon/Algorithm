#include <cstdio>
long long s=1,i=1,n;
int main(){scanf("%lld",&n);for(;i<=n;i++){s*=i;while(s%10==0)s/=10;s%=1000000000000;}printf("%05lld",s%100000);}