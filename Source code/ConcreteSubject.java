/**
 * Write a description of class ConcreteSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConcreteSubject implements Subject
{
    
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class ConcreteSubject
     */
    public ConcreteSubject()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    
    public void notifyObserver(){
    }
    
    public void attach(Observer obj){
    }
    
    public void detach(Observer obj){
    }
}
