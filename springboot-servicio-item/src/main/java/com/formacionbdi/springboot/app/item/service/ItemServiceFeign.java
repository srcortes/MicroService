package com.formacionbdi.springboot.app.item.service;

import com.formacionbdi.springboot.app.item.models.Item;

import java.util.List;

public class ItemServiceFeign implements ItemService{
    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return null;
    }
}
