package com.formacionbdi.springboot.app.productos.models.service;

import com.formacionbdi.springboot.app.productos.annotation.GeneralAnnotation;
import com.formacionbdi.springboot.app.productos.models.dao.ProductoDao;
import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
@Getter
@GeneralAnnotation
public class ProductoServiceImpl implements IProductoService {

    @GeneralAnnotation(value = "Calling dao layer for product entity")
    private ProductoDao productoDao;

    @Value("${server.port}")
    private Integer port;

    @Autowired
    public ProductoServiceImpl(ProductoDao productoDao) {
        this.productoDao = productoDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        Supplier<Iterable<Producto>> supplier = productoDao::findAll;
        List<Producto> listProd = (List<Producto>) supplier.get();

        listProd.forEach(i -> {
            Producto p = i;
            p.setPort(port);
        });

        return listProd;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        Function<Long, Optional<Producto>> getProductById = productoDao::findById;
        Producto p = getProductById.apply(id).orElse(null);
        p.setPort(port);

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return p;

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
