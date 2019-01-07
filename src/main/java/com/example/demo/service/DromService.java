package com.example.demo.service;

import com.example.demo.model.Drom;

import java.util.List;

public interface DromService {
    public List selectAll();
    public void addDrom(Drom drom);
    public List selectDrom(String type,String number,String floor,String number1);
    public Drom selectDromOne(String dtype,String dnumber1);
    Drom selectDromDemo(int id);
    void updatedrom(Drom drom);

}
