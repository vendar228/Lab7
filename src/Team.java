import java.io.Serializable;

public class Team implements Serializable {
    String name;
    String city;
    int placeInLeague;
    int countWin;

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", placeInLeague=" + placeInLeague +
                ", countWin=" + countWin +
                '}';
    }
}
