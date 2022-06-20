package africa.semicolon.hostelManagementSystem.data.repositories;

import africa.semicolon.hostelManagementSystem.data.model.Room;
import africa.semicolon.hostelManagementSystem.data.model.Occupant;

public class RoomRepositoryImpl implements RoomRepository {
    private int count;
    private int bedSpaceTracker;
    private int numberOfRooms;
    private Room[] rooms;
    private int roomToStartAllocatingFrom = 1;
    private int nextAvailableRoom;
    private int totalAvailableBedSpace;
    private  int numberOfOccupiedBedSpaces;

    public RoomRepositoryImpl(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
        this.rooms = new Room[numberOfRooms];
    }

    @Override
    public Room findRoomByRoomId(int roomNumber) {
        return rooms[roomNumber - 1];
    }

    @Override
    public boolean areAllRoomsFilled() {
        calculateTotalNumberOfBedSpaces();
        return totalAvailableBedSpace == numberOfOccupiedBedSpaces;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void saveRoom(Room room) {
        rooms[count] = room;
        count++;
        room.setRoomNumber(count);
    }

    @Override
    public boolean checkIfThisRoomIsFull(int roomNumber) {
        Room room = rooms[roomNumber - 1];
        return room.getOccupiedBedSpace() == room.getBeds().length - 1;
    }

    @Override
    public void allocateRoomTo(Occupant occupant) {
        indicateNextAvailableRoom();
        occupant.setRoomNumber(nextAvailableRoom);
        Room room = rooms[occupant.getRoomNumber() - 1];
        if (bedSpaceTracker == room.getBeds().length) {
            bedSpaceTracker = 0;
        }
        room.setOccupiedBedSpace(bedSpaceTracker + 1);
        numberOfOccupiedBedSpaces++;
    }




    private void indicateNextAvailableRoom() {

        if (checkIfThisRoomIsFull(roomToStartAllocatingFrom)) {
            nextAvailableRoom = roomToStartAllocatingFrom++;
        }
        else{nextAvailableRoom = roomToStartAllocatingFrom;}
    }

    private void calculateTotalNumberOfBedSpaces(){
        for (Room room : rooms) {
            totalAvailableBedSpace += room.getNumberOfBeds();
        }
    }
}
