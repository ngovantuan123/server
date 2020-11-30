/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.impl.MonHocDAO;
import DTO.MonHocDTO;
import Entity.MonHoc;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;

/**
 *
 * @author tuangh
 */
public class MonHocService {
    private MonHocDAO monHocDAO = new  MonHocDAO();
   
    public List<MonHocDTO> monHocDTOs(){
        List<MonHoc> all = monHocDAO.findAll();
        ModelMapper modelMapper= new ModelMapper();
        List<MonHocDTO> result = new ArrayList<>();
        for(MonHoc mh:all){
           MonHocDTO  dto=modelMapper.map(mh,MonHocDTO.class);
           dto.setNhom(null);
           result.add(dto);
        }
        return result;
    }
    
    public static void main(String[] args) {
        MonHocService hocService= new MonHocService();
        List<MonHocDTO> f=hocService.monHocDTOs();
        System.out.println("");
    }
    
}
