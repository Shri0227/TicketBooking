import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatBook {
	
	static Map<Integer,List<String>> bookedSeatMap = new HashMap<>();
	public void audi1Seats(Map<Integer,List<String>> bookedSeatMap, String[] seatsArrays){
		List<String> bookedSeats = bookedSeatMap.get(1);
		if(null == bookedSeats)
			bookedSeats = new ArrayList<>();
		bookedSeats.addAll(Arrays.asList(seatsArrays));
		Arrays.asList(seatsArrays).stream().forEach(s -> {
			if(s.startsWith("A"))
				Constants.show1Total = Constants.show1Total + Constants.platinumPrice;
			else if(s.startsWith("B"))
				Constants.show1Total = Constants.show1Total + Constants.goldPrice;
			else if(s.startsWith("C"))
				Constants.show1Total = Constants.show1Total + Constants.silverPrice;
		});
		Constants.totalCost = Constants.totalCost + Constants.show1Total;
		bookedSeatMap.put(1, bookedSeats);
	}
	public void audi2Seats(Map<Integer,List<String>> bookedSeatMap, String[] seatsArrays){
		List<String> bookedSeats = bookedSeatMap.get(2);
		if(null == bookedSeats)
			bookedSeats = new ArrayList<>();
		bookedSeats.addAll(Arrays.asList(seatsArrays));
		
		Arrays.asList(seatsArrays).stream().forEach(s -> {
			if(s.startsWith("A"))
				Constants.show2Total = Constants.show2Total + Constants.platinumPrice;
			else if(s.startsWith("B"))
				Constants.show2Total = Constants.show2Total + Constants.goldPrice;
			else if(s.startsWith("C"))
				Constants.show2Total = Constants.show2Total + Constants.silverPrice;
		});
		
		Constants.totalCost = Constants.totalCost + Constants.show2Total;
		bookedSeatMap.put(2, bookedSeats);
	}
	public void audi3Seats(Map<Integer,List<String>> bookedSeatMap, String[] seatsArrays){
		List<String> bookedSeats = bookedSeatMap.get(2);
		if(null == bookedSeats)
			bookedSeats = new ArrayList<>();
		bookedSeats.addAll(Arrays.asList(seatsArrays));
		
		Arrays.asList(seatsArrays).stream().forEach(s -> {
			if(s.startsWith("A"))
				Constants.show3Total = Constants.show3Total + Constants.platinumPrice;
			else if(s.startsWith("B"))
				Constants.show3Total = Constants.show3Total + Constants.goldPrice;
			else if(s.startsWith("C"))
				Constants.show3Total = Constants.show3Total + Constants.silverPrice;
		});
		Constants.totalCost = Constants.totalCost + Constants.show3Total;
		bookedSeatMap.put(3, bookedSeats);
	}
	
	public void operateShow1(String[] seatsArrays, Map<Integer,List<String>> allseatMap){
		boolean show1Flag = true;
		for(String str1 : Arrays.asList(seatsArrays)){
			if(!allseatMap.get(1).contains(str1)){
				System.out.println("Wrong seats entered :"+str1);
				show1Flag = false;
			}
		}
		List<String> bookedSeats = bookedSeatMap.get(1);
		boolean flag = true;
		for(String str : Arrays.asList(seatsArrays)){
			if(null != bookedSeats && bookedSeats.contains(str)){
				System.out.println(str+" is not available, please select different seats");
				flag = false;
			}
		}
		if(flag && show1Flag){
			audi1Seats(bookedSeatMap, seatsArrays);
			System.out.println("Successfuly booked - Show 1");
			System.out.println("SubTotal : "+Constants.show1Total);
			
			//double serviceTax = (14/100)*Constants.show1Total;
			double servceTax1 = (14*Constants.show1Total)/100;
			double swatch1 = (0.5*Constants.show1Total)/100;
			double krishi1 = (0.5*Constants.show1Total)/100;
			System.out.println("Service Tax @14%: Rs. "+servceTax1);
			System.out.println("Swatch Bharat Cess @0.5%: Rs. "+swatch1);
			System.out.println("Krishhi Kalyan Cess @0.5%: Rs. "+krishi1);
			
			System.out.println("Total : "+(Constants.show1Total + servceTax1 + swatch1 + krishi1));
		}
		
	}
	
	public void operateShow2(String[] seatsArrays, Map<Integer,List<String>> allseatMap){
		boolean show2Flag = true;
		for(String str1 : Arrays.asList(seatsArrays)){
			if(!Constants.audi2Seats.contains(str1)){
				System.out.println("Wrong seats entered :"+str1);
				show2Flag = false;
			}
		}
		List<String> booked2Seats = bookedSeatMap.get(2);
		boolean flag2 = true;
		
		for(String str1 : Arrays.asList(seatsArrays)){
			if(null != booked2Seats && booked2Seats.contains(str1)){
				System.out.println(str1+" is not available, please select different seats");
				flag2= false;
			}
		}
		if(flag2 && show2Flag){
			audi2Seats(bookedSeatMap, seatsArrays);
			System.out.println("Successfuly booked - Show 2");
			System.out.println("SubTotal : "+Constants.show2Total);
			
			double servceTax2 = (14*Constants.show2Total)/100;
			double swatch2 = (0.5*Constants.show2Total)/100;
			double krishi2 = (0.5*Constants.show2Total)/100;
			System.out.println("Service Tax @14%: Rs. "+servceTax2);
			System.out.println("Swatch Bharat Cess @0.5%: Rs. "+swatch2);
			System.out.println("Krishhi Kalyan Cess @0.5%: Rs. "+krishi2);
			
			System.out.println("Total : "+(Constants.show2Total + servceTax2 + swatch2 + krishi2));
		}
	} 
	public void operateShow3(String[] seatsArrays, Map<Integer,List<String>> allseatMap){
		boolean show3Flag = true;
		for(String str3 : Arrays.asList(seatsArrays)){
			if(!Constants.audi3Seats.contains(str3)){
				System.out.println("Wrong seats entered: "+str3);
				show3Flag = false;
			}
		}
		List<String> booked3Seats = bookedSeatMap.get(3);
		boolean flag3 = true;
		for(String str3 : Arrays.asList(seatsArrays)){
			if(null != booked3Seats && booked3Seats.contains(str3)){
				System.out.println(str3+" is not available, please select different seats");
				flag3 = false;
			}
		}
		if(flag3 && show3Flag){
			audi3Seats(bookedSeatMap, seatsArrays);
			System.out.println("Successfuly booked - Show 3");
			System.out.println("SubTotal : "+Constants.show3Total);
		
			double servceTax3 = (14*Constants.show3Total)/100;
			double swatch3 = (0.5*Constants.show3Total)/100;
			double krishi3 = (0.5*Constants.show3Total)/100;
			System.out.println("Service Tax @14%: Rs. "+servceTax3);
			System.out.println("Swatch Bharat Cess @0.5%: Rs. "+swatch3);
			System.out.println("Krishhi Kalyan Cess @0.5%: Rs. "+krishi3);
			
			System.out.println("Total : "+(Constants.show1Total + servceTax3 + swatch3 + krishi3));
		}
	}
}
