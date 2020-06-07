package com.greedy.cheapest.hotel;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*Problem statement : Get the cheapest hotel from the list where weekdays and weekEnd prices are different*/

/*  O/p : RADISSON*/
public class GetCheapestHotel {

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2020, 05, 25);
        LocalDate endDate = LocalDate.of(2020, 05, 31);
        String cheapestHotel = getCheapestHotel(startDate, endDate);
        System.out.println("Cheapest hotel is : " + cheapestHotel);
    }

    private static String getCheapestHotel(LocalDate startDate, LocalDate endDate) {

        long numberOfDaysStay = DAYS.between(startDate, endDate);
        long numberOfWeekEnds = getNumberOfWeekEndDays(startDate, endDate);
        long numberOfWeekDays = ++numberOfDaysStay - numberOfWeekEnds;

        //get list of all hotels
        List<Hotel> listOfHotels = Arrays.asList(Hotel.values());
        Hotel hotel = listOfHotels.stream().sorted((h1, h2) -> (int) ((h1.getWeekDay() * numberOfWeekDays + h1.getWeekEnd() * numberOfWeekEnds) - (h2.getWeekDay() * numberOfWeekDays + h2.getWeekEnd() * numberOfWeekEnds))).collect(Collectors.toList()).get(0);
        return hotel.name();
    }

    private static long getNumberOfWeekEndDays(LocalDate startDate, LocalDate endDate) {
        LocalDate resultDate = startDate;
        int numberOfWeekendDays = 0;

        do {
            if (DayOfWeek.SATURDAY.equals(resultDate.getDayOfWeek()) || DayOfWeek.SUNDAY.equals(resultDate.getDayOfWeek())) {
                numberOfWeekendDays += 1;
            }
            resultDate = resultDate.plusDays(1);
        } while (endDate.isAfter(resultDate) || endDate.isEqual(resultDate));

        return numberOfWeekendDays;
    }

}
