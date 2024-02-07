package lld.oop.abstraction;

public abstract class Bird {
  
    String name;

    Bird(String name){
        this.name = name;
    }
    
    protected abstract void attack(); 
 
    public String getName(){
        return name;
    }  

    public void setname(String name){
        this.name=name;
    }
  }
