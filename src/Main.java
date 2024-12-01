import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Choose Even or odd for toss");
        String choice = s.nextLine();
        System.out.println("Play");
        int computer = (int)(Math.random() * 10);
        int player;
        player = s.nextInt();
        System.out.println(computer);
        String ch;
        if((computer + player)%2==0){
            ch = "Even";
            System.out.println("Even");
        }
        else {
            ch = "Odd";
            System.out.println("Odd");
        }
        int k;
        try {
            if (choice.equalsIgnoreCase(ch)) {
                System.out.println("You want to Bat(1) or ball(0)");
                k = s.nextInt();
                switch (k) {
                    case 0 -> play(0);
                    case 1 -> play(1);
                    default -> {
                        ;
                    }
                }
            } else {
                System.out.println("I will bat");
                play(0);
            }

        }catch(NumberFormatException e){
            System.out.println("Invalid input");
            System.exit(1);
        }
    }
    public static void play(int x){
        int n = (int)(Math.random() * 10), player=0;
        int sc = 0;
        Scanner s = new Scanner(System.in);
        while(n != player){
            System.out.println("Score = " + sc);
            n = (int)(Math.random() * 10);
            player = s.nextInt();
            System.out.println(n);
            if(x == 0){
                sc += n;
            }
            else
                sc +=player;
        }
        do{
            System.out.println("Target = " + sc);
            n = (int)(Math.random() * 10);

            player = s.nextInt();
            System.out.println(n);
            if(x == 0){
                sc -= player;
            }
            else
                sc -=n;
        }while((n!=player) && sc>0);
        if((sc>=0 && x==0)||(sc<0 && x==1))
            System.out.println("I Win");
        else if((sc>=0 && x==1)||(sc<0 && x==0))
            System.out.println("You Win");
    }
}
