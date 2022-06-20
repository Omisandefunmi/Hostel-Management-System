package africa.semicolon.hostelManagementSystem.data.repositories;

import africa.semicolon.hostelManagementSystem.data.model.Visitor;

import java.time.LocalDateTime;

public interface VisitorRepository {
    void addVisitor(Visitor visitor);
    void removeVisitor(Visitor visitor);
    Visitor findVisitorBy(int visitingRoomNumber, int VisitorIdNumber);

    int countVisitors();

    void leaveHostel(Visitor visitor, LocalDateTime now);
}
