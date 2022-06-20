package africa.semicolon.hostelManagementSystem.data.repositories;

import africa.semicolon.hostelManagementSystem.data.model.Visitor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VisitorRepositoryImpl implements VisitorRepository{
    List <Visitor> visitors = new ArrayList<>();
    @Override
    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
        visitor.setVisitorIdNumber(visitors.size());
    }

    @Override
    public void removeVisitor(Visitor visitor) {
        if(isOut(visitor)){
        visitors.remove(visitor);}
    }

    private boolean isOut(Visitor visitor) {
        return visitor.getTimeOut() != null;
    }

    @Override
    public Visitor findVisitorBy(int visitingRoomNumber, int visitorIdNumber) {
        Visitor visitor;
        for (Visitor value : visitors) {
            visitor = value;
            if (visitor.getVisitingRoomNumber() == visitingRoomNumber && visitor.getVisitorIdNumber() == visitorIdNumber) {
                return visitor;
            }
        }
        return null;
    }

    @Override
    public int countVisitors(){
        return visitors.size();
    }

    @Override
    public void leaveHostel(Visitor visitor, LocalDateTime now) {
        visitor.setTimeOut(LocalDateTime.now());
    }
}
