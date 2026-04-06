package SavouryScore;
import java.util.ArrayList;


public class QuickMeal extends Meal{
    private int quick;
    private static ArrayList<QuickMeal> quickMeals = new ArrayList<QuickMeal>();
    private static int count = 0;

    QuickMeal(int cost, int taste, int time, String name) {
        super(cost, taste, time, name);
        this.quick = time + (cost/taste);
        quickMeals.add(this);
        count += 1;
    }

    public static String sortQuick() 
    {
        int outerIndex = 0;
        int innerIndex = 0;
        String report = "";
        ArrayList<QuickMeal> sorted = quickMeals;
        int compare = count - 1;

        while(outerIndex < compare) 
        {
            innerIndex = 0;
            while(innerIndex < compare)
            {
                if (sorted.get(outerIndex).quick < sorted.get(innerIndex).quick) 
                {
                    QuickMeal holder = sorted.get(innerIndex);
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
