package Service;

import java.util.HashMap;
import java.util.Map;

import Models.Slot;
import Models.Ticket;
import Models.Vehicle;

public class TicketService {

    Map<String, Ticket> idToTicketMapping;
    TicketService(){
        idToTicketMapping = new HashMap<String, Ticket>();
    }
    
    public Ticket generateTicket(Slot slot, Vehicle vehicle){
        String id = generateTicketId(slot);
        Ticket ticket = new Ticket(id, slot, vehicle);
        idToTicketMapping.put(id, ticket);
        return ticket;
    }

    private String generateTicketId(Slot slot){
        String id = slot.getParkingLotId() + "_" + slot.getFloorNumber().toString() + "_" + slot.getId().toString();
        return id;
    }

    public void expireTicket(String ticketId){
        Ticket ticket = idToTicketMapping.get(ticketId);
        ticket.setHasExpired(true);
    }

    public Ticket getTicketByTicketId(String ticketId){
        if(idToTicketMapping.containsKey(ticketId)){
            Ticket ticket = idToTicketMapping.get(ticketId);
            if(!ticket.getHasExpired()){
                return ticket;
            }
        }
        return null;
    }
}
