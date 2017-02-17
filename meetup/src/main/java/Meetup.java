import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Meetup {

    private int month;
    private int year;


    public Meetup(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public enum MeetupSchedule {
        FIRST,
        SECOND,
        THIRD,
        FOURTH,
        LAST,
        TEENTH
    }

    public LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule meetupSchedule) {
        List<Integer> daysOfWeek = getDaysOfWeek(year, month, dayOfWeek);

        switch (meetupSchedule) {
            case FIRST:
                return LocalDate.of(this.year, this.month, daysOfWeek.get(0));
            case SECOND:
                return LocalDate.of(this.year, this.month, daysOfWeek.get(1));
            case THIRD:
                return LocalDate.of(this.year, this.month, daysOfWeek.get(2));
            case FOURTH:
                return LocalDate.of(this.year, this.month, daysOfWeek.get(3));
            case TEENTH:
                return getTeenthDate(daysOfWeek);
            case LAST:
                return LocalDate.of(this.year, this.month, daysOfWeek.get(daysOfWeek.size() - 1));
            default:
                return null;
        }
    }

    private List<Integer> getDaysOfWeek(int year, int month, DayOfWeek dayOfWeek) {
        List<Integer> result = new ArrayList<>(5);

        LocalDate date = LocalDate.of(year, month, 1);
        while (date.getMonth().getValue() == month) {
            if (dayOfWeek == date.getDayOfWeek()) {
                result.add(date.getDayOfMonth());
                date = date.plusDays(6);
                System.out.println(date.getDayOfWeek());
            }
            date = date.plusDays(1);
        }
        return result;
    }

    private LocalDate getTeenthDate(List<Integer> daysOfWeek) {
        LocalDate date = null;
        for (int i = 0; i < daysOfWeek.size(); i++) {
            int day = daysOfWeek.get(i);
            if (day < 20) {
                date = LocalDate.of(year, month, day);
            }
        }
        return date;
    }
}
