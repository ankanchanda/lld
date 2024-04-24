package lld.solid;

interface Keyboard {
    void connect();
}

interface Mouse {
    void connect();
}

class WiredKeyboard implements Keyboard{

    @Override
    public void connect() {
        // do something
    }
}

class BluetoothKeyboard implements Keyboard{

    @Override
    public void connect() {
        // do something
    }
}

class WiredMouse implements Mouse{
    @Override
    public void connect() {
        // do something
    }   
}
class BluetoothMouse implements Mouse{

    @Override
    public void connect() {
        // do something
    }   
}

class Macbook {
    private WiredKeyboard keyboard;
    private WiredMouse mouse;

    public Macbook(){
        this.keyboard = new WiredKeyboard();
        this.mouse = new WiredMouse();
    }
}