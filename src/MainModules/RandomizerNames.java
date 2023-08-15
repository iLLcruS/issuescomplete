package MainModules;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomizerNames {
    public void random() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many people you want to add? ");
        int count = Integer.parseInt(scanner.nextLine());

        List<String> names = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.print("Input name: ");
            String name = scanner.nextLine();
            names.add(name);
        }

        Random random = new Random();
        int winnerIndex = random.nextInt(count);
        String winner = names.get(winnerIndex);
        System.out.println("Winner: " + winner + ";");
    }
}