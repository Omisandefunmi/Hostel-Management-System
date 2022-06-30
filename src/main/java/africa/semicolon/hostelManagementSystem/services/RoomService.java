package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.dto.requests.CreateRoomRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.CreateRoomResponse;

public interface RoomService {
    CreateRoomResponse createRoom(CreateRoomRequest request);
}
