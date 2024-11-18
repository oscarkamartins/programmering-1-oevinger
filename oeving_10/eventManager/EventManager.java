package eventManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EventManager {
    private ArrayList<Event> events;
    private static final Scanner scanner = new Scanner(System.in);

    public EventManager() {
        this.events = new ArrayList<Event>();
    }

    public EventManager(ArrayList<Event> eventList) {
        this.events = eventList;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public static EventManager sortEvents(ArrayList<Event> eventsToBeSorted, Comparator<Event> sortMethod) {
        ArrayList<Event> sortedEvents = new ArrayList<Event>(eventsToBeSorted);        
        Collections.sort(sortedEvents, sortMethod);
        return new EventManager(sortedEvents);
    }

    public void newEvent(String name, String location, String host, String type, long dateTime) {
        events.add(new Event(events.size(), name, location, host, type, dateTime));
    }

    public EventManager eventsAtLocation(String location) {
        ArrayList<Event> eventsAtLocation = events.stream()
            .filter(event -> event.getLocation().equals(location))
            .collect(Collectors.toCollection(ArrayList :: new));

        return new EventManager(eventsAtLocation);
    }

    public EventManager eventsOnDate(int date) {
        ArrayList<Event> eventsOnDate = events.stream()
            .filter(event -> event.getDate() == date)
            .collect(Collectors.toCollection(ArrayList :: new));
        
        return sortEvents(eventsOnDate, Comparator.comparing(Event :: getDateTime));
    }

    public EventManager eventsInInterval(long start, long end) {
        ArrayList<Event> eventsInInterval = events.stream()
            .filter(event -> event.getDateTime() >= start && event.getDateTime() <= end)
            .collect(Collectors.toCollection(ArrayList :: new));

        return new EventManager(eventsInInterval);
    }

    public String toString() {
        String string = "";

        for (Event event : events) {
            string += event + "\n";
        }

        return string;
    }

    public static int getValidInt(String message) {
        int validInt = 0;

        while (true) {
            System.out.println(message);
            try {
                validInt = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }

        return validInt;
    }

    public static long getValidLong(String message) {
        long validLong = 0L;

        while (true) {
            System.out.println(message);
            try {
                validLong = Long.parseLong(scanner.nextLine());
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }

        return validLong;
    }

    public static String getNonEmptyString(String message) {
        String validString = "";

        while (true) {
            System.out.println(message);
            validString = scanner.nextLine();

            if (validString.equals("")) {
                System.out.println("Empty input");
            }
            else {
                break;
            }
        }

        return validString;
    }

    public static int pickOption() {
        int option = getValidInt("Pick an option:\n1. New event\n2. Events in location\n3. Events on date\n4. Events within time interval\n5. List all events\n6. Quit");

        return option;
    }

    public static int getSortMethod() {
        while (true) {
            int sortMethod = getValidInt("Sort by:\n1. Location\n2. Type\n3. Date and time");
            if (sortMethod > 0 && sortMethod < 4) {
                return sortMethod;
            }
            else {
                System.out.println("Pick a valid option");
            }
        }
    }

    public static void client(EventManager eventManager) {
        while (true) {
            int option = pickOption();

            switch (option) {
                case 1:
                    String newEventName = getNonEmptyString("Event name:");
                    String newEventLocation = getNonEmptyString("Location:");
                    String newEventHost = getNonEmptyString("Host:");
                    String newEventType = getNonEmptyString("Type:");
                    long newEventDateTime = getValidLong("Date and time:");
                    eventManager.newEvent(newEventName, newEventLocation, newEventHost, newEventType, newEventDateTime);
                    break;
                case 2:
                    String location = getNonEmptyString("Location:");
                    System.out.println(eventManager.eventsAtLocation(location));
                    break;
                case 3:
                    int date = getValidInt("Date:");
                    System.out.println(eventManager.eventsOnDate(date));
                    break;
                case 4:
                    long start = getValidLong("Start date and time:");
                    long end = getValidLong("End date and time:");
                    System.out.println(eventManager.eventsInInterval(start, end));
                    break;
                case 5:
                    int sortMethod = getSortMethod();

                    switch (sortMethod) {
                        case 1:
                            System.out.println(sortEvents(eventManager.getEvents(), Comparator.comparing(Event :: getLocation)));
                            break;
                        case 2:
                            System.out.println(sortEvents(eventManager.getEvents(), Comparator.comparing(Event :: getType)));
                            break;
                        case 3:
                            System.out.println(sortEvents(eventManager.getEvents(), Comparator.comparing(Event :: getDateTime)));
                            break;
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Pick a valid option");
            }
        }
    }

    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        eventManager.newEvent("Exercise hand in", "A4", "TA", "Exercise", 202419091000L);
        eventManager.newEvent("Dinner", "Home", "Oscar", "Cooking", 202416091700L);
        eventManager.newEvent("Statistics", "A4", "Thea Bjørnland", "Lecture", 202417091415L);
        eventManager.newEvent("Skate sesh", "Skatepark", "Oscar", "Skating", 202421091500L);

        client(eventManager);
        scanner.close();
    }
}