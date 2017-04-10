


/**
 * Created by oXCookiXo on 3/1/17.
 */
public class Simulator {

    public static void main(String [] args) {

        Date birth1 = new Date(12, 1, 1993);

        Person p1 = new Person("Carlos", birth1);

        Date birth2 = new Date(12, 17, 1995);

        Person p2 = new Person("Sara", birth1);



        System.out.println(p1.getBirth());
        System.out.println(p2.getBirth());

        if(p1.isYounger(p2)){
            System.out.println(p1.getName() + " is younger");


        }
        else if(p2.isYounger(p1)){
            System.out.println(p2 + " is younger");
        }
    }
}
