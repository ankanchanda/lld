package lld.oop.abstraction;

class Emu extends Bird {

    Emu(){
        name = "emu";
    }

    @Override
    protected void attack() {
        System.out.println("Emu::Attck");
    }
    
}
  
