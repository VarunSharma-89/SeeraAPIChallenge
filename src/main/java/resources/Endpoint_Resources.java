package resources;

public class Endpoint_Resources {
	
/*************************************************************************************************************************
*****************************************Hotel Module Endpoints***********************************************************
*************************************************************************************************************************/
	
	public static String asyncSearchHotelPostEndpoint()
	{	
		String res="enigma/search/async";
		return res;
	}
	
	public static String asyncSearchHotelInvalidPostEndpoint()
	{	
		String res="enigma/searchh/async";
		return res;
	}
	
	public static String searchHotelsGetEndpoint()
	{
		String res="enigma/content/hotels/summaries";
		return res;
	}
	
	public static String searchHotelsInvalidGetEndpoint()
	{
		String res="enigma/content/hotelss/summaries";
		return res;
	}
}
