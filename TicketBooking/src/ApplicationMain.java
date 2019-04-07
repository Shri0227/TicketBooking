import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Application to book the shows for different theatre
public class ApplicationMain {
	public static void main(String[] args) {
		String input = null;
		Map<Integer,List<String>> allseatMap = new HashMap<>();
		allseatMap.put(1, Arrays.asList("A1","A2","A3","A4","A5","A6","A7","A8","A9","B1","B2","B3","B4","B5","B5","C2","C3","C4","C5","C6","C7"));
		allseatMap.put(2, Arrays.asList("A1","A2","A3","A4","A5","A6","A7","B2","B3","B4","B5","B5","B6","C1","C2","C3","C4","C5","C6","C7"));
		allseatMap.put(3, Arrays.asList("A1","A2","A3","A4","A5","B1","B2","B3","B4","B5","B5","B6","B7","B8","C1","C2","C3","C4","C5","C6","C7","C8","C9"));
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do{
				System.out.println("Enter Show no : ");
				int showNo = Integer.valueOf(br.readLine());
				System.out.println("Enter seats : ");
				String inputSeats = br.readLine();
				String[] seatsArrays = inputSeats.split(" ");
				SeatBook seatBook = new SeatBook();
				switch(showNo){
				case 1:
					seatBook.operateShow1(seatsArrays, allseatMap);
					break;
				case 2:
 					seatBook.operateShow2(seatsArrays, allseatMap);
					break;
				case 3:
					seatBook.operateShow3(seatsArrays, allseatMap);
					break;
				default:
					System.out.println("Wrong show number entered");
				}
				System.out.println("please 'y' to continue else n ");
				input = br.readLine();
			}while("y".equals(input));
			System.out.println("Total Sales: ");
			System.out.println("Revenue : "+Constants.totalCost);
			System.out.println("Service Tax : Rs. "+(14*Constants.totalCost)/100);
			System.out.println("Swatch Bharat Cess : Rs. "+(0.5*Constants.totalCost)/100);
			System.out.println("Krishhi Kalyan Cess : Rs. "+(0.5*Constants.totalCost)/100);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
