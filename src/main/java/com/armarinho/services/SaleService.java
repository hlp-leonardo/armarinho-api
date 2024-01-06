package com.armarinho.services;

import com.armarinho.daos.SaleDAO;
import com.armarinho.models.Sale;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.time.Instant;
import java.util.List;

@Stateless
public class SaleService {

    @Inject
    private SaleDAO dao;

    private void checkIdNull(Integer id) throws Exception {

        if (id == null) {
            throw new Exception("Product color id is null or invalid.");
        }
    }

    public Sale create(Sale sale) {

        Sale createSale = dao.create(sale);

        return createSale;
    }

    public List<Sale> getAll() {

        List<Sale> allSales = dao.getAll();

        return allSales;
    }

    public Sale getOne(Integer id) throws Exception {

        checkIdNull(id);

        Sale sale = dao.getOne(id);

        return sale;
    }

    public Sale update(int id, Sale sale) throws Exception {

        checkIdNull(id);

        Sale updateSale = dao.update(id, sale);

        return updateSale;
    }

    public void delete(int id) throws Exception {

        checkIdNull(id);

        dao.delete(id);

    }
}
