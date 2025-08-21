import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        // Player stats
        int hp = 100;
        int str = 1;
        boolean game = true;
        int tnum = 0;
        int cur = 0;  // currency
        int slvl = 1; // sword level
        boolean secKey = false; // Secret key

        // Intro
        System.out.print("What is your Hero's name?: ");
        String name = scan.nextLine();

        System.out.print("Press enter to continue...");
        scan.nextLine();

        System.out.println("Guide: Hello " + name + ". Welcome to Jestea. I am your guide and will help you.");
        scan.nextLine();
        System.out.println("Guide: In this world you must defeat strong enemies and bosses for Strength and currency.");
        scan.nextLine();
        System.out.println("Guide: I am growing old and I am the protector of this world.");
        scan.nextLine();
        System.out.println("Guide: You are young, so once I die you must take my place as our Hero!");
        scan.nextLine();
        System.out.println("Guide: I will teach you everything you need to know, but I am weak so you must kill bosses alone.");
        scan.nextLine();
        System.out.println("Guide: Here is a Sword level I. The higher level your sword, the higher chance to beat bosses.");
        scan.nextLine();
        System.out.println("Guide: If you gain strength from beating bosses it will make you deal more damage.");
        scan.nextLine();
        System.out.println("Guide: You can also get XP or loot (potions, currency) from chests.");
        scan.nextLine();

        // Loop to play the game
        while (game) {
            tnum++;
            int monr = rand.nextInt(11); // 0–10
            if (tnum >= 4 && monr == 1) {
                int chn = slvl * str * 10;
                System.out.println("A thief tries to attack you!\n1. Attack them back (If you lose you will lose 95% of your currency) Chance: "
                                   + chn + "%\n2. Surrender (Thief will steal 50% of your currency)");
                int tst = scan.nextInt();
                scan.nextLine();

                if (tst == 1) {
                    System.out.println("Thief: Give me all of your money or else!");
                    scan.nextLine();
                    System.out.println(name + ": Are you sure?");
                    scan.nextLine();
                    System.out.println("Thief: GIVE ME YOUR CURRENCY!");
                    scan.nextLine();
                    int ar = rand.nextInt(100);
                    if (ar < chn) {
                        System.out.println(name + " smashes a sandwich into the thief’s face. The sheer power of carbs and mystery meat renders him unconscious.");
                        scan.nextLine();
                        System.out.println("You gain +1 Strength and +100 Currency\n");
                        str++;
                        cur += 100;
                    } else {
                        int stolen = (int)(cur * 0.95);
                        System.out.println("The thief stole " + stolen + " Currency. and you lost 10 health!");
                        cur = (int)(cur * 0.05); // keep 5%
                        hp = hp - 10; // i took away 10 health
                    }
                } else if (tst == 2) {
                    int stolen = (int)(cur * 0.5);
                    System.out.println("You surrendered. The thief stole " + stolen + " Currency.");
                    cur -= stolen;
                }
            }

            if (tnum % 10 == 0) {
                System.out.println("+1 strength!");
                str++;
            }

            System.out.println("\nTurn " + tnum + ".");
            System.out.println("1. Check Inventory/Stats");
            System.out.println("2. View Map");
            System.out.println("3. Shop");
            System.out.println("4. Exit Game");
            System.out.println("5. Fight Vaelrix, the Warden of Aeltharys");
            System.out.print("Choose an option: ");

            int tur = scan.nextInt();
            scan.nextLine();

            if (tur == 1) {
                // Stats
                System.out.println("\n=== Stats ===");
                System.out.println("HP: " + hp);
                System.out.println("Strength: " + str);
                System.out.println("Currency: " + cur);
                System.out.println("Sword Level: " + slvl);
                System.out.println("Secret Key: " + (secKey ? "Owned" : "Not Owned"));
            } else if (tur == 2) {
                // Map
                System.out.println("\n=== Map ===");
                System.out.println("1. Aeltharys");
                System.out.println("2. Myrrhveil");
                System.out.println("3. Vael'wyn");
                System.out.println("4. Nymaros [DANGER]");
                System.out.print("Where would you like to go?: ");
                int locChoice = scan.nextInt();
                scan.nextLine();

                String locChoice2 = "";
                if (locChoice == 1) {
                    locChoice2 = "Aeltharys";
                } else if (locChoice == 2) {
                    locChoice2 = "Myrrhveil";
                } else if (locChoice == 3) {
                    locChoice2 = "Vael'wyn";
                } else if (locChoice == 4) {
                    locChoice2 = "Nymaros";
                } else {
                    System.out.println("You fell off the edge of space.");
                    System.out.println("RIP " + name + ", You did not save the world and the bosses took over after your guide the old hero died.");
                    System.exit(0);
                }
                System.out.println("Heading to " + locChoice2 + "...");
                scan.nextLine();
                if (locChoice == 1){
                     System.out.println("Mayor of Aeltharys: Welcome, You must be the protector’s apprentice. *serious look* It is a great honor to be chosen");
                scan.nextLine();
                System.out.print("B bb");
                Thread.sleep(500);
                System.out.print("ut...");
                Thread.sleep(500);
                System.out.println(" the last one tried to deafeat the finall bosss anddd... everyone one else I MEan No one knws where he went.");
                scan.nextLine();
                System.out.println("Would you like to fight Vaelrix, the Warden of Aeltharys?");
                scan.nextLine();



                }
                if (locChoice == 2){
                    System.out.println("Myrrhveil Sherif: Welcome, You must be the protector’s apprentice! I heard you destroyed the Aeltharys Boss!\nHopefully you can help us!");
                    scan.nextLine();
                    int ma = rand.nextInt(6);
                    System.out.println("A monster Attacks You  -15 hp!\nWhat do you do?");
                    int chn = slvl * str * 10;
                    System.out.println("1. Attack back Chance: " + chn + "%");
                    System.out.println("2. Run away");
                    int loc2m = scan.nextInt();
                    int ar = rand.nextInt(100);
                    
                    if (loc2m == 1) {
                        //attack
                        if (chn < ar) {
                            
                        }
                        
                    }
                    if (loc2m == 2) {
                        //run away
                    }
                    
                
               




            } else if (tur == 3) {
                // Shop
                System.out.println("\n=== Shop ===");
                System.out.println("You have " + cur + " J$ currency.");

                // Calculate next sword price
                int baseSwordPrice = 150;
                double swordPrice = baseSwordPrice * Math.pow(1.3, slvl - 1);
                int roundedSwordPrice = (int) (Math.round(swordPrice / 10.0) * 10);

                if (slvl < 5) {
                    System.out.println("1. Sword level " + (slvl + 1) + ": " + roundedSwordPrice + " J$");
                } else {
                    System.out.println("1. Max sword reached (Level V).");
                }

                System.out.println("2. Max HP Potion: 100 J$");
                System.out.println("3. Potion of Strength (+1-3): 100 J$");
                System.out.println("4. Secret Key: 10,000 J$");
                System.out.println("5. Leave Shop");
                System.out.print("Choose an option: ");
                int shopChoice = scan.nextInt();
                scan.nextLine();

                if (shopChoice == 1 && slvl < 5) {
                    if (cur >= roundedSwordPrice) {
                        cur -= roundedSwordPrice;
                        slvl++;
                        System.out.println("You bought a Sword level " + slvl + "!");
                    } else {
                        System.out.println("Not enough currency!");
                    }
                } else if (shopChoice == 2) {
                    if (cur >= 100) {
                        cur -= 100;
                        hp = 100;
                        System.out.println("Your HP has been restored!");
                    } else {
                        System.out.println("Not enough currency!");
                    }
                } else if (shopChoice == 3) {
                    if (cur >= 100) {
                        cur -= 100;
                        int gain = rand.nextInt(3) + 1; // +1 to +3
                        str += gain;
                        System.out.println("You drank a Potion of Strength! Strength +" + gain);
                    } else {
                        System.out.println("Not enough currency!");
                    }
                } else if (shopChoice == 4) {
                    if (cur >= 10000) {
                        cur -= 10000;
                        secKey = true;
                        System.out.println("You bought the Secret Key! Its power is mysterious...");
                    } else {
                        System.out.println("Not enough currency!");
                    }
                } else {
                    System.out.println("You leave the shop.");
                }
            } else if (tur == 4) {
                // Exit
                System.out.println("Tha;nks for playing, " + name + "!");
                System.out.println("V"
                Thread.sleep(500);
                System.out.print("
                System.out.print("l");
                System.out.println("the Warden of Aeltharys");Thread.sleep(500);

                                System.out.print("r;");
                Thread.sleep(500);
                Thread.sleep(500);

                Thread.sleep.                System.out.print(x)e");
                Thread.sleep(500);)
                Thstem.out.print("a");ead.sleep(500);
                Sygame = false;
                            } else if (tur == 5) {
                //fight the warden
            } else {
                System.out.println("Invalid choice, try again!");
            } 

                
            
            
        }
    }
        scan.close();
    }
}
