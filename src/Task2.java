import java.util.Scanner;

public class Task2
{
    private static int hour = 0;
    private static int minute = 0;
    private static boolean is24Hour = true;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running)
        {
            System.out.println("\n=== Clock Menu ===");
            System.out.println("1. Display current time");
            System.out.println("2. Tick (advance by 1 minute)");
            System.out.println("3. Set specific time");
            System.out.println("4. Reset to 00:00 (or 12:00 AM in 12-hour mode)");
            System.out.println("5. Toggle format (24h <-> 12h)");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            String choice = sc.nextLine();

            switch (choice)
            {
                case "1":
                    displayTime();
                    break;
                case "2":
                    tick();
                    displayTime();
                    break;
                case "3":
                    setTime(sc);
                    displayTime();
                    break;
                case "4":
                    reset();
                    displayTime();
                    break;
                case "5":
                    is24Hour = !is24Hour;
                    System.out.println("Format toggled. Now using " + (is24Hour ? "24-hour" : "12-hour AM/PM") + " format.");
                    displayTime();
                    break;
                case "6":
                    running = false;
                    System.out.println("Exiting clock...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }

    private static void displayTime()
    {
        if (is24Hour)
        {
            System.out.printf("Current Time: %02d:%02d\n", hour, minute);
        }
        else
        {
            int displayHour = hour % 12;
            if (displayHour == 0) displayHour = 12;
            String ampm = (hour < 12) ? "AM" : "PM";
            System.out.printf("Current Time: %02d:%02d %s\n", displayHour, minute, ampm);
        }
    }

    private static void tick()
    {
        minute++;
        if (minute == 60)
        {
            minute = 0;
            hour++;
            if (hour == 24)
            {
                hour = 0;
            }
        }
    }

    private static void setTime(Scanner sc)
    {
        try {
            System.out.print("Enter hour (0-23): ");
            int h = Integer.parseInt(sc.nextLine());
            System.out.print("Enter minute (0-59): ");
            int m = Integer.parseInt(sc.nextLine());

            if (h >= 0 && h < 24 && m >= 0 && m < 60)
            {
                hour = h;
                minute = m;
            }
            else
            {
                System.out.println("Invalid time! Please try again.");
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid input! Enter numbers only.");
        }
    }

    private static void reset()
    {
        hour = 0;
        minute = 0;
    }
}