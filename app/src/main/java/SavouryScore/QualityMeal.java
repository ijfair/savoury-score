package SavouryScore;

import java.util.ArrayList;

public class QualityMeal extends Meal{
    private int quality;
    private static ArrayList<QualityMeal> qualityMeals = new ArrayList<QualityMeal>();
    private static int count = 0;

    QualityMeal(int cost, int taste, int time, String name) {
        super(cost, taste, time, name);
        this.quality = cost + (time * taste);
        qualityMeals.add(this);
        count += 1;
    }

    public static String sortQuality()
    {
        int outerIndex = 0;
        int innerIndex = 0;
        String report = "";
        ArrayList<QualityMeal> sorted = qualityMeals;
        int compare = count - 1;

        while(outerIndex < compare) 
        {
            innerIndex = 0;
            while(innerIndex < compare)
            {
                if (sorted.get(outerIndex).quality > sorted.get(innerIndex).quality) 
                {
                    QualityMeal holder = sorted.get(innerIndex);
                    sorted.set(innerIndex,sorted.get(outerIndex));
                    sorted.set(outerIndex,holder);
                }
                innerIndex += 1;
            }
            outerIndex += 1;
        }

        for(int x = 0; x < count; x++){
            report += "["+ x + "] " + sorted.get(x).getName() + "\n";
        }
        return report;
    }
    
}
