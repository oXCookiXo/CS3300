import java.io.*;
import java.util.*;


public class readfile{

	private Scanner x;
	
	public void openFile()
	{
		try
			{
				x = new Scanner(new File("student2.txt"));
				System.out.println("Opening Successful!");
			}
		catch(Exception e)
			{
				System.out.println("File not found");
			}
	}
	
	public void readFile(){
		int S = 0,U = 0,I = 0;
		while(x.hasNext()){
			
				String id = x.next();
				String g1 = x.next();
				String g2 = x.next();
				String g3 = x.next();
				String g4 = x.next();
				
				int [] Grades = new int[4];
				Grades[0] = Integer.parseInt(g1);
				Grades[1] = Integer.parseInt(g2);
				Grades[2] = Integer.parseInt(g3);
				Grades[3] = Integer.parseInt(g4);
				
				String lttr = null;
				int sum = 0;
				int div = 0;
				int avg = 0;
				int ex = 0;
				
				for(int i = 0; i < 4; i++){
					
					if(Grades[i] == -1){ ex++;}

					else if(div == 4){
						div = 0;
						sum = 0;
						avg = 0;
						ex = 0;
					}
					else{
						//Used for troubleshooting
						//System.out.println("Adding "+ Grades[i]);
						sum += Grades[i];
						div++;
					}
					if(sum == 0){
						avg = 0;
					}
					else{
					avg = sum/div;
					}
				}
				
				//Tally for S, U, AND I
				if(ex < 2){
					if(avg >= 50){ lttr = "S";S++; }
					else if(avg < 50){ lttr = "U";U++;}
					else{ lttr = "I";I++;}
				}
				else
				{
					//Don't count it
				}
				//Just to separate excused students and actual averages
				if(ex >= 2){ System.out.println
					("ID = "+id + " Excused = " + ex + " Grade =  I");I++;}
				else{ System.out.println("ID = "+id + " Average = " + avg + " Grade = " + lttr ); }
				
				
				
				
			}	
		System.out.println("Number of Grades of Type" );
		System.out.println("	S	U	I" );
		System.out.println("\t" + S + "\t" + U + "\t" + I);
	}
	
	public void closeFile()
	{
		x.close();
	}
}