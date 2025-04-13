package com.railApplication.Service;

import com.railApplication.Repo.OrderRetrieveRepo;
import com.railApplication.domain.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class OrderRetrieveService {
    @Autowired
    OrderRetrieveRepo orderRetrieveRepo;

    public List<Passenger> fetchOrderDetails(String PNR){
        return orderRetrieveRepo.retrieveOrderDetails(PNR);
    }

}
