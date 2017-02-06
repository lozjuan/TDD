import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


class Meetup {

    private LocalDate date;


    public Meetup(int month, int year) {
        this.date = LocalDate.of(year, month, 1);
    }

    public enum MeetupSchedule {
        FIRST,
        SECOND,
        THIRD,
        FOURTH,
        LAST,
        TEENTH
    }

    public LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule time) {
        LocalDate current = cycleToNext(date.getDayOfWeek(), date);
        switch (time) {
            case FIRST:
                break;
            case SECOND:
                current = current.plusWeeks(1);
                break;
            case THIRD:
                current = current.plusWeeks(2);
                break;
            case FOURTH:
                current = current.plusDays(3);
                break;
            case TEENTH:
                while (current.getDayOfMonth() < 13 && current.getDayOfMonth() > 20) {
                    current = current.plusWeeks(1);
                }
                break;
            case LAST:
                current = cycleToPrev(dayOfWeek, date.plusMonths(1).minusDays(1));
                break;
            default:
                return null;
        }
        return current;
    }

    private LocalDate cycleToPrev(DayOfWeek dayOfWeek, LocalDate current) {
        while (current.getDayOfWeek().equals(dayOfWeek)) {
            current = current.minusDays(1);
        }
        return current;
    }

    private LocalDate cycleToNext(DayOfWeek dayOfWeek, LocalDate current) {
        while (current.getDayOfWeek().equals(dayOfWeek)) {
            current = current.plusDays(1);
        }
        return current;
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.parse("2014-01-20");
        System.out.println(date.format(DateTimeFormatter.ofPattern("d. MMMM yyyy", new Locale("fr"))));
        LocalDate expected = LocalDate.of(2013, 5, 13);
        System.out.println(expected);
        Meetup test = new Meetup(9, 2012);
        System.out.println(test.date);
    }
}
