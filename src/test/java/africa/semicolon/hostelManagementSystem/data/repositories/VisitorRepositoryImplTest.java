package africa.semicolon.hostelManagementSystem.data.repositories;

import africa.semicolon.hostelManagementSystem.data.model.Visitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VisitorRepositoryImplTest {
    private VisitorRepository visitorRepository;

    @BeforeEach
    public void alwaysStartWith(){
        visitorRepository = new VisitorRepositoryImpl();
    }

    @Test
    public void visitorRepositoryCanAddVisitor(){
        Visitor visitor = new Visitor("Wale", 1, "dolapo", LocalDateTime.now());
        visitorRepository.addVisitor(visitor);
        assertEquals(1, visitorRepository.countVisitors());
    }

    @Test
    public void visitorRepositoryRemovesVisitorsOnlyWhenVisitorsExitTest(){
        Visitor visitor = new Visitor("Wale", 1, "dolapo", LocalDateTime.now());
        visitorRepository.addVisitor(visitor);
        visitorRepository.leaveHostel(visitor, LocalDateTime.now());
        visitorRepository.removeVisitor(visitor);
        assertEquals(0, visitorRepository.countVisitors());
    }

    @Test
    public void visitorRepositoryCanSearchForVisitorsTest(){
        Visitor visitor = new Visitor("Wale", 1, "dolapo", LocalDateTime.now());
        visitorRepository.addVisitor(visitor);
        Visitor found = visitor;
        assertSame(found, visitorRepository.findVisitorBy(1, 1));
    }


}