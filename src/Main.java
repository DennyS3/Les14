
import java.time.LocalDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Revers rev = new Revers();
            System.out.println("Enter date in the format: dd.MM.YYYY");
            String data = scanner.nextLine();
            getDayOfWeek(data);
            System.out.print("Дата следующего вторника от текущей даты: ");
            getNextTuesday();
            System.out.println("to call revers enter \"1\":");
            String str = scanner.nextLine();
            if ("1".equals(str)) {
                System.out.println("enter text to revers");
                str = scanner.nextLine();
                rev.revers(str);
            } else {
                System.out.println("okay");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void getDayOfWeek(String strDate) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateDate = LocalDate.parse(strDate, format);
        System.out.println(dateDate.getDayOfWeek());
    }

    public static void getNextTuesday() {
        int dayWeek = 3;
        Calendar dayNow = Calendar.getInstance();
        int numberWeekDay = dayNow.get(Calendar.DAY_OF_WEEK);
        int dayDif = dayWeek - numberWeekDay;
        if (dayDif < 0) {
            dayDif += 7;
        }
        dayNow.add(Calendar.DAY_OF_YEAR, dayDif);
        Date date = dayNow.getTime();
        System.out.println(new SimpleDateFormat("EEEE, dd.MM.yyyy").format(date));
    }

}
        /*Основное задание
        1. Написать программу для вывода на консоль названия дня недели по
        введенной дате.
        2. Написать программу для вывода на экран дату следующего вторника.
        Дополнительное задание
        3. Создать обобщенный функциональный интерфейс.
        Написать класс с одним методом.
        В этом методе реализуйте логику:
        - если в консоль введена цифра 1, то: использования интерфейса со
        строковым типом и передать в метод интерфейса логику реверса
        строки(вывода строки в обратном порядке).*/