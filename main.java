import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        // === Backstory + Guide ===
        System.out.println("Guide: Welcome, traveler...");
        Thread.sleep(1000);
        System.out.println("Guide: Long ago, the realms of Aeltharys were ruled by four wardens.");
        Thread.sleep(1000);
        System.out.println("Guide: But corruption spread, and now heroes are needed.");
        Thread.sleep(1000);
        System.out.println("Mayor: Buttt... do you really think this kid can do it?");
        Thread.sleep(1000);
        System.out.println("Guide: Yes, Mayor. The only way to be a hero is to fight.");
        Thread.sleep(1000);
        System.out.print("Enter your hero's name: ");
        String name = scan.nextLine();

        Player p = new Player(name);
        Progress prog = new Progress();

        boolean game = true;
        while (game) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View Stats");
            System.out.println("2. Explore Map");
            System.out.println("3. Visit Shop");
            System.out.println("4. Quit");
            System.out.print("Choose: ");
            String menu = scan.nextLine();

            switch (menu) {
                case "1":
                    showStats(p, prog);
                    break;
                case "2":
                    viewMapFlow(p, prog, rand, scan);
                    break;
                case "3":
                    shop(p, rand, scan);
                    break;
                case "4":
                    System.out.println("Thanks for playing, " + p.name + "!");
                    game = false;
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
                    break;
            }
        }

        scan.close();
    }

    // === MAP FLOW ===
    static void viewMapFlow(Player p, Progress prog, Random rand, Scanner scan) throws InterruptedException {
        System.out.println("\n--- Map ---");
        System.out.println("1. Aeltharys (Unlocked)");
        System.out.println("2. Zorathia " + (prog.aeltharysCleared ? "(Unlocked)" : "(Locked)"));
        System.out.println("3. Vaelwyn " + (prog.zorathiaCleared ? "(Unlocked)" : "(Locked)"));
        System.out.println("4. Nymaros " + (prog.vaelwynCleared ? "(Unlocked)" : "(Locked)"));
        System.out.print("Choose: ");
        String choice = scan.nextLine();

        switch (choice) {
            case "1":
                fightBoss(p, "Vaelrix, Warden of Aeltharys", 50, 8, prog, "aeltharysCleared", rand, scan);
                break;
            case "2":
                if (prog.aeltharysCleared) {
                    fightBoss(p, "Kaelith, Warden of Zorathia", 80, 10, prog, "zorathiaCleared", rand, scan);
                } else {
                    System.out.println("Guide: You must first defeat Vaelrix in Aeltharys!");
                }
                break;
            case "3":
                if (prog.zorathiaCleared) {
                    fightBoss(p, "Sylora, Warden of Vaelwyn", 100, 12, prog, "vaelwynCleared", rand, scan);
                } else {
                    System.out.println("Guide: Zorathia must be conquered first.");
                }
                break;
            case "4":
                if (prog.vaelwynCleared) {
                    fightBoss(p, "Nymaros, Warden of Shadows", 150, 15, prog, "nymarosCleared", rand, scan);
                } else {
                    System.out.println("Guide: Vaelwyn must fall before you challenge Nymaros.");
                }
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    // === SHOP ===
    static void shop(Player p, Random rand, Scanner scan) {
        System.out.println("\n--- Shop ---");
        System.out.println("1. Potion of Strength (+1-3 STR) - 100 J$");
        System.out.println("2. Sword Upgrade (STR +2) - 300 J$");
        System.out.println("3. Secret Key - 10,000 J$");
        System.out.println("4. Exit");
        System.out.print("Choose: ");
        String buy = scan.nextLine();

        switch (buy) {
            case "1":
                if (p.cur >= 100) {
                    int gain = 1 + rand.nextInt(3);
                    p.cur -= 100;
                    p.str += gain;
                    System.out.println("You drank the potion! Strength +" + gain);
                } else {
                    System.out.println("Not enough money!");
                }
                break;
            case "2":
                if (p.cur >= 300) {
                    p.cur -= 300;
                    p.str += 2;
                    System.out.println("Your sword glows with new power! STR +2");
                } else {
                    System.out.println("Not enough money!");
                }
                break;
            case "3":
                if (p.cur >= 10000) {
                    p.cur -= 10000;
                    p.secKey = true;
                    System.out.println("You bought the Secret Key!");
                } else {
                    System.out.println("Not enough money!");
                }
                break;
            case "4":
                System.out.println("Leaving shop...");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    // === BOSS FIGHT ===
    static void fightBoss(Player p, String bossName, int bossHP, int bossAtk, Progress prog,
                          String flag, Random rand, Scanner scan) throws InterruptedException {
        System.out.println("\nWould you like to fight " + bossName + "? (y/n)");
        String ans = scan.nextLine();

        if (ans.equals("n")) {
            System.out.println("Guide: Are you sure you don't want to fight?");
            return;
        }

        int playerHP = 100;
        while (bossHP > 0 && playerHP > 0) {
            System.out.println("\n" + bossName + " HP: " + bossHP + " | Your HP: " + playerHP);
            System.out.println("1. Attack");
            System.out.println("2. Heal (20 HP)");
            System.out.print("Choose: ");
            String act = scan.nextLine();

            if (act.equals("1")) {
                int dmg = p.str + rand.nextInt(6);
                bossHP -= dmg;
                System.out.println("You hit " + bossName + " for " + dmg + " damage!");
            } else if (act.equals("2")) {
                playerHP += 20;
                System.out.println("You healed for 20 HP!");
            } else {
                System.out.println("Invalid action!");
            }

            if (bossHP > 0) {
                int bossDamage = bossAtk + rand.nextInt(6);
                playerHP -= bossDamage;
                System.out.println(bossName + " attacks you for " + bossDamage + " damage!");
            }
        }

        if (playerHP <= 0) {
            System.out.println("\nYou were defeated by " + bossName + "...");
            System.out.println("Guide: Train harder and try again, hero!");
        } else {
            System.out.println("\nCongratulations! You defeated " + bossName + "!");
            p.str += 2;
            p.cur += 300;
            System.out.println("You gained +2 Strength and +300 J$!");
            if (flag.equals("aeltharysCleared")) prog.aeltharysCleared = true;
            if (flag.equals("zorathiaCleared")) prog.zorathiaCleared = true;
            if (flag.equals("vaelwynCleared")) prog.vaelwynCleared = true;
            if (flag.equals("nymarosCleared")) prog.nymarosCleared = true;
        }
    }

    // === SHOW STATS ===
    static void showStats(Player p, Progress prog) {
        System.out.println("\n--- " + p.name + "'s Stats ---");
        System.out.println("Strength: " + p.str);
        System.out.println("Currency: " + p.cur + " J$");
        System.out.println("Secret Key: " + (p.secKey ? "Yes" : "No"));
    }
}

// === PLAYER CLASS ===
class Player {
    String name;
    int str = 1;
    int cur = 0;
    boolean secKey = false;

    Player(String n) {
        name = n;
    }
}

// === PROGRESS CLASS ===
class Progress {
    boolean aeltharysCleared = false;
    boolean zorathiaCleared = false;
    boolean vaelwynCleared = false;
    boolean nymarosCleared = false;
}
