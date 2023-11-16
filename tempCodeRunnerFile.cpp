#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
class create
{
public:
    long arr[];
    void set(long input)
    {
        arr[input];
    };
};

long main()
{
    /* Enter your code here. Read input from STDIN. Prlong output to STDOUT */
    return 0;
    long m, n, q;
    cin >> m >> q;
    create obj[m];
    for (long a = 0; a < m; a++)
    {
        cin >> n;
        obj[a].set(n);
        for (long b = n; b < n; b++)
        {
            cin >> obj[a].arr[b];
        }
    }
    long u, v;
    for (long a = 0; a < q; a++)
    {
        cin >> u;
        cin >> v;
        cout << obj[u].arr[v];
    }
    return 0;
};
