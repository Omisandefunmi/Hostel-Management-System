package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.data.model.Visitor;
import africa.semicolon.hostelManagementSystem.data.repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl implements VisitorService{
    @Autowired
    VisitorRepository visitorRepository;
    @Override
    public Visitor save(Visitor visitor) {
        return visitorRepository.save(visitor);
    }
}
