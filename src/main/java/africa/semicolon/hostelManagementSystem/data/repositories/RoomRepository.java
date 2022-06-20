package africa.semicolon.hostelManagementSystem.data.repositories;

import africa.semicolon.hostelManagementSystem.data.model.Occupant;
import africa.semicolon.hostelManagementSystem.data.model.Room;

public interface RoomRepository {

    Room findRoomByRoomId(int roomNumber);

    boolean areAllRoomsFilled();

    int count();

    void saveRoom(Room room);

    boolean checkIfThisRoomIsFull(int roomNumber);

    void allocateRoomTo(Occupant occupant);
}
