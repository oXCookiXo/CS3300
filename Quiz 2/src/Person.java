public class Person {
    private String name;
    private Date Birth;

    //the constructor method
    public Person(String aName, Date aBirth) {
        this.name = aName;
        this.Birth = new Date(aBirth);
    }

    //complete copy constructor
    public Person(Person aPerson) {
        this.name = aPerson.name;
        this.Birth = new Date(aPerson.Birth);
    }

    public Date getBirth() {
        int m, d , y;
        m = Birth.getMonth();
        d = Birth.getDay();
        y = Birth.getYear();

        System.out.println(m + " " + d + " " + y);
        return Birth;
    }

    public String getName() {
        return name;
    }

    //complete the isYounger method
    //returns true if the calling Person object is younger than the aPerson object
    //otherwise returns false
    public boolean isYounger(Person aPerson) {
        boolean younger = false;
        //insert code here

        if (Birth.isYounger(aPerson.Birth)) {
            younger = Birth.isYounger(aPerson.Birth);
            return younger;
        }
        else{
            //Do nothing return false
        }

            return younger;
    }
}
