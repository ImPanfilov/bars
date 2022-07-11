package com.impanfilov.bars.service;


import com.impanfilov.bars.client.BarsClient;
import com.impanfilov.bars.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class ContactServiceImpl implements ContractService {

    @Autowired
    BarsClient barsClient;

    @Override
    public List<Contract> findAll() {
        return barsClient.getAll().getBody();
    }

}
