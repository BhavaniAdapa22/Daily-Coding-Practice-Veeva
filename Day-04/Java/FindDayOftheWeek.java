import java.util.*;

public class  FindDayOftheWeek{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int date = sc.nextInt();
        int month = sc.nextInt();
        int startDay = sc.nextInt();
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = date - 1;
        for (int i = 0; i < month - 1; i++) {
            totalDays += days[i];
        }
        int result = (startDay + totalDays) % 7;
        String[] week = { "Monday", "Tuesday", "Wednesday","Thursday", "Friday", "Saturday", "Sunday" };
        System.out.println(week[result]);
    }
}
