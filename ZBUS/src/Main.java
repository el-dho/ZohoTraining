import java.util.*;

public class Main {

	public static void main(String[] args) {
		boolean loggedIn = false;
		String option;
		String input;
		String user = null;
		Scanner sc = new Scanner(System.in);
		DBConnect db = new DBConnect();
		while(!loggedIn) {
			System.out.println("1. Sign Up");
			System.out.println("2. Log In");
			System.out.println("Enter option: ");
			option = sc.nextLine();
			
			if(option.equals("1")) {
				System.out.println("Enter the User Details(ID NAME NUM AGE GENDER)");
				input = sc.nextLine();
				String[] values = input.split(" ");
				User u = new User(Integer.parseInt(values[0]),values[1],values[2],Integer.parseInt(values[3]),values[4]);
				db.signUp(u);
			}
			
			else if(option.equals("2")) {
				System.out.println("Enter usernane and password(USERNAME PASSWORD)");
				input = sc.nextLine();
				String[] values = input.split(" ");
				user = values[0];
				loggedIn = db.logIn(Integer.parseInt(values[0]),values[1]);
			}
			
			else {
				System.out.println("Please Enter Valid Option");
			}
			
		}
		
		while(loggedIn) {
			System.out.println("1. Book Ticket");
			System.out.println("2. Cancel Ticket");
			System.out.println("3. Filter View");
			System.out.println("4. Bus Summary");
			System.out.println("5. Log Out");
			System.out.println("Enter option:");
			option = sc.nextLine();
			
			if(option.equals("1")) {
				System.out.println("Enter the number of passengers: ");
				int passengers = Integer.parseInt(sc.nextLine());
				while(true) {
					db.getRemainingSeats();
					System.out.println("Enter the bus to choose:");
					int bus_id = Integer.parseInt(sc.nextLine());
					int seats = db.getRemainingSeats(bus_id);
					if(seats<passengers) {
						System.out.println("No seats available in the bus");
						continue;
					}
					int bus_fare = db.getFare(bus_id);
					System.out.println("The total fare will be: " + (bus_fare * passengers));
					System.out.println("Do you wish to confirm(Y/N):");
					option = sc.nextLine();
					if(option.equals("Y")) {
						ArrayList<String> availableSeats = db.getSeats(bus_id);
						ArrayList<String> passengerNames = new ArrayList<>();
						ArrayList<String> passengerGender = new ArrayList<>();
						for(int i = 1; i <= passengers ; i++) {
							System.out.println("Enter Passenger " + i + " Name:");
							String name = sc.nextLine();
							passengerNames.add(name);
							System.out.println("Enter Passenger " + i + " Gender:");
							String gender = sc.nextLine();
							passengerGender.add(gender);
						}
						int lastBookingId = db.lastBookingId();
						db.addPassengers(bus_id,passengerNames,passengerGender,availableSeats,lastBookingId + 1,user);
						db.addBooking(lastBookingId + 1, user, bus_fare * passengers,bus_id);
						System.out.println("Booking Completed");
						break;
					}
					else if (option.equals("N")) {
						break;
					}
				}
				
			}
			
			else if(option.equals("2")) {
					ArrayList<String>bookedSeats = db.getBookedSeats(user);
					if(bookedSeats.isEmpty()) {
						System.out.println("No confirmed tickets present");
						continue;
					}
					System.out.println("Booked Seats: " + bookedSeats);
					System.out.println("Full Cancel(Y/N)");
					option = sc.nextLine();
					if(option.equals("Y")) {
						db.cancelAllSeats(user);
						db.cancelAllBookings(user);
						System.out.println("All booked seats cancelled");
					}
					else if(option.equals("N")) {
						ArrayList<String>seatsToCancel = new ArrayList<>();
						System.out.println("Enter the number of seats to be cancelled");
						int cancelNo = Integer.parseInt(sc.nextLine());
						for(int i = 1; i <= cancelNo; i++) {
							System.out.println("Enter seat " + i);
							seatsToCancel.add(sc.nextLine());
						}
						db.cancelSeats(seatsToCancel,user);
						ArrayList<Integer> cancelBusId = db.getCancelBusId(seatsToCancel,user);
						db.updateBookings(user,cancelNo, cancelBusId);
						System.out.println("Seats Partially Cancelled");
						
					}
			}
			
			else if(option.equals("3")) {
				boolean filterOn = true;
				String keyword;
				while(filterOn) {
					System.out.println("1. AC");
					System.out.println("2. NON-AC");
					System.out.println("3. SLEEPER");
					System.out.println("4. SEATER");
					System.out.println("5. ALL");
					System.out.println("6. BACK");
					input = sc.nextLine();
					if(input.equals("1")) {
						System.out.println("1. FILTER");
						System.out.println("2. SLEEPER");
						System.out.println("3. SEATER");
						input = sc.nextLine();
						if(input.equals("1")) {
							keyword = "AC%";
							db.getRemainingSeats(keyword);
						}
						else if (input.equals("2")) {
							keyword = "AC SLEEPER";
							db.getRemainingSeats(keyword);
						}
						else if (input.equals("3")) {
							keyword = "AC SEATER";
							db.getRemainingSeats(keyword);
						}
					}
					
					else if(input.equals("2")) {
						System.out.println("1. FILTER");
						System.out.println("2. SLEEPER");
						System.out.println("3. SEATER");
						input = sc.nextLine();
						if(input.equals("1")) {
							keyword = "NON-AC%";
							db.getRemainingSeats(keyword);
						}
						else if (input.equals("2")) {
							keyword = "NON-AC SLEEPER";
							db.getRemainingSeats(keyword);
						}
						else if (input.equals("3")) {
							keyword = "NON-AC SEATER";
							db.getRemainingSeats(keyword);
						}
					}
					
					else if(input.equals("3")) {
						System.out.println("1. FILTER");
						System.out.println("2. AC");
						System.out.println("3. NON-AC");
						input = sc.nextLine();
						if(input.equals("1")) {
							keyword = "%SLEEPER";
							db.getRemainingSeats(keyword);
						}
						else if (input.equals("2")) {
							keyword = "AC SLEEPER";
							db.getRemainingSeats(keyword);
						}
						else if (input.equals("3")) {
							keyword = "NON-AC SLEEPER";
							db.getRemainingSeats(keyword);
						}
					}
					
					else if(input.equals("4")) {
						System.out.println("1. FILTER");
						System.out.println("2. AC");
						System.out.println("3. NON-AC");
						input = sc.nextLine();
						if(input.equals("1")) {
							keyword = "%SEATER";
							db.getRemainingSeats(keyword);
						}
						else if (input.equals("2")) {
							keyword = "AC SEATER";
							db.getRemainingSeats(keyword);
						}
						else if (input.equals("3")) {
							keyword = "NON-AC SEATER";
							db.getRemainingSeats(keyword);
						}
					}
					
					else if(input.equals("5")) {
						keyword = "%%";
						db.getRemainingSeats(keyword);
					}
					
					else if(input.equals("6")) {
						filterOn = false;
					}
					
				}
			}
			else if(option.equals("4")) {
				db.getBusName(user);
				db.getSeatsFilled(user);
				db.getTotalFareCollected(user);
				db.getBookedSeatsDetails(user);
			}
			
			else if(option.equals("5")) {
				loggedIn = false;
			}
			
		}
		
	}

}
