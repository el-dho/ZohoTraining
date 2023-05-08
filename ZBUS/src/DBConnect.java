import java.sql.*;
import java.util.*;

public class DBConnect {
	private Connection con;
	private String url = "jdbc:mysql://localhost:3306/ZBUS";
	private String username = "root";
	private String password = "";
	
	public DBConnect() {
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Successfully Connected");
		} catch (SQLException e) {
			System.out.println("Error in Connection:" + e);
			System.exit(0);
		}
		
	}
	
	public void signUp(User u) {
		String sql = "INSERT INTO USERS(ID,NAME,NUM,AGE,GENDER) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, u.getId());
			st.setString(2, u.getName());
			st.setString(3, u.getNum());
			st.setInt(4, u.getAge());
			st.setString(5, u.getGender());
			st.executeUpdate();
			System.out.println("User added to database");
			
		} catch (SQLException e) {
			System.out.println("User not added to database: "+e);		
		}
	}

	public boolean logIn(int username, String password) {
			String sql = "SELECT * FROM USERS";
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					if((rs.getInt("ID") == username) && (rs.getString("NUM").equals(password))){
						System.out.println("ID: " + rs.getInt("ID"));
						System.out.println("NAME: " + rs.getString("NAME"));
						System.out.println("NUM: " + rs.getString("NUM"));
						System.out.println("AGE: " + rs.getInt("AGE"));
						System.out.println("GENDER: " + rs.getString("GENDER"));
						return true;
					}
					
					else if(rs.isLast()) {
						System.out.println("No user exists");
						return false;
					}
				}
			} catch (SQLException e) {
				System.out.println("Could not log in: " + e);
				return false;
			}
			return false;
	}

	public void getRemainingSeats() {
				String sql = "SELECT B.BUS_ID,B.BUS_NAME,A.AVAILABLE_SEATS FROM BUSES B LEFT JOIN (SELECT BUS_ID, COUNT(SEAT_ID) AS AVAILABLE_SEATS FROM SEATS WHERE SEAT_AVAILABILITY = 'AVAILABLE' GROUP BY BUS_ID) AS A ON B.BUS_ID = A.BUS_ID";
				try {
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					while(rs.next()) {
						System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getInt(3) + " seats");
					}
				} catch (SQLException e) {
					System.out.println("Cannot fetch details:" + e);
				}
				
	}

	public int getRemainingSeats(int bus_id) {
				String sql = "SELECT COUNT(SEAT_ID) FROM SEATS WHERE BUS_ID = " +  bus_id;
				try {
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					rs.next();
					return rs.getInt(1);
				} catch (SQLException e) {
					System.out.println("Cannot get remaining seats of the bus:" + e);
				}
				return 0;
	}

	public int getFare(int bus_id) {
				String sql = "SELECT FARE FROM BUSES WHERE BUS_ID = "+ bus_id;
				try {
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					rs.next();
					return rs.getInt(1);
				} catch (SQLException e) {
					System.out.println("Cannot fetch bus id:" + e);
				}
				return 0;
	}

	
	public ArrayList<String> getSeats(int bus_id) {
				String sql = "SELECT SEAT_ID FROM SEATS WHERE SEAT_AVAILABILITY = 'AVAILABLE' AND BUS_ID = " + bus_id;
				ArrayList<String> availableSeats = new ArrayList<>();
				try {
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					while(rs.next()) {
						availableSeats.add(rs.getString(1));
					}
					return availableSeats;
				} catch (SQLException e) {					
					System.out.println("Cannot fetch seats:" + e);
				}
				
				return null;
	}

	public void addPassengers(int bus_id, ArrayList<String> passengerNames, ArrayList<String> passengerGender,
			ArrayList<String> availableSeats, int BookingId, String user) {
				String sql = "UPDATE SEATS SET PASSENGER_NAME = ?, PASSENGER_GENDER = ?, SEAT_AVAILABILITY = 'UNAVAILABLE', BOOKING_ID = ?, ID = ? WHERE SEAT_ID = ? AND BUS_ID = ?";
				try{
					PreparedStatement st = con.prepareStatement(sql);
					for(int i = 0; i<passengerNames.size();i++) {
						st.setString(1, passengerNames.get(i));
						st.setString(2, passengerGender.get(i));
						st.setInt(3, BookingId);
						st.setInt(4, Integer.parseInt(user));
						st.setString(5, availableSeats.get(i));
						st.setInt(6, bus_id);
						st.executeUpdate();
					}
					System.out.println("Successfully Booked Seats");
				}
				catch(SQLException e) {
					System.out.println("Error in booking tickets:" + e);
		
				}
	}

	public int lastBookingId() {
				String sql = "SELECT MAX(BOOKING_ID) FROM BOOKINGS";
				try {
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					rs.next();
					return rs.getInt(1);
				} catch (SQLException e) {
					System.out.println("Error in getting the last Booking Id:" + e);
				}
				return 0;
	}

	public void addBooking(int bookingId, String user, int totalFare, int busID) {
				String sql = "INSERT INTO BOOKINGS VALUES (?,?,?,?,?)";
				try {
					PreparedStatement st = con.prepareStatement(sql);
					st.setInt(1, bookingId);
					st.setInt(2, Integer.parseInt(user));
					st.setInt(3, totalFare);
					st.setString(4, "CONFIRMED");
					st.setInt(5, busID);
					st.executeUpdate();
				} catch (SQLException e) {
					System.out.println("Error in adding booking details:" + e);
				}
				
	}

	public ArrayList<String> getBookedSeats(String user) {
				ArrayList<String>bookedSeats = new ArrayList<>();
				String sql = "SELECT SEAT_ID FROM SEATS WHERE BOOKING_ID IN (SELECT BOOKING_ID FROM BOOKINGS WHERE ID = " + user + ")";
				try {
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					while(rs.next()) {
						bookedSeats.add(rs.getString(1));
					}
					return bookedSeats;
				} catch (SQLException e) {
					System.out.println("Error in getting booked seats:" + e);
				}
				return null;
	}

	public void cancelAllSeats(String user) {
		String sql = "UPDATE SEATS SET PASSENGER_NAME = NULL, PASSENGER_GENDER = NULL, SEAT_AVAILABILITY = 'AVAILABLE', BOOKING_ID = NULL, ID = NULL WHERE ID = " + user;
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Error in cancelling all seats: " + e);
		}
	}
	
	public void cancelAllBookings(String user) {
				String sql = "UPDATE BOOKINGS BO JOIN BUSES BU ON BO.BUS_ID = BU.BUS_ID SET BO.BOOKING_STATUS = 'CANCELLED', BO.TOTAL_FARE_COLLECTED = BO.TOTAL_FARE_COLLECTED * BU.CANCELLATION_FEES / 100 WHERE BO.ID = " + user;
				try {
					Statement st = con.createStatement();
					st.executeUpdate(sql);
				} catch (SQLException e) {
					System.out.println("Error in cancelling all bookings: "+ e);
				}
				
				
	}

	public void cancelSeats(ArrayList<String> seatsToCancel, String user) {
				
				String sql = "UPDATE SEATS SET PASSENGER_NAME = NULL, PASSENGER_GENDER = NULL, SEAT_AVAILABILITY = 'AVAILABLE', BOOKING_ID = NULL, ID = NULL WHERE ID = ? AND SEAT_ID = ?";
				try {
						PreparedStatement st = con.prepareStatement(sql);
						for(int i = 0; i<seatsToCancel.size();i++) {
							st.setInt(1,Integer.parseInt(user));
							st.setString(2,seatsToCancel.get(i));
							st.executeUpdate();
						}
				} catch (SQLException e) {
						System.out.println("Error in cancelling selected seats: " + e);
				}
			
				
	}
	
	public ArrayList<Integer> getCancelBusId(ArrayList<String> seatsToCancel, String user) {
		HashSet<Integer>cancelBusId = new HashSet<>();
		String sql = "SELECT BUS_ID FROM SEATS WHERE SEAT_ID = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			for(int i = 0; i< seatsToCancel.size();i++) {
				st.setString(1, seatsToCancel.get(i));
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					cancelBusId.add(rs.getInt(1));
				}
				
			}
			return new ArrayList<>(cancelBusId);
		} catch (SQLException e) {
			System.out.println("Error in getting bus_id's with cancelled tickets: "+ e);
		}
		return null;
	}


	public void updateBookings(String user, int cancelNo, ArrayList<Integer> cancelBusId) {
				String sql = "UPDATE BOOKINGS BO JOIN BUSES BU ON BO.BUS_ID = BU.BUS_ID SET BO.BOOKING_STATUS = 'PARTIAL', BO.TOTAL_FARE_COLLECTED = BO.TOTAL_FARE_COLLECTED - (? * BU.FARE * (1-(BU.CANCELLATION_FEES/100))) WHERE BO.BUS_ID = ? AND ID = ?";
				
				try {
					PreparedStatement st = con.prepareStatement(sql);
					for (int i = 0 ; i< cancelBusId.size();i++) {
						st.setInt(1,cancelNo);
						st.setInt(2,cancelBusId.get(i));
						st.setInt(3,Integer.parseInt(user));
						st.executeUpdate();
					}
				} catch (SQLException e) {
					System.out.println("Error in updating bookings after cancellation: " + e);
				}
				
	}

	public void getRemainingSeats(String keyword) {
				String sql = "SELECT A.BUS_ID,B.BUS_NAME, A.AVAILABLE_SEATS FROM BUSES B RIGHT JOIN (SELECT S.BUS_ID, COUNT(S.SEAT_ID) AS AVAILABLE_SEATS FROM SEATS S WHERE S.SEAT_AVAILABILITY = 'AVAILABLE' GROUP BY S.BUS_ID) AS A ON A.BUS_ID = B.BUS_ID WHERE B.BUS_NAME LIKE ? ORDER BY AVAILABLE_SEATS DESC,BUS_NAME ASC";
				try {
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1,keyword);
					ResultSet rs = st.executeQuery();
					while(rs.next()) {
						System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getInt(3) + " seats");
					}
				} catch (SQLException e) {
					System.out.println("Error in getting remaining seats: " + e);
				}
		
	}

	public void getBusName(String user) {
				String sql = "SELECT BU.BUS_NAME FROM BOOKINGS BO JOIN BUSES BU ON BO.BUS_ID = BU.BUS_ID WHERE BO.ID = " + user;
				try {
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					rs.next();
					System.out.println(rs.getString(1));
				} catch (SQLException e) {
					System.out.println("Error in getting bus name: " + e);
				}
	}

	public void getSeatsFilled(String user) {
				String sql = "SELECT COUNT(PASSENGER_NAME) FROM SEATS WHERE ID = " + user;
				try {
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					rs.next();
					System.out.println("Number of seats booked: "+ rs.getString(1));
				} catch (SQLException e) {
					System.out.println("Error in getting seats booked: " + e);
				}
		
	}

	public void getTotalFareCollected(String user) {
				String sql = "SELECT TOTAL_FARE_COLLECTED, BOOKING_STATUS FROM BOOKINGS WHERE ID = " + user;
				try {
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					rs.next();
					System.out.println("Total Fare Collected: "+ rs.getString(1));
					System.out.println("Booking Status: " + rs.getString(2));
				} catch (SQLException e) {
					System.out.println("Error in getting Collected Fare and Status: " + e);
				}
	}

	public void getBookedSeatsDetails(String user) {
				System.out.println("Seat Details: ");
				String sql = "SELECT SEAT_ID,PASSENGER_NAME,PASSENGER_GENDER FROM SEATS WHERE SEAT_AVAILABILITY = 'UNAVAILABLE' AND ID = " + user;
				try {
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					while(rs.next()) {
						System.out.println(rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3));
					}
				} catch (SQLException e) {
					System.out.println("Error in getting booked seat details of bus: " + e);
				}
	}

	
	
}
	

