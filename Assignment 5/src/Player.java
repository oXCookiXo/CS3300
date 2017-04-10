/**
 * Created by oXCookiXo on 3/27/17.
 */
public class Player {

    String  Name;
    int Score;
    int Shirt;

    public Player()
    {
        Name = "";
        Score = 0;
        Shirt = 0;
    }
    public Player(String newName, int newScore, int newShirt)
    {
        Name = newName;
        Score = newScore;
        Shirt = newShirt;
    }

    public Player(Player P)
    {
        Name = P.Name;
        Score = P.Score;
        Shirt = P.Shirt;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }
}
