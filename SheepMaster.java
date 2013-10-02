//TODO: Place File Header here
import java.util.Scanner;

//TODO: Place Class Header here (See Commenting Guide on the website)
public class SheepMaster
{
	//TODO: Place method header here (See Commenting Guide on the website)
	public static void main( String[] args )
	{
		final int SHEEP_PURCHASE_COST = 25;
		final int CYCLES_BETWEEN_MARKET = 3;
		final int DOG_PURCHASE_COST = 40;
		final int SHEEP_SELL_PRICE = 10;
		final int DOG_SELL_PRICE = 25;
		final int SHEEP_SHEARED_EARNING = 50;
		final int WOLF_APPEARS_EARNING = 10;
		final int VICTORY_THRESHOLD = 1500;
		final int INITIAL_FUNDS = 500;
		final int INITIAL_SHEEP = 1;
		final int INITIAL_DOGS = 0;
		final int MIN_NUMBER_WOLVES = 1;
		final int SHEEP_EATEN_WOLF =3;

		int userFunds = INITIAL_FUNDS;
		int userSheep = INITIAL_SHEEP;
		int userDogs = INITIAL_DOGS;
		int sheepPurchased = 0;
		int sheepSold = 0;
		int sheepLost = 0;
		int dogsPurchased = 0;
		int dogsSold = 0;
		int dogsLost = 0; 
		int nightsSurvived = 0;

		Scanner input = new Scanner( System.in );
		int userChoice;

		// TODO for Milestone 4: Create a Random object, for use in generating 
		// random numbers. The code will be similar to the scanner 
		// declaration above. This should be the only Random created in the 
		// entire program.




		do
		{
			System.out.println();
			System.out.println("Welcome to Happy Meadows! The world is your oyster!");  
			System.out.println();
			System.out.println("*** Current Meadow Status ***");
			System.out.println("Number of Sheep: "+userSheep);
			System.out.println("Number of Doubloons: "+userFunds);
			System.out.println("Number of turns before market day: 3");
			System.out.println();

			System.out.println("Available Actions:");
			System.out.println("(1) Print Market Prices");
			System.out.println("(2) Print Detailed Statistics");
			System.out.println("(3) Buy Some Sheep");
			System.out.println("(4) Buy a Guard Dog");
			System.out.println("(5) Sell a Sheep");
			System.out.println("(6) Sell a Guard Dog");
			System.out.println("(7) Enter Night Phase");
			System.out.println("(8) Quit");


			System.out.println("What would you like to do?");
			do
			{
				while (!input.hasNextInt())
				{
					System.out.print("Error: Menu selection must be an integer! Please try again: ");
					input.next();
				}

				userChoice = input.nextInt();
				if (userChoice < 0 || userChoice > 8)
				{
					System.out.println("Error: Invalid Menu Selection.");
					userChoice = -1;
					System.out.println();
					System.out.println("Welcome to Happy Meadows! The world is your oyster!");  
					System.out.println();
					System.out.println("*** Current Meadow Status ***");
					System.out.println("Number of Sheep: "+userSheep);
					System.out.println("Number of Doubloons: "+userFunds);
					System.out.println("Number of turns before market day: 3");
					System.out.println();

					System.out.println("Available Actions:");
					System.out.println("(1) Print Market Prices");
					System.out.println("(2) Print Detailed Statistics");
					System.out.println("(3) Buy Some Sheep");
					System.out.println("(4) Buy a Guard Dog");
					System.out.println("(5) Sell a Sheep");
					System.out.println("(6) Sell a Guard Dog");
					System.out.println("(7) Enter Night Phase");
					System.out.println("(8) Quit");
				}
			}
			while (userChoice < 0 || userChoice > 8);




			if ( userChoice == 1)
			{
				System.out.println("*** Today's Market Prices ***");
				System.out.println("Buy a Sheep: 25");
				System.out.println("Buy a Dog: 40");
				System.out.println("Sell a Sheep: 10");
				System.out.println("Sell a Dog: 25");
				System.out.println("Wolf Reward Amount: 10");
				System.out.println("Shear a Sheep: 50");
				System.out.println("Amount needed for victory: 1500");
			}

			else if ( userChoice == 2)
			{
				double XX = (nightsSurvived);
				double YY = (double)(userSheep+sheepSold)/(userSheep+sheepSold+sheepLost); //TODO integer divison-remainder?
				double ZZ;
				double AA = 0;
				String SS = null;
				if (dogsPurchased == 0)
				{
					ZZ = 1.0;
				}
				else 
				{
					ZZ = (double)(userDogs+dogsSold)/(userDogs+dogsSold+dogsLost);
				}

				if (userDogs > 0)
				{
					AA = (double)(userSheep/userDogs);
				}
				else
				{
					SS = "undefined";
				}

				System.out.println("***Detailed Statistics***");
				System.out.println("Number of Nights Survived: " + XX);
				System.out.println("Sheep Survival Rate: " + YY);
				System.out.println("Dog Survival Rate: " + ZZ);
				if (userDogs > 0)
				{
					System.out.println("Current Sheep to Dog Ratio: " + AA);
				}
				else
				{
					System.out.println("Current Sheep to Dog Ratio: "+SS);
				}
			}

			else if ( userChoice == 3)
			{
				System.out.print("How many sheep would you like to buy? ");
				do
				{ 
					while (!input.hasNextInt())
					{
						System.out.print("Error: Number of sheep to purchase must be a positive integer! Please try again: ");
						input.next();
					}

					sheepPurchased = input.nextInt();
					if (sheepPurchased < 0)
					{
						System.out.print("Error: Cannot buy a negative number of sheep! Please try again: ");
					}
					else if (sheepPurchased >= 0 && sheepPurchased*SHEEP_PURCHASE_COST <= userFunds)
					{
						userFunds = userFunds - sheepPurchased*SHEEP_PURCHASE_COST;
						userSheep = userSheep+sheepPurchased;
						System.out.println("Sheep Purchase Complete (-"+sheepPurchased*SHEEP_PURCHASE_COST+" doubloons)");
					}
					else 
					{
						System.out.print("You can't afford that many sheep! Please try again: ");
						sheepPurchased = -1;
					}
				}  
				while (sheepPurchased < 0);
			}

			else if ( userChoice == 4)
			{
				if (userFunds >= 40)
				{
					userFunds = userFunds-DOG_PURCHASE_COST;
					userDogs = userDogs+1;
					dogsPurchased++;
					System.out.println("Dog Purchase Complete (-40 doubloons)");
				}
				else
				{
					System.out.println("You can't afford a dog right now!");
				}

			}
			else if ( userChoice == 5)
			{
				if (userSheep >= 2 )
				{
					userFunds = userFunds+SHEEP_SELL_PRICE;
					userSheep = userSheep-1;
					sheepSold = sheepSold+1;
					System.out.println("Sheep Sale Complete (+10 doubloons)");
				}
				else 
				{
					System.out.println("You cannot sell your last sheep!");
				}

			}
			else if ( userChoice == 6)
			{
				if (userDogs > 0)
				{
					userFunds=userFunds+DOG_SELL_PRICE;
					userDogs = userDogs-1;
					dogsSold--;
					System.out.println("Dog Sale Complete (+10 doubloons)");
				}
				else
				{
					System.out.println("You have no dogs to sell!");
				}

			}
			else if ( userChoice == 7)
			{

			}
			else
			{
				System.out.println("Final Number of Doubloons: "+userFunds);
				break;
			} 
		}
		while (userFunds < 1500);




		// Check for Victory, print victory message if satisfied
		// TODO for Milestone 3

		System.out.println();
	} // Bottom of Main Program Loop

	// Print exit message
	// TODO for Milestone 1

} // End of main method
// End of SheepMaster class

//TODO: Remove all TODO comments prior to submission of your project
