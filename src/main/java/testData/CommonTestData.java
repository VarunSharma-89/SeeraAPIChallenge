package testData;

import java.time.LocalDate;
import java.util.Random;

public class CommonTestData {
	
	public static Random random = new Random();
	public static int random_number = random.nextInt(30);
	public static int random_adultsCount = random.nextInt(7);
	
	public static String hotel_token = "skdjfh73273$7268u2j89s";
	public static String contentType_Json = "application/json";
	public static String invalid_hotel_token = "skdjfh73273$7268u2j8";
	
	public static LocalDate checkIn_current_date = LocalDate.now();
	public static LocalDate checkOut_future_date = checkIn_current_date.plusDays(24);
	public static LocalDate past_date = checkIn_current_date.minusDays(2);
	public static LocalDate invalidGapIn_future_date = checkIn_current_date.plusDays(31);
	
	public static int adultsCount = random_adultsCount+1;
	public static int moreThanMaxAdultsCount = 9;
	public static int lessThanMinAdultsCount = 0;
	
	public static String placeID = "ChIJufI-cg9EXj4RCBGXQZMuzMc";
	public static String invalid_PlaceID = "ChIJufI-cg9EXj4RCBGXQZMuM";
	
	public static int pageSize = random_number+1;
	public static int invalid_pageSize = 0;
	

}
