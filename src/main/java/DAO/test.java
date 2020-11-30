package DAO;

import DAO.impl.MonHocDAO;
import Entity.MonHoc;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        MonHocDAO a = new MonHocDAO();
        a.findAll();
//
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("sotinchi","4");
        Object[] o = a.findByProperty(map,null,null,null,null,null);

        //HibernateUtil.getSessionFactory();
    }
}
