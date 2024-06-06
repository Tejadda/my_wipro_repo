package com.DAY_26;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimezoneConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define the date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Read the input date-time from the user
        System.out.println("Enter the date and time (yyyy-MM-dd HH:mm): ");
        String dateTimeString = scanner.nextLine();
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);

        // Read the source timezone from the user
        System.out.println("Enter the source timezone (e.g., America/New_York): ");
        String sourceTimeZone = scanner.nextLine();
        ZoneId sourceZoneId = ZoneId.of(sourceTimeZone);

        // Read the target timezone from the user
        System.out.println("Enter the target timezone (e.g., Europe/London): ");
        String targetTimeZone = scanner.nextLine();
        ZoneId targetZoneId = ZoneId.of(targetTimeZone);

        // Convert the local date-time to the source timezone
        ZonedDateTime sourceZonedDateTime = ZonedDateTime.of(localDateTime, sourceZoneId);

        // Convert the source timezone date-time to the target timezone
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(targetZoneId);

        // Output the result
        System.out.println("Source time: " + sourceZonedDateTime.format(formatter) + " " + sourceZoneId);
        System.out.println("Target time: " + targetZonedDateTime.format(formatter) + " " + targetZoneId);

        scanner.close();
    }
}