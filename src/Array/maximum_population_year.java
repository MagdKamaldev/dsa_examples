package Array;

public class maximum_population_year {
    public static void main(String[] args) {
        System.out.println(maximumPopulation(new int [][]{{1950,1961},{1960,1971},{1970,1981}}));
    }
    public static int maximumPopulation(int[][] logs) {
        int[] populationPerYear = new int[2051];


        for (int[] log : logs) {
            for (int year = log[0]; year < log[1]; year++) {
                populationPerYear[year]++;
            }
        }

        int maxPopulation = 0;
        int earliestYear = 0;

        // Find the year with the maximum population
        for (int year = 0; year < populationPerYear.length; year++) {
            if (populationPerYear[year] > maxPopulation) {
                maxPopulation = populationPerYear[year];
                earliestYear = year;
            }
        }

        return earliestYear;
    }
}
