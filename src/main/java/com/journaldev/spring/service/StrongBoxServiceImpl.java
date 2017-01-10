package com.journaldev.spring.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.StrongBoxDAO;
import com.journaldev.spring.model.StrongBox;

import java.util.List;

/**
 * Created by pcthomas on 10/01/2017.
 */
@Service
public class StrongBoxServiceImpl implements StrongBoxService {

        private StrongBoxDAO strongBoxDAO;

        public void setStrongBoxDAO(StrongBoxDAO strongBoxDAO) {
            this.strongBoxDAO = strongBoxDAO;
        }

        @Override
        @Transactional
        public void addStrongBox(StrongBox sb) {
            this.strongBoxDAO.addStrongBox(sb);
        }

        @Override
        @Transactional
        public void updateStrongBox(StrongBox sb) {
            this.strongBoxDAO.updateStrongBox(sb);
        }

        @Override
        @Transactional
        public List<StrongBox> listStrongBox() {
            return this.strongBoxDAO.listStrongBox();
        }

        @Override
        @Transactional
        public StrongBox getStrongBoxById(int id) {
            return this.strongBoxDAO.getStrongBoxId(id);
        }

        @Override
        @Transactional
        public void removeStrongBox(int id) {
            this.strongBoxDAO.removeStrongBox(id);
        }

}


