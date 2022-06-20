package africa.semicolon.hostelManagementSystem.data.repositories;

import africa.semicolon.hostelManagementSystem.data.repositories.BedRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BedRepositoryTest {
    private BedRepository bed;
    @BeforeEach
    public void alwaysStartWith(){
        bed = new BedRepository();
    }
    @Test
    public void testThatBedIsNotOccupiedByDefault(){
        assertFalse(bed.isBedSpaceOccupied());
    }

    public void testThatBedIsOccupiedWhenAllocated(){


    }

}