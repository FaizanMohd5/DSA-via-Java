import java.util.Map;
public class Main
{
	public static void main(String[] args) {
	    
	    for(int i = 1; i <= 1000; i++)
	        System.out.println(i + " :: " + OrdinalNumber.getCardinalNumberOf(i));
	
	}
}


class OrdinalNumber {
    
    private final static Map<Integer, String> map = Map.of(
        1, "st",
        2, "nd",
        3, "rd"
    );
    
    public static String getCardinalNumberOf(int number){
        int lastDigit = number % 10;
        int lastTwoDigits = number % 100;
        if(lastDigit == 0 || lastDigit >= 4 || (lastTwoDigits >= 11 && lastTwoDigits <= 13))
            return number + "th";    
        return number + map.get(lastDigit);
    }
    
}
