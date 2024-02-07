package lld.oop.abstraction;

class Emu extends Bird {

    Emu(){
        super("emu");
    }

    @Override
    protected void attack() {
        System.out.println("Emu::Attck");
    }
    
}
  
