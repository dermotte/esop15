package at.aau.esop15.course05;

/**
 * @author Dr. Mathias Lux, 02.11.2015.
 */
public class Time {
    int second, minute, hour;

    public Time(int hour, int minute, int second) {
        this.second = second;
        this.minute = minute;
        this.hour = hour;
    }

    public Time(int second) {
        // TODO: implement in course.
    }

    static Time convert (int sec) {
        Time t = new Time(sec / 3600, (sec % 3600) / 60, sec % 60);
        return t;
    }

    public static void main(String[] args) {
        Time t = Time.convert(48662);
        System.out.printf("%d:%02d:%02d\n", t.hour, t.minute, t.second);
    }

}
