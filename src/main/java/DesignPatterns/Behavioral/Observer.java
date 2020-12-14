package DesignPatterns.Behavioral;

import java.util.ArrayList;
import java.util.Iterator;

interface Subject{
    public void register(Observer observer);
    public void unregister(Observer observer);
    public void notifyObservers();

}

class CricketData implements Subject{
    int runs, wickets, overs;
    ArrayList<Observer> observerList;

    public CricketData() {
        this.observerList = new ArrayList<Observer>();
    }

    public void register(Observer observer) {
        observerList.add(observer);
    }

    public void unregister(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObservers() {
        for(Iterator<Observer> it = observerList.iterator(); it.hasNext() ; ){
            Observer observer = it.next();
            observer.update(runs,wickets,overs);
        }
    }

    // get latest runs from stadium
    private int getLatestRuns()
    {
        // return 90 for simplicity
        return 90;
    }

    // get latest wickets from stadium
    private int getLatestWickets()
    {
        // return 2 for simplicity
        return 2;
    }

    // get latest overs from stadium
    private float getLatestOvers()
    {
        // return 90 for simplicity
        return (float)10.2;
    }

    // This method is used update displays
    // when data changes
    public void dataChanged()
    {
        //get latest data
        runs = getLatestRuns();
        wickets = getLatestWickets();
        overs = (int)getLatestOvers();

        notifyObservers();
    }
}

interface Observer {
    public void update(int runs, int wickets, int overs);
}

class AverageScoreDisplay implements Observer{
        private float runRate;
        private int predictedScore;

        public void update(int runs, int wickets,
                           int overs)
        {
            this.runRate =(float)runs/overs;
            this.predictedScore = (int)(this.runRate * 50);
            display();
        }

        public void display() {
            System.out.println("\nAverage Score Display: \n"
                    + "Run Rate: " + runRate +
                    "\nPredictedScore: " +
                    predictedScore);
        }
}

class CurrentScoreDisplay implements Observer{

    private int runs, wickets;
    private float overs;

    public void update(int runs, int wickets,
                       int overs)
    {
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
        display();
    }

    public void display()
    {
        System.out.println("\nCurrent Score Display:\n"
                + "Runs: " + runs +
                "\nWickets:" + wickets +
                "\nOvers: " + overs );
    }
}

class Main{
    public static void main(String[] args) {
        AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
        CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();

        CricketData cricketData = new CricketData();
        cricketData.register(averageScoreDisplay);
        cricketData.register(currentScoreDisplay);

        cricketData.dataChanged();;

        cricketData.unregister(currentScoreDisplay);
        cricketData.dataChanged();
    }
}