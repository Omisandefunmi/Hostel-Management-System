package africa.semicolon.hostelManagementSystem.data.repositories;

import africa.semicolon.hostelManagementSystem.data.model.Occupant;
import africa.semicolon.hostelManagementSystem.data.model.Room;
import africa.semicolon.hostelManagementSystem.data.model.StayDuration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomRepositoryImplTest {
    private RoomRepository roomRepository = new RoomRepositoryImpl(3);

@Test
    public void createRoom_saveRoomTest(){
    Room room = new Room(2);
    roomRepository.saveRoom(room);
    assertEquals(1,roomRepository.count());
}

@Test
    public void createTwoRooms_countIsTwo(){
    Room room = new Room(2);
    Room room2 = new Room(2);
    roomRepository.saveRoom(room);
    roomRepository.saveRoom(room2);
    assertEquals(2,roomRepository.count());
}

@Test
    public void  eachRoomHasRoomNumberTest(){
    Room room = new Room(2);
    Room room2 = new Room(2);
    roomRepository.saveRoom(room);
    roomRepository.saveRoom(room2);

    assertEquals(room2,roomRepository.findRoomByRoomId(2));
}

@Test
    public void roomRepositoryCanConfirmThatEachRoomIsEmptyByDefaultTest(){
    Room room = new Room(2);
    Room room2 = new Room(2);
    roomRepository.saveRoom(room);
    roomRepository.saveRoom(room2);

    assertFalse(roomRepository.checkIfThisRoomIsFull(1));
}

@Test
    public void fillRoom_confirmThatRoomIsFilledTest(){
    Room room = new Room(2);
    Room room2 = new Room(2);
    roomRepository.saveRoom(room);
    roomRepository.saveRoom(room2);
    Occupant occupant1 = new Occupant("Ayo", "Kunle", StayDuration.ONE_YEAR);
    Occupant occupant2 = new Occupant("Mbappe", "Neymar", StayDuration.SIX_MONTHS);

    roomRepository.allocateRoomTo(occupant1);
    roomRepository.allocateRoomTo(occupant2);
    assertEquals(1, occupant2.getRoomNumber());
    assertEquals(1, occupant1.getRoomNumber());

    assertTrue(roomRepository.checkIfThisRoomIsFull(1));
}
@Test
    public void fillAllRooms_ConfirmThatAllRoomsAreFilledTest(){
    Room room = new Room(2);
    Room room2 = new Room(2);
    Room room3 = new Room(2);
    roomRepository.saveRoom(room);
    roomRepository.saveRoom(room2);
    roomRepository.saveRoom(room3);
    Occupant occupant1 = new Occupant("Ayo", "Kunle", StayDuration.ONE_YEAR);
    Occupant occupant2 = new Occupant("Mbappe", "Neymar", StayDuration.SIX_MONTHS);
    Occupant occupant3 = new Occupant("Mba", "Narti", StayDuration.THREE_MONTHS);
    Occupant occupant4 = new Occupant("Godwin", "Unik", StayDuration.SIX_MONTHS);
    Occupant occupant5 = new Occupant("Rejoice", "Okon", StayDuration.ONE_YEAR);
    Occupant occupant6 = new Occupant("Esosa", "Uyi", StayDuration.THREE_MONTHS);

    roomRepository.allocateRoomTo(occupant1);
    roomRepository.allocateRoomTo(occupant2);
    roomRepository.allocateRoomTo(occupant3);
    roomRepository.allocateRoomTo(occupant4);
    roomRepository.allocateRoomTo(occupant5);
    roomRepository.allocateRoomTo(occupant6);
    assertTrue(roomRepository.areAllRoomsFilled());
}
}