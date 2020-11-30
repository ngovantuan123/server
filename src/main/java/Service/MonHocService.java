/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.impl.MonHocDAO;
import DAO.impl.NhomDAO;
import DTO.MonHocDTO;
import Entity.Buoi;
import Entity.MonHoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Entity.Nhom;
import org.json.JSONArray;
import org.modelmapper.ModelMapper;

/**
 * @author tuangh
 */
public class MonHocService {
    private MonHocDAO monHocDAO = new MonHocDAO();

    public List<MonHocDTO> monHocDTOs() {
        List<MonHoc> all = monHocDAO.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<MonHocDTO> result = new ArrayList<>();
        for (MonHoc mh : all) {
            MonHocDTO dto = modelMapper.map(mh, MonHocDTO.class);
            dto.setNhom(null);
            result.add(dto);
        }
        return result;
    }

    public List<MonHocDTO> getMonHocByKhoa(String maKhoa) {


        MonHocDAO a = new MonHocDAO();
        a.findAll();
//
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("khoa", maKhoa);
        Object[] o = a.findByProperty(map, null, null, null, null, null);
        List<MonHoc> mhs = new ArrayList<>();

        mhs.addAll((List<MonHoc>) o[1]);


        ModelMapper modelMapper = new ModelMapper();
        List<MonHocDTO> result = new ArrayList<>();
        for (MonHoc mh : mhs) {
            MonHocDTO dto = modelMapper.map(mh, MonHocDTO.class);
            dto.setNhom(null);
            result.add(dto);
        }
        return result;
    }

    public List<Object[]> getNhomsByMaMH(String maMH) {


        List<Object[]> data = filterByWhere("and m.maMh = " + maMH);

        //tkb(String thu,maMH, String tenMH, String maNhom, int sotiet, int tietBD, int tietKT, String phonghoc, String giangvien)
//        for (Object[] i : data) {
//            tkb tkb = new tkb(
//                    i[0].toString(),
//                    i[1].toString(),
//                    i[2].toString(),
//                    i[3].toString(),
//                    Integer.parseInt(i[4].toString()),
//                    Integer.parseInt(i[5].toString()),
//                    Integer.parseInt(i[4].toString()) + Integer.parseInt(i[5].toString()) - 1,
//                    Boolean.parseBoolean(i[6].toString()),
//                    i[7].toString(),
//                    i[8].toString()
//
//
//            );
//
//            lst_tkb.add(tkb);
//        }
        JSONArray t =new JSONArray(data);
        t.toString();
        return data;
    }

    public static List<Object[]> filterByWhere(String whereClause) {
        MonHocDAO monHocDAO = new MonHocDAO();
        List<Object[]> lst = monHocDAO.queryNativeExecute("select  n.idnhom as nhom,n.malop,n.siso,b.giangvien,b.phong,b.sotiet,b.thu,b.thuchanh,b.tietbd from monhoc m inner join nhom n on m.id = n.idmonhoc inner join buoi b on b.idnhom = n.id where 1=1  " + whereClause);

        return lst;
    }

    public static void main(String[] args) {
        MonHocService hocService = new MonHocService();
        List<MonHocDTO> lst = hocService.getMonHocByKhoa("CT");
        List<Object[]> lst1 = hocService.getNhomsByMaMH("841404");
        //List<MonHocDTO> f = hocService.monHocDTOs();
        System.out.println("");
    }

}
