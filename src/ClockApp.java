import java.util.Scanner;

public class ClockApp
{
    private static int hour = 0;
    private static int minute = 0;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running)
        {
            System.out.println("\n=== 24-Hour Clock Menu ===");
            System.out.println("1. Display current time");
            System.out.println("2. Tick (advance by 1 minute)");
            System.out.println("3. Set specific time");
            System.out.println("4. Reset to 00:00");
            System.out.println("5. Exit");
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
        System.out.printf("Current Time: %02d:%02d\n", hour, minute);
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
        try
        {
            System.out.print("Enter hour (0-23): ");
            int h = Integer.parseInt(sc.nextLine());
            System.out.print("Enter minute (0-59): ");
            int m = Integer.parseInt(sc.nextLine());

            if (h >= 0 && h < 24 && m >= 0 && m < 60)
            {
                hour = h;
                minute = m;
            } else
            {
                System.out.println("Invalid time! Please try again.");
            }
        } catch (NumberFormatException e)
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
