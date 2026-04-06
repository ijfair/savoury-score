package SavouryScore;
import java.util.ArrayList;


public class TreatMeal extends Meal{
    private int treat;
    private static ArrayList<TreatMeal> treatMeals = new ArrayList<TreatMeal>();
    private static int count = 0;

    TreatMeal(int cost, int taste, int time, String name) {
        super(cost, taste, time, name);
        this.treat = taste + (cost/time);
        treatMeals.add(this);
        count += 1;
    }

    public static String sortTreat() 
    {
        int outerIndex = 0;
        int innerIndex = 0;
        String report = "";
        ArrayList<TreatMeal> sorted = treatMeals;
        int compare = count - 1;

        while(outerIndex < compare) 
        {
            innerIndex = 0;
            while(innerIndex < compare)
            {
                if (sorted.get(outerIndex).treat > sorted.get(innerIndex).treat) 
                {
                    TreatMeal holder = sorted.get(innerIndex);
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
