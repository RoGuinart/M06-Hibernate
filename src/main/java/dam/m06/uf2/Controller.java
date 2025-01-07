/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

package dam.m06.uf2;

import java.util.List;
import java.util.Scanner;

public class Controller
{
	public static void mainLoop()
	{
		int choice;
		boolean loop = true;
		Scanner in = new Scanner(System.in);

		DAO.tearUp();

		while(loop) {

			choice = View.menu(in);
			switch (choice) {
			case 1: // Add new sport
			{
				Sport spt = View.SportForm(in);
				DAO.addSport(spt);
				break;
			}
			case 2: // Add new athlete
			{
				Athlete ath = View.AthleteForm(in, DAO.getSports());
			
				if(ath != null)
					DAO.addAthlete(ath);
			
				break;
			}
			case 3: // Search athletes by name
			{
				String name = View.AskAthleteName(in);

				List<Athlete> found = DAO.findAthletesByName(name);

				View.AthleteList(found);
				break;
			}
			case 4: // List athletes by sport
			{
				Sport sport = View.askSport(in, DAO.getSports());

				if(sport == null)
					break;

				List<Athlete> found = DAO.findAthletesWithSport(sport);

				View.AthleteList(found);
				break;
			}
			case 5: // Show all sports
			{
				View.SportsList(DAO.getSports(), false);
				break;
			}
			case 6: // Show all athletes and the sports they practise
			{
				View.AthleteList(DAO.getAthletes());
				break;
			}
			case 0: // Quit
			{
				System.out.println("Shutting down...");
				loop = false;
				break;
			}
			default:
				System.err.println("Invalid input.");
			}
		}

		DAO.tearDown();
	}
}
