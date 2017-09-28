package laboration4;
import java.util.*;
import java.io.*;

public class Exercise2 {
    private ArrayList<Person> persons = new ArrayList<Person>();
    
    public void readPersons( String filnamn ) {
        try {
            BufferedReader br = new BufferedReader( new FileReader( filnamn ) );
            String[] parts;
            Person person;
            String txt = br.readLine();
            while( txt != null ) {
                parts = txt.split( "," );
                person = new Person( parts[ 0 ], parts[ 1 ], parts[ 2 ] );
                persons.add( person );
                txt = br.readLine();
            }
            br.close();
        } catch( IOException e ) {
            System.out.println( "readPersons: " + e );
        }
    }

    public String toString() {
        return "Lagrade personer: " + persons.toString();
    }
    
    public void printPersons() {
        for(Person p: persons){
        	System.out.println("Personummer: " + p.getSocialSecurityNumber() + ", Namn: " + p.getFirstName() + " " + p.getLastName());
        }
    }
    
    public int position( String socialSecurityNumber ) {
        for(int i = 0; i < persons.size(); i++){
        	String personnr = persons.get(i).getSocialSecurityNumber();
        	
        	if(personnr.equals(socialSecurityNumber)){
        		return i;
        	}
        }
        
        return -1;
    }
    
    public void printName( String socialSecurityNumber ) {
    	int index = this.position(socialSecurityNumber);
    	if(index > 0){
    		String fullName = persons.get(index).getFirstName() + " " + persons.get(index).getLastName();
    		System.out.println(fullName);
    	}
    	else{
    		System.out.println(socialSecurityNumber + " okänd");
    	}
    }
    
    public boolean containsFirstName( String firstName ) {
        for(int i = 0; i < persons.size(); i++){
        	String name = persons.get(i).getFirstName();
        	
        	if(name.equals(firstName)){
        		return true;
        	}
        }
        
        return false;
    }
    
    public boolean changeLastName( String socialSecurityNumber, String lastName ) {
        int index = this.position(socialSecurityNumber);
        
        if(index > 0){
        	Person p = persons.get(index);
        	
        	p.setLastName(lastName);
        	return true;
        }
        
        return false;
    }


    
    public static void main( String[] args ) {
        Exercise2 ex2 = new Exercise2();
        ex2.readPersons( "files/personer.txt" );
//        System.out.println( ex2.toString() );
//        ex2.printPersons();
//        System.out.println( ex2.position( "840102-4567" ) );
//        System.out.println( ex2.position( "111111-2222" ) );
        ex2.printName( "840102-4567" );
        ex2.printName( "111111-2222" );
        System.out.println( ex2.containsFirstName( "Edit" ) );
        System.out.println( ex2.containsFirstName( "Anna" ) );
        ex2.changeLastName( "660503-8901", "Trädrot" );
        System.out.println( ex2.toString() );
    }
}