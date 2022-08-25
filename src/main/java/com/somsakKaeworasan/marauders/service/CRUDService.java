package com.somsakKaeworasan.marauders.service;

import com.somsakKaeworasan.marauders.model.CRUD;

import java.util.List;

public interface CRUDService {
    List<CRUD> getAll();
    String add(CRUD crud);
    String update(Integer id, CRUD crud);
    String delete(Integer id);
}
