/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.model;

import com.airline.logic.InfoUser.DaoInfoUser;
import com.airline.logic.InfoUser.InfoUser;

/**
 *
 * @author bryan
 */
public class InfoUserModel {

    public boolean updateInfoUser(InfoUser infoUser) {
        return dao.updateInfoUser(infoUser);
    }

    public boolean addInfoUser(InfoUser infoUser) {
        return dao.addInfoUser(infoUser);
    }

    public InfoUser getInfoUserByID(String id) {
        return dao.getInfoUserById(id).get();
    }

    public boolean verifyID(String id) {
        return dao.verifyID(id);
    }

    private InfoUserModel() {
        dao = DaoInfoUser.getInstance();
    }

    public static InfoUserModel getInstance() {
        if (instance == null) {
            instance = new InfoUserModel();
        }
        return instance;
    }

private static InfoUserModel instance = null;
    private final DaoInfoUser dao;

}
