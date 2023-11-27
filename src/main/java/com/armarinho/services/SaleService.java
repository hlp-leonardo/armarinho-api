package com.armarinho.services;

import com.armarinho.daos.SaleDao;
import com.armarinho.models.Sale;

import java.util.List;

public class SaleService {

    private void checkIdNull(Integer id) throws Exception {

        if (id == null) {
            throw new Exception("Product color id is null or invalid.");
        }
    }

    public Sale create(Sale sale) {

        SaleDao dao = new SaleDao();
        Sale createService = dao.create(sale);

        return createService;
    }

    public List<Sale> getAll() {

        SaleDao dao = new SaleDao();
        List<Sale> getAllServiceList = dao.getAll();

        return getAllServiceList;
    }

    public Sale getOne(Integer id) throws Exception {

        checkIdNull(id);

        SaleDao dao = new SaleDao();
        Sale getOneService = dao.getOne(id);

        return getOneService;
    }

    public Sale update(int id, Sale sale) throws Exception {

        checkIdNull(id);

        SaleDao dao = new SaleDao();
        Sale updateService = dao.update(id, sale);

        return updateService;
    }

    public void delete(int id) throws Exception {

        checkIdNull(id);

        SaleDao dao = new SaleDao();
        dao.delete(id);

    }

}
