package lld.solid;

class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal(){
        int price = marker.price * this.quantity;
        return price;
    }
}

class InvoiceDao {
    private Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }
    
    public void saveToDB(){
        // save into the db
    }

    // doesn't follow open close principle as the above method
    // is already live and tested
    public void saveToFile(){
        // saves to file
    }
}

class InvoicePrinter {
    private Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void print() {
        
    }

}

