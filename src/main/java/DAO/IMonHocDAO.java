package DAO;

import Entity.MonHoc;

public interface IMonHocDAO extends GenericDAO<Integer,MonHoc> {
    MonHoc findByMaMH(int maMH);
}
