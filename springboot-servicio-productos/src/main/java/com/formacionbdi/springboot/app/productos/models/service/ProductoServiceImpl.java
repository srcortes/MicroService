package com.formacionbdi.springboot.app.productos.models.service;

import com.formacionbdi.springboot.app.productos.annotation.GeneralAnnotation;
import com.formacionbdi.springboot.app.productos.models.dao.ProductoDao;
import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@GeneralAnnotation
public class ProductoServiceImpl implements IProductoService{

    @GeneralAnnotation(value = "Calling dao layer for product entity")
    private ProductoDao productoDao;

    @Autowired
    public ProductoServiceImpl(ProductoDao productoDao){
        this.productoDao = productoDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productoDao.deleteById(id);
    }
}
