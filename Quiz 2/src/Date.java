public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int d, int m, int y) {
        this.day = d;
        this.month = m;
        this.year = y;
    }

    //copy constructor
    public Date(Date aDate) {
        this.day = aDate.day;
        this.month = aDate.month;
        this.year = aDate.year;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    //complete isYounger method here
    // returns true if the calling object is younger than aDate object
    // otherwise returns false
    public boolean isYounger(Date aDate) {
        boolean yes = true;

        if (this.year == aDate.year) {
            if (this.month == aDate.month) {
                if (this.day == aDate.month) {
                    System.out.println("You're the same age!");
                } else if (this.day < aDate.month) {
                    yes = true;
                } else if (this.day > aDate.month) {
                    yes = false;
                }
            } else if (this.month < aDate.month) {
                yes = true;
            } else if (this.month > aDate.month) {
                yes = false;
            }
        } else if (this.year < aDate.year) {
            yes = true;
        } else if (this.year > aDate.year) {
            yes = false;
        }
        return yes;
    }
}
