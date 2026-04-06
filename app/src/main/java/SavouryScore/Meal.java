package SavouryScore;
import java.util.ArrayList;

public class Meal {
    //Declarations
    private int cost;
    private int taste;
    private int time;
    private String name;
    private static int mealCount = 0;
    private static ArrayList<Meal> allMeals = new ArrayList<Meal>();

    Meal(int cost, int taste, int time, String name)
    {
        this.cost = cost;
        this.taste = taste;
        this.time = time;
        this.name = name;
    }


    //Sort


    public void sortMeal()
    {
        int cost = this.cost;
        int taste = this.taste;
        int time = this.time;
        
        if(taste > time)
        {
            if(taste < cost)
            {
                //like ice cream
                TreatMeal temp = new TreatMeal(cost,taste,time,name);
                System.out.println(App.endLine +"\nGolly, what a treat!!\n"+ App.endLine);
                //cost, taste, time
            } else if(time < cost){
                //Like a tuna mayo sandwhich  
                QuickMeal temp = new QuickMeal(cost,taste,time,name);
                System.out.println(App.endLine +"\nGosh, thats so efficent \n"+ App.endLine);
                //taste, cost,time
            }else{
                //Like some good soup
                QualityMeal temp = new QualityMeal(cost,taste,time,name);
                System.out.println(App.endLine +"\nGeez, that sounds heartwarming\n"+ App.endLine);
                //taste, time, cost
            }
        }
        // No options for time being greater than taste is intentional
    }


    // Report methods


    public static String getReport(int choice)
    {
        String report = "";
        if(choice == 1){
            report += App.headingLine + "\nTASTE REPORT\n" + App.headingLine + "\n" + App.endLine + "\nHigh to low\n";
            report = sortTaste(allMeals,mealCount);
        }else if(choice == 2){
            report += App.headingLine + "\nCOST REPORT\n" + App.headingLine + "\n" + App.endLine + "\nLow to high\n";
            report = sortCost(allMeals,mealCount);
        }else if(choice == 3){
            report += App.headingLine + "\nDIFFICULTY REPORT\n" + App.headingLine + "\n" + App.endLine + "\nLow to high\n";
            report += sortTime(allMeals,mealCount);
        }else if(choice == 4){
            report += App.headingLine + "\nRANKED QUALITY MEALS\n" + App.headingLine + "\n" + App.endLine + "\n";
            report += QualityMeal.sortQuality();
        }else if(choice == 5){
            report += App.headingLine + "\nRANKED TREAT MEALS\n" + App.headingLine + "\n" + App.endLine + "\n";
            report += TreatMeal.sortTreat();
        }else if(choice == 6){
            report += App.headingLine + "\nRANKED QUICK MEALS\n" + App.headingLine + "\n" + App.endLine + "\n";
            report += QuickMeal.sortQuick();
        }
        report += "\n" + App.endLine;
        return report;
    }

    // Made this method last semester while studying for prld
    //adapted for arrayLists, there is probably an easier way to do it than this
    public static String sortTime(ArrayList<Meal> toSort, int useCount) 
    {
        int outerIndex = 0;
        int innerIndex = 0;
        String report = "";
        ArrayList<Meal> sorted = toSort;
        int compare = useCount - 1;

        while(outerIndex < compare) 
        {
            innerIndex = 0;
            while(innerIndex < compare)
            {
                if (sorted.get(outerIndex).time < sorted.get(innerIndex).time) 
                {
                    Meal holder = sorted.get(innerIndex);
                    sorted.set(innerIndex,sorted.get(outerIndex));
                    sorted.set(outerIndex,holder);
                }
                innerIndex += 1;
            }
            outerIndex += 1;
        }

        for(int x = 0; x < useCount; x++){
            report += "["+ x + "] " + sorted.get(x).name + "\n";
        }
        return report;
    }

    public static String sortCost(ArrayList<Meal> toSort, int useCount) 
    {
        int outerIndex = 0;
        int innerIndex = 0;
        String report = "";
        ArrayList<Meal> sorted = toSort;
        int compare = useCount - 1;

        while(outerIndex < compare) 
        {
            innerIndex = 0;
            while(innerIndex < compare)
            {
                if (sorted.get(outerIndex).cost < sorted.get(innerIndex).cost) 
                {
                    Meal holder = sorted.get(innerIndex);
                    sorted.set(innerIndex,sorted.get(outerIndex));
                    sorted.set(outerIndex,holder);
                }
                innerIndex += 1;
            }
            outerIndex += 1;
        }

        for(int x = 0; x < useCount; x++){
            report += "["+ x + "] " + sorted.get(x).name + "\n";
        }
        return report;
    }


    public static String sortTaste(ArrayList<Meal> toSort, int useCount) 
    {
        int outerIndex = 0;
        int innerIndex = 0;
        String report = "";
        ArrayList<Meal> sorted = toSort;
        int compare = useCount - 1;

        while(outerIndex < compare) 
        {
            innerIndex = 0;
            while(innerIndex < compare)
            {
                if (sorted.get(outerIndex).taste > sorted.get(innerIndex).taste) 
                {
                    Meal holder = sorted.get(innerIndex);
                    sorted.set(innerIndex,sorted.get(outerIndex));
                    sorted.set(outerIndex,holder);
                }
                innerIndex += 1;
            }
            outerIndex += 1;
        }

        for(int x = 0; x < useCount; x++){
            report += "["+ x + "] " + sorted.get(x).name + "\n";
        }
        return report;
    }


    // Non standard getters and setters


    //Trying a non static add to database method
    public void addToAllMeals()
    {
        allMeals.add(this);  
    }

    public static int getMealCount() {
        return mealCount;
    }

    public static void setMealCount(int modification) {
        mealCount = mealCount + (modification);
    }
    


    //Standard Getters and Setters


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTaste() {
        return taste;
    }

    public void setTaste(int taste) {
        this.taste = taste;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
