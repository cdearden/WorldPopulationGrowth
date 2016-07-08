/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.craigdearden.app;

public class WorldPopulationGrowth {
  
  /**
   * Holds the year, the population, and the population growth for the
   * next 75 years in a two dimensional array.
   * 
   * Calculates these values based on the current world population and
   * growth rate.
   * 
   */
  private long[][] populationGrowth = new long[75][3];

  private static final long CURRENT_POPULATION = 7432663275L;
  private static final double GROWTH_RATE = 0.013;
  private static final int YEAR = 2017;

  public void calculateGrowth() {
    populationGrowth[0][0] = 0 + YEAR;
    populationGrowth[0][1] = (long) (CURRENT_POPULATION + CURRENT_POPULATION * GROWTH_RATE);
    populationGrowth[0][2] = (long) (CURRENT_POPULATION * GROWTH_RATE);
    for (int year = 1; year < 75; year++) {
      populationGrowth[year][0] = year + YEAR;
      populationGrowth[year][1] = (long) (populationGrowth[year - 1][1]
          + populationGrowth[year - 1][1] * GROWTH_RATE);
      populationGrowth[year][2] = (long) (populationGrowth[year - 1][1] * GROWTH_RATE);
    }
  }

  
  /**
   * Prints a three column table which contains: Year, Population, Growth
   * for the next 75 years.
   */
  public void print() {
    System.out.printf("%4s %13s %13s%n", "Year", "Population", "Growth");
    for (int year = 0; year < 75; year++) {
      System.out.printf("%4s %13d %13d %n", populationGrowth[year][0], populationGrowth[year][1],
          populationGrowth[year][2]);
    }

  }

}
