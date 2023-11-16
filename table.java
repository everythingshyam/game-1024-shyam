import java.util.Scanner;

import java.lang.Math;

public class table extends ArrayHelp
{
    public final int size = 5; //Any integer greater than or equal to 3 recommended
    public int[][] prevTab = new int[size][size];
    public int[][] currTab = new int[size][size];
    public int[][] nextTab = new int[size][size];
    int max;//stores the max element in the table

    public table()      //constructor for setting up a new game
    {
        for (int a = 0; a < size; a++) 
        {
            for (int b = 0; b < size; b++)
            {
                prevTab[a][b] = 0;
                currTab[a][b] = 0;
                nextTab[a][b] = 0;
            }
        }
        max=0;
        this.addRandom();
        this.addRandom();//adding 2 randomly at two places
    }

    public table(int in[][])    //constructor for resuming a previous game
    {
        arrCopy(in, currTab);
        for (int a = 0; a < size; a++) 
        {
            for (int b = 0; b < size; b++)
            {
                prevTab[a][b] = 0;
                nextTab[a][b] = 0;
            }
        }
        max=maxElement(this.currTab);
    }

    private void addRandom()
    {
        int m,n;
        int f=1;
        if(isEmpty(currTab)==1)
            f=0;
        while(f!=1)
        {
            m=(int)(Math.random()*100)/(100/size);
            n=(int)(Math.random()*100)/(100/size);
            if(currTab[m][n]==0)
            {
                currTab[m][n]=2;
                f=1;
            }
        }
    }

    public void left()
    {
        int a,b,c;
        int f=1;
        for(a=0;a<size;a++)
        {
            f=1;    //Is the row all zero?
            for(b=0;b<size-1;b++)
            {
                if(currTab[a][b]!=0)
                {
                    f=0;
                    break;
                }
            }
            if(f==0)//the row isn't all zero
            {
                c=0;
                for(b=0;b<size;b++)
                {
                    if(currTab[a][b]!=0)
                    {
                        for(int d=0;d<size;d++)
                        {
                            if(currTab[a][b]==currTab[a][d])
                            {
                                currTab[a][c++]=currTab[a][b]+currTab[a][d];
                            }
                        }
                    }
                }
            }
        }
        this.addRandom();
    }
    public void right() //Some Jugaad
    {
        switchHorizon(this.currTab);
        this.left();
        switchHorizon(this.currTab);
        this.addRandom();
    }
    public void up()
    {
        int a,b,c;
        int f=1;
        for(b=0;b<size;b++)
        {
            f=1;    //Is the column all zero?
            for(a=0;a<size;a++)
            {
                if(currTab[a][b]!=0)
                {
                    f=0;
                    break;
                }
            }
            if(f==0)
            {
                for(a=0;a<size-1;)
                {
                    if(currTab[a][b]==0)//if 0, all forward elements will be shifted upwards
                    {
                        for(c=a;c<size-1;c++)
                        {
                            currTab[c][b]=currTab[c+1][b];
                        }
                        currTab[size-1][b]=0;
                        continue;
                    }

                    if(currTab[a][b]==currTab[a+1][b])  //if matched, adds the two and shifts the terms towards the current element
                    {
                        currTab[a][b]+=currTab[a+1][b];
                        for(c=a+1;c<size-1;c++)
                        {
                            currTab[c][b]=currTab[c+1][b];
                        }
                        currTab[size-1][b]=0;
                    }

                    f=0;
                    for(c=a+1;c<size;c++)
                    {
                        if(currTab[c][b]!=0)
                        {
                            f=1;
                            break;
                        }
                    }

                    if(f==0)
                        break;
                    a++;
                }
            }
        }
        this.addRandom();
    }
    public void down()  //Some Jugaad again
    {
        switchVertical(this.currTab);
        this.up();
        switchVertical(this.currTab);
        this.addRandom();
    }

    public void displayTab()
    {
        System.out.println("---------------");
        for(int a=0;a<size;a++)
        {
            System.out.println();
            for(int b=0;b<size;b++)
            {
                System.out.print("\t"+currTab[a][b]);
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    public static void main(String[] args)
    {
        System.out.println("");
        Scanner sc=new Scanner(System.in);

        //int arr[][]={{0,0,2,2,0},{0,2,2,2,0},{2,2,2,2,0},{0,0,2,2,0},{0,0,2,2,0}};
        
        table t=new table();
        //t.displayTab();
        System.out.println("Untill the game is completely built. Here is a basic version.\nHere are the inputs you can enter.\nu for Up\nd for Down\nl for Left\nr for Right\n0 to EXIT");
        char in='u';
        while(in!='0')
        {
            if(t.max<maxElement(t.currTab))
            {
                System.out.println("CONGRATS! NEW LEVEL REACHED :"+t.max);
                t.max=maxElement(t.currTab);
            }
            t.displayTab();
            System.out.print("Enter your choice_");
            in=sc.next().charAt(0); 
            if(in>=65&&in<=90)
            in+=32;


            switch(in)
            {
                case 'l':
                {
                    t.left();
                    break;
                }
                case 'r':
                {
                    t.right();
                    break;
                }
                case 'u':
                {
                    t.up();
                    break;
                }
                case 'd':
                {
                    t.down();
                    break;
                }
                case '0':
                {
                    System.out.println("Byeeeeeeeeeee!");
                    break;
                }
                default:
                {
                    System.out.println("Something's wrong dear! In case you have forgot the instructions:\nl  left\nr  right\nu  up\nd  down\n0  EXIT");
                    break;
                }
            }
        }
        sc.close();
    }
}
