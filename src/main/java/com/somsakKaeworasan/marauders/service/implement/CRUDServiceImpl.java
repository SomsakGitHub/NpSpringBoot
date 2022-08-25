package com.somsakKaeworasan.marauders.service.implement;

import com.somsakKaeworasan.marauders.model.CRUD;
import com.somsakKaeworasan.marauders.repository.CRUDRepo;
import com.somsakKaeworasan.marauders.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRUDServiceImpl implements CRUDService {
    @Autowired
    private CRUDRepo crudRepo;

    @Override
    @Async
    public List<CRUD> getAll() {
        return crudRepo.findAll();
    }

    @Override
    @Async
    public String add(CRUD crud) {

        crudRepo.save(crud);
        return "New crud is added.";
    }

    @Override
    @Async
    public String update(Integer id, CRUD crud) {

        var data = crudRepo.findById(id).get();
        data.setUsername(crud.getUsername());
        data.setPassword(crud.getPassword());
        crudRepo.save(data);
        return "crud is updated.";
    }

    @Override
    @Async
    public String delete(Integer id) {
        crudRepo.deleteById(id);
        return "crud is deleted.";
    }

}
