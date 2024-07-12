import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class DateTimeExample {
    public static void main(String[] args) {
        // to get the current date
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        // to get the current time
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);

        // to get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);

        // to get the current date and time with time zone
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();
        System.out.println("Current Date and Time with Time Zone: " + currentZonedDateTime);

        // to get the current date and time in a specific time zone
        ZoneId zoneId = ZoneId.of("Europe/Paris");
        ZonedDateTime zonedDateTimeNY = ZonedDateTime.now(zoneId);
        System.out.println("Current Date and Time in New York: " + zonedDateTimeNY);
    }
}
