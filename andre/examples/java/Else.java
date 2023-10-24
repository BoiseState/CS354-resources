import java.util.Scanner;
public class Else
{
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter num: ");
        int n=sc.nextInt();
        if(n>0)
            if(n>100)
                System.out.println("more than 100.");
        else
            System.out.println("The given number is negative.");
    }
}
