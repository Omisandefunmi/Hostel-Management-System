package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.data.model.Room;
import africa.semicolon.hostelManagementSystem.data.repositories.RoomRepository;
import africa.semicolon.hostelManagementSystem.dto.requests.CreateRoomRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.CreateRoomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service

public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public CreateRoomResponse createRoom(CreateRoomRequest request){
        Room room = new Room(request.getNumberOfBed());
//        room.setNumberOfBeds(Integer.parseInt(request.getNumberOfBed()));

        Room savedRoom = roomRepository.save(room);
        savedRoom.setRoomNumber((int) roomRepository.count()+"");

        CreateRoomResponse response = new CreateRoomResponse();
        response.setRoomNumber(savedRoom.getRoomNumber());
        String message = String.format("Room %s has been successfully created", response.getRoomNumber());
        response.setMessage(message);
        return response;
    }
}
