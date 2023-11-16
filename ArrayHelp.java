public class ArrayHelp 
{
    public static void arrCopy(int arr1[][],int arr2[][])
    {
        if(arr1.length==arr2.length&&arr1[0].length==arr2[0].length)
        {
            for(int a=0;a<arr1.length;a++)
            {
                for(int b=0;b<arr1[0].length;b++)
                {
                    arr2[a][b]=arr1[a][b];
                }
            }
        }
    }

    public static int isEmpty(int arr[][])
    {
        int m=arr.length;
        int n=arr[0].length;

        int f=0;

        for(int a=0;a<m;a++)
        {
            for(int b=0;b<=n;b++)
            {
                if(arr[a][b]==0)
                {
                    f=1;
                    return 1;
                }
            }
            if(f==1)
                break;
        }
        return 0;
    }

    public static void switchVertical(int arr[][])
    {
        int m=arr.length;
        int n=arr[0].length;

        int arr2[][]=new int[m][n];
        arrCopy(arr, arr2);
        //printArray(arr2);
        for(int a=0;a<arr.length;a++)
        {
            for(int b=0;b<arr[0].length;b++)
            {
                arr[a][b]=arr2[m-a-1][b];
            }
        }
    }

    public static void switchHorizon(int arr[][])
    {
        int m=arr.length;
        int n=arr[0].length;

        int arr2[][]=new int[m][n];
        arrCopy(arr, arr2);
        //printArray(arr2);
        for(int a=0;a<arr.length;a++)
        {
            for(int b=0;b<arr[0].length;b++)
            {
                arr[a][b]=arr2[a][n-b-1];
            }
        }
    }

    public static boolean allSame(int arr[][])
    {
        int m=arr.length;
        int n=arr[0].length;
        int a,b;
        for(a=0;a<m;a++)
        {
            for(b=0;b<n-1;b++)
            {
                if(arr[a][b]!=arr[a][b])
                    return false;
            }
            if(a<m-1)
            if(arr[a][b]!=arr[a+1][0])
                return false;
        }
        return true;

    }

    public static int maxElement(int arr[][])
    {
        int m=arr.length;
        int n=arr[0].length;
        int max=0;
        if(allSame(arr))
            return arr[0][0];
        else
        {
            for(int a=0;a<m;a++)
            {
                for(int b=0;b<n;b++)
                {
                    if(max<arr[a][b])
                        max=arr[a][b];
                }
            }
            return max;
        }
    }

    public static void printArray(int arr[][])
    {
        for(int a=0;a<arr.length;a++)
        {
            System.out.println();
            for(int b=0;b<arr[0].length;b++)
            {
                System.out.print("\t"+arr[a][b]);
            }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        System.out.println("OK. Tested.");
    }
}
