public class Census {
    private Person[] citizens;

    //complete a constructor
    public Census(Person[] p) {

        this.citizens = p;
    }

    //returns the a copy of the youngest person in the Person[] citizens array.
    //assume that no two person have the same birth date.
    public Person getYoungest() {
        Person youngest = null;
        //insert code here


        for(int i = 0; i < citizens.length; i++) {

            if(citizens[i].isYounger(citizens[i+1])){
                youngest = citizens[i];
            }
            else{
                //Do nothing because citizen i+1 is younger
            }

        }

        return youngest;
    }
}
