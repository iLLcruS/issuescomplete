package MainModules;

import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class CasinoMiniGame
{
    float balance = 1000;
    boolean game = true;
    public void main()
    {
        this.greetings();
        while (game)
        {
            play();
        }
    }
    public void play()
    {
        System.out.println("Your current balance: " + balance +"$");
        float bet = this.getBet();
        if (bet < balance) {
            System.out.print("Sorry your bet is incorrect! Try again!" );
            return;
        }
        int coefficient = this.getCoefficient();
        if (coefficient > 99) {
            System.out.print("Sorry your coefficient is incorrect! Try again!" );
            return;
        }
        if (this.startMakingOrLosingMoney(bet,coefficient))
        {
            float win = balance - bet;
            System.out.println("Congratulations you win " + win + "$");
        }
        else{
            System.out.println("Unfortunately you lost!");
        }
        System.out.print("Want continue? (Yes): ");
        //Getting answer ^_^
        this.game = needContinue();

    }
    private boolean needContinue()
    {
        String ans = new Scanner(System.in).next();
        return ans.equalsIgnoreCase("yes");
    }

    private void greetings()
    {
        System.out.println("Hello dear " + System.getProperty("name"));
        System.out.println("Welcome to our casino!\nWhich bet you wand do?");
    }
    private float getBet()
    {
        System.out.print("Enter your bet: ");
        return new Scanner(System.in).nextFloat();
    }
    private int getCoefficient()
    {
        System.out.print("Enter coefficient: ");
        return new Scanner(System.in).nextInt();
    }

    private boolean startMakingOrLosingMoney(float bet, float coefficient) {
        int chance = 100;
        chance = Math.round(chance / coefficient);


        int randomValue = (int) (Math.random() * 100) + 1;

        if (randomValue <= chance) {

            float profit = bet * coefficient - bet;
            balance += profit;
            return true;


        } else {

            float loss = -bet;
            balance -= loss;
            return false;
        }
    }


}
