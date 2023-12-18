package com.armarinho.services;

import com.armarinho.daos.SaleDAO;
import com.armarinho.models.Sale;

import java.util.List;

public class SaleService {

    private void checkIdNull(Integer id) throws Exception {

        if (id == null) {
            throw new Exception("Product color id is null or invalid.");
        }
    }

    public Sale create(Sale sale) {

        SaleDAO dao = new SaleDAO();
        Sale createSale = dao.create(sale);

        return createSale;
    }

    public List<Sale> getAll() {

        SaleDAO dao = new SaleDAO();
        List<Sale> allSales = dao.getAll();

        return allSales;
    }

    public Sale getOne(Integer id) throws Exception {

        checkIdNull(id);

        SaleDAO dao = new SaleDAO();
        Sale sale = dao.getOne(id);

        return sale;
    }

    public Sale update(int id, Sale sale) throws Exception {

        checkIdNull(id);

        SaleDAO dao = new SaleDAO();
        Sale updateSale = dao.update(id, sale);

        return updateSale;
    }

    public void delete(int id) throws Exception {

        checkIdNull(id);

        SaleDAO dao = new SaleDAO();
        dao.delete(id);

    }
}
