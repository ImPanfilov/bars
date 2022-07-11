package com.impanfilov.bars.client;

import com.impanfilov.bars.model.Contract;
import org.springframework.http.ResponseEntity;
import java.util.List;


public class BarsClientFallback implements BarsClient{

    @Override
    public ResponseEntity<List<Contract>> getAll(){
        return null;
    }
}
