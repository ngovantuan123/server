package DAO.impl;

import DAO.IMonHocDAO;
import Entity.MonHoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonHocDAO extends AbstracDAO<Integer,MonHoc> implements IMonHocDAO   {

    @Override
    public MonHoc findByMaMH(int maMH) {
        return null;
    }

    public List<MonHoc> findbyMaKhoa(String khoa) {
        MonHocDAO a = new MonHocDAO();
        a.findAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("khoa", khoa);
        Object[] o = a.findByProperty(map, null, null, null, null, null);
        List<MonHoc> mhs = new ArrayList<>();
        return (List<MonHoc>)o[1];
    }

    public MonHoc findMaKhoabyMaMH(String maMH) {
        MonHocDAO a = new MonHocDAO();
        a.findAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mamh", maMH);
        Object[] o = a.findByProperty(map, null, null, null, null, null);
         List<MonHoc> lst = (List<MonHoc>)o[1];
        return  lst.get(0);
    }
}
