import BackTrack.CountPossibleWays;
import DP.MoveK;

public class Main {

    public static void main(String[] args) {

        String line = "0 200";
        int level = Integer.parseInt(line.split(" ")[0]);
        int defend = Integer.parseInt(line.split(" ")[1]);

        double axe = 185;
        double bow = 180;

        double freeAXE = (defend-100-level*10)/(1.0*(602+(defend-100-level*10)));
        axe *= (1-freeAXE);

        double freeBOW = (defend*0.55)/(1.0*(602+(defend*0.55)));
        bow *= (1-freeBOW);
        if (axe == bow){
            System.out.println("same");
        } else {
            System.out.println(axe>bow?"axe":"bow");
        }

        CountPossibleWays countPossibleWays = new CountPossibleWays();
        countPossibleWays.count("1,2,3 4");




    }
}
