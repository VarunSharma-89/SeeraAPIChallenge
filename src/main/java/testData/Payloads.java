package testData;

public class Payloads {
	
	public static String asyncSearchPostData()
	{
		String body ="{" + 
				"  \"checkIn\": \""+CommonTestData.checkIn_current_date+"\"," + 
				"  \"checkOut\": \""+CommonTestData.checkOut_future_date+"\"," + 
				"  \"roomsInfo\": [" + 
				"    {" + 
				"      \"adultsCount\": \""+CommonTestData.adultsCount+"\"" + 
				"    }" + 
				"  ]," + 
				"  \"placeId\": \""+CommonTestData.placeID+"\"" + 
				"}";
		
		return body;
	}
	
	public static String asyncSearch_pastCheckInDate_PostData()
	{
		String body ="{" + 
				"  \"checkIn\": \""+CommonTestData.past_date+"\"," + 
				"  \"checkOut\": \""+CommonTestData.checkOut_future_date+"\"," + 
				"  \"roomsInfo\": [" + 
				"    {" + 
				"      \"adultsCount\": \""+CommonTestData.adultsCount+"\"" + 
				"    }" + 
				"  ]," + 
				"  \"placeId\": \""+CommonTestData.placeID+"\"" + 
				"}";
		
		return body;
	}
	
	public static String asyncSearch_pastCheckOutDate_PostData()
	{
		String body ="{" + 
				"  \"checkIn\": \""+CommonTestData.checkIn_current_date+"\"," + 
				"  \"checkOut\": \""+CommonTestData.past_date+"\"," + 
				"  \"roomsInfo\": [" + 
				"    {" + 
				"      \"adultsCount\": \""+CommonTestData.adultsCount+"\"" + 
				"    }" + 
				"  ]," + 
				"  \"placeId\": \""+CommonTestData.placeID+"\"" + 
				"}";
		return body;
	}
	
	public static String asyncSearch_checkInCheckOutSameDate_PostData()
	{
		String body ="{" + 
				"  \"checkIn\": \""+CommonTestData.checkIn_current_date+"\"," + 
				"  \"checkOut\": \""+CommonTestData.checkIn_current_date+"\"," + 
				"  \"roomsInfo\": [" + 
				"    {" + 
				"      \"adultsCount\": \""+CommonTestData.adultsCount+"\"" + 
				"    }" + 
				"  ]," + 
				"  \"placeId\": \""+CommonTestData.placeID+"\"" + 
				"}";
		return body;
	}
	
	public static String asyncSearch_moreThanMaxGapBetween_checkInCheckOutDate_PostData()
	{
		String body ="{" + 
				"  \"checkIn\": \""+CommonTestData.checkIn_current_date+"\"," + 
				"  \"checkOut\": \""+CommonTestData.invalidGapIn_future_date+"\"," + 
				"  \"roomsInfo\": [" + 
				"    {" + 
				"      \"adultsCount\": \""+CommonTestData.adultsCount+"\"" + 
				"    }" + 
				"  ]," + 
				"  \"placeId\": \""+CommonTestData.placeID+"\"" + 
				"}";
		return body;
	}
	
	public static String asyncSearch_noCheckInDateField_PostData()
	{
		String body ="{" + 
				"  \"checkOut\": \""+CommonTestData.checkOut_future_date+"\"," + 
				"  \"roomsInfo\": [" + 
				"    {" + 
				"      \"adultsCount\": \""+CommonTestData.adultsCount+"\"" + 
				"    }" + 
				"  ]," + 
				"  \"placeId\": \""+CommonTestData.placeID+"\"" + 
				"}";
		return body;
	}
	
	public static String asyncSearch_noCheckOutDateField_PostData()
	{
		String body ="{" + 
				"  \"checkIn\": \""+CommonTestData.checkIn_current_date+"\"," + 
				"  \"roomsInfo\": [" + 
				"    {" + 
				"      \"adultsCount\": \""+CommonTestData.adultsCount+"\"" + 
				"    }" + 
				"  ]," + 
				"  \"placeId\": \""+CommonTestData.placeID+"\"" + 
				"}";
		return body;
	}
	
	public static String asyncSearch_moreThanMax_Adults_PostData()
	{
		String body ="{" + 
				"  \"checkIn\": \""+CommonTestData.checkIn_current_date+"\"," + 
				"  \"checkOut\": \""+CommonTestData.checkOut_future_date+"\"," + 
				"  \"roomsInfo\": [" + 
				"    {" + 
				"      \"adultsCount\": \""+CommonTestData.moreThanMaxAdultsCount+"\"" + 
				"    }" + 
				"  ]," + 
				"  \"placeId\": \""+CommonTestData.placeID+"\"" + 
				"}";
		return body;
	}
	
	public static String asyncSearch_lessThanMin_Adults_PostData()
	{
		String body ="{" + 
				"  \"checkIn\": \""+CommonTestData.checkIn_current_date+"\"," + 
				"  \"checkOut\": \""+CommonTestData.checkOut_future_date+"\"," + 
				"  \"roomsInfo\": [" + 
				"    {" + 
				"      \"adultsCount\": \""+CommonTestData.lessThanMinAdultsCount+"\"" + 
				"    }" + 
				"  ]," + 
				"  \"placeId\": \""+CommonTestData.placeID+"\"" + 
				"}";
		return body;
	}
	
	public static String asyncSearch_noAdultsField_PostData()
	{
		String body ="{" + 
				"  \"checkIn\": \""+CommonTestData.checkIn_current_date+"\"," + 
				"  \"checkOut\": \""+CommonTestData.checkOut_future_date+"\"," + 
				"  \"roomsInfo\": [" + 
				"    {" + 
				"    }" + 
				"  ]," + 
				"  \"placeId\": \""+CommonTestData.placeID+"\"" + 
				"}";
		return body;
	}
	
	public static String asyncSearch_invalidPlaceID_PostData()
	{
		String body ="{" + 
				"  \"checkIn\": \""+CommonTestData.checkIn_current_date+"\"," + 
				"  \"checkOut\": \""+CommonTestData.checkOut_future_date+"\"," + 
				"  \"roomsInfo\": [" + 
				"    {" + 
				"      \"adultsCount\": \""+CommonTestData.adultsCount+"\"" + 
				"    }" + 
				"  ]," + 
				"  \"placeId\": \""+CommonTestData.invalid_PlaceID+"\"" + 
				"}";
		return body;
	}
	
	public static String asyncSearch_noPlaceIDField_PostData()
	{
		String body ="{" + 
				"  \"checkIn\": \""+CommonTestData.checkIn_current_date+"\"," + 
				"  \"checkOut\": \""+CommonTestData.checkOut_future_date+"\"," + 
				"  \"roomsInfo\": [" + 
				"    {" + 
				"      \"adultsCount\": \""+CommonTestData.adultsCount+"\"" + 
				"    }" + 
				"  ]" + 
				"}";
		return body;
	}

}
