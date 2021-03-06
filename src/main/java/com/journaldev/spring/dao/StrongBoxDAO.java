package com.journaldev.spring.dao;

import com.journaldev.spring.model.StrongBox;

import java.util.List;

/**
 * Created by pcthomas on 10/01/2017.
 */
public interface StrongBoxDAO {

    public void addStrongBox(StrongBox sb);
    public void updateStrongBox(StrongBox sb);
    public List<StrongBox> listStrongBox();
    public StrongBox getStrongBoxId(int id);
    public void removeStrongBox(int id);

}
