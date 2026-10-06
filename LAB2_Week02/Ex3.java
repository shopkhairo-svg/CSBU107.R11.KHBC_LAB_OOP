package LAB2_Week02;

class Time {
    //Attributes
    private int hour;
    private int minute;
    private int second;
    
    //No-argument constructor
    public Time() {
        hour = 0;
        minute = 0;
        second = 0;
    }

    //Parameterized constructor
    public Time(int hour, int minute, int second) {
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;
        } else {
            this.hour = 0;
        }

        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        } else {
            this.minute = 0;
        }

        if (second >= 0 && second <= 59) {
            this.second = second;
        } else {
            this.second = 0;
        }
    }

    //Display time
    public void display() {
        System.out.printf("%02d:%02d:%02d%n", hour, minute, second);
    }

    //Add second
    public void addSeconds(int seconds) {
        int totalSeconds = hour * 3600 + minute * 60 + second;
        totalSeconds += seconds;
        totalSeconds = totalSeconds % 86400;

        if (totalSeconds < 0) {
            totalSeconds += 86400;
        }
        hour = totalSeconds / 3600;
        totalSeconds %= 3600;

        minute = totalSeconds / 60;
        second = totalSeconds % 60;
    }

    //Substract second
    public void subtractSeconds(int seconds) {
        addSeconds(-seconds);
    }
}

public class Ex3 {
    public static void main(String[] args) {

        // 23:59:50 + 20 seconds
        Time time1 = new Time(23, 59, 50);

        System.out.print("Before adding: ");
        time1.display();

        time1.addSeconds(20);

        System.out.print("After adding 20 seconds: ");
        time1.display();

        System.out.println();

        // 00:00:10 - 20 seconds
        Time time2 = new Time(0, 0, 10);

        System.out.print("Before subtracting: ");
        time2.display();

        time2.subtractSeconds(20);

        System.out.print("After subtracting 20 seconds: ");
        time2.display();
    }
}
