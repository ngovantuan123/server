package Service;

import DAO.impl.MonHocDAO;
import DAO.impl.NhomDAO;
import Entity.MonHoc;
import Utils.HibernateUtil;
import org.hibernate.Session;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class main {

    public static List<String> truonghopList = new ArrayList<>(); // dung de luu

    public static LinkedList<LinkedList<tkb>> tmp_outer = new LinkedList<>();
    public static List<tkb> tmp_inner = new ArrayList<>();
    public static List<tkb> output = new ArrayList<>();

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        MonHocDAO monHocDAO = new MonHocDAO();
        NhomDAO nhomDAO = new NhomDAO();
        List<MonHoc> lstMonhoc = monHocDAO.findAll();
        //List<Object[]> lstMonhoc1 = monHocDAO.queryNativeExecute("select m.maMH from monhoc m inner join nhom n on m.id = n.idmonhoc");

        // input data
        List<String> subjectWanted = new ArrayList<>();

         subjectWanted.add("84106790"); // ko ton tai
        subjectWanted.add("841121"); //

        subjectWanted.add("841324"); //
        subjectWanted.add("841065"); //

         subjectWanted.add("841111");//
         //subjectWanted.add("841307");//


        // tkb
//        Map<keyDistinct, tkb> tkb_mon = new LinkedHashMap<>(); /// các môn ko trùng nhau
//        List<tkb> lst_tkb = new ArrayList<>();
//
//        // tìm môn học theo mã mh
//        for (String item : subjectWanted) {
//            MonHoc mh = new MonHoc();
//            //mh = monHocDAO.findById(Integer.parseInt(item));
//            if (isExistsMonHoc(item)) {
//                List<Object[]> data = filterByWhere("and m.maMh = " + item);
//
//                //tkb(String thu,maMH, String tenMH, String maNhom, int sotiet, int tietBD, int tietKT, String phonghoc, String giangvien)
//                for (Object[] i : data) {
//                    tkb tkb = new tkb(
//                            i[0].toString(),
//                            i[1].toString(),
//                            i[2].toString(),
//                            i[3].toString(),
//                            Integer.parseInt(i[4].toString()),
//                            Integer.parseInt(i[5].toString()),
//                            Integer.parseInt(i[4].toString()) + Integer.parseInt(i[5].toString()) - 1,
//                            Boolean.parseBoolean(i[6].toString()),
//                            i[7].toString(),
//                            i[8].toString()
//
//
//                    );
//                    keyDistinct k = new keyDistinct(i[2].toString(), i[3].toString());
//                    tkb_mon.put(k, tkb);
//                    lst_tkb.add(tkb);
//                }
//            } else {
//                continue;
//            }
//
//
//        }
//        //------------------------------------------------- main here
//        // tao outerList cho ham generate
//        Map<String, String> maNhomAndTenMH = new LinkedHashMap<>();
//
//        LinkedList<LinkedList<tkb>> temp1 = new LinkedList<>();
//        LinkedList<tkb> t1 = new LinkedList<>();
//
//        for (String item : subjectWanted) {
//
//            // neu ton tai mon hoc thi duyet
//            if (isExistsMonHoc(item)) {
//                List<Object[]> data = getMaNhomByMH("and m.maMh = " + item);
//
//                // luu vao hash map de bo trung
//                maNhomAndTenMH = new LinkedHashMap<>();
//                t1 = new LinkedList<>();
//
//                for (Object[] i : data) {
//                    maNhomAndTenMH.put(i[2].toString(), i[1].toString());
//
//
//                }
//                // chuyen cac element cua hashmap vao linkedList
//                for (String key : maNhomAndTenMH.keySet()) {
//                    t1.add(new tkb(key, maNhomAndTenMH.get(key)));
//                    //System.out.println("key: " + key + " value: " + maNhomAndTenMH.get(key));
//                }
//                temp1.add(t1);
//            } else {
//                continue;
//            }
//
//        }
//
//        // generate ra cac truong hop
//        String outPut = "";
//        output = new ArrayList<>();
//        tmp_outer = temp1;
//        generate(temp1, outPut);
//        //generate1(temp1, output);
//
//
//        // show list truong hop
//        for (String item : truonghopList) {
//            System.out.println(item + " " + truonghopList.size() + "truong hop");
//        }
//
//        //
//        // 01;04;06;01  vitri+maNhom ; vitri+manhom
//        List<List<tkb>> lists = new ArrayList<>();
//        List<tkb> tmpItem = new ArrayList<>();
//        List<Integer> index_outer = new ArrayList<>();
//        List<Integer> index_inner = new ArrayList<>();
//        for (String item : truonghopList) {
//            String[] lst1 = item.split("");  // [01,12,..]
//
//            index_outer = new ArrayList<>();
//            index_inner = new ArrayList<>();
//            for (int i = 0; i < lst1.length; ++i) {      // tmp = 01
//                if (i % 2 == 1) { // i
//                    index_inner.add(Integer.parseInt(lst1[i]));
//                } else {  // a
//                    index_outer.add(Integer.parseInt(lst1[i]));
//                }
//            }
//            // duyet index arr
//            tmpItem = new ArrayList<>();
//            for (int i = 0; i < index_outer.size(); ++i) {
//                for (int j = 0; j < index_inner.size(); ++j) {
//                    if (i == j) {
//                        tkb tkb = temp1.get(index_outer.get(i)).get(index_inner.get(j));
//                        tmpItem.add(tkb);
//                    }
//                }
//            }
//
//            lists.add(tmpItem);
//
//        }
//        for (List<tkb> item : lists) {
//            System.out.println(item.toString() + " " + truonghopList.size() + "truong hop");
//        }
//
//        // mảng cuối cùng để thêm dk lọc "lists"
//        List<List<tkb>> mainlists = new ArrayList<>();
//        List<tkb> mainItem = new ArrayList<>();
//        for (List<tkb> item : lists) {
//            mainItem = new ArrayList<>();
//            for (int i = 0; i < item.size(); ++i) {
//
//                for (tkb tkb : lst_tkb) {
//                    if (tkb.getMaNhom().equals(item.get(i).getMaNhom()) && tkb.getTenMH().equals(item.get(i).getTenMH())) {
//                        mainItem.add(tkb);
//                    }
//                }
//
//            }
//            mainlists.add(mainItem);
//
//        }
//
//        //====================== lọc từ đây !!!!!!!!!
//        List<List<tkb>> dupllists = new ArrayList<>();
//        List<tkb> testItem = new ArrayList<>();
//        Map<String, String> mapTenMH = new LinkedHashMap<>();
//
//
//        String thu[] = {"Hai", "Ba", "Tư", "Năm", "Sáu", "Bảy"};
//        // xử lý gôm nhóm theo thứ
//        for (int k = 0; k < mainlists.size(); ++k) {
//            List<tkb> item = mainlists.get(k);
//            mapTenMH = new LinkedHashMap<>();
//
//            for (int i = 0; i < thu.length; ++i) {
//                String thu_i = thu[i];
//
//                // lọc ra theo thứ trong thu[] đối với "mỗi danh sách trường hợp tkb đã gen"
//                List<tkb> r = item.stream()
//                                    .filter((t) -> t.getThu().equals(thu_i))
//                                    .collect(Collectors.toList());
//
//                if (r.size() >= 2) {
//                    int a = k;
//                    // them vao map ten MH để bỏ trùng 2 mh
//                    for (tkb t : r) {
//                        mapTenMH.put(t.getTenMH(), t.getTietBD() + "");
//                    }
//
//                }
//
//                if (mapTenMH.size() >= 2) {
//                    dupllists.add(r);
//                    mapTenMH = new LinkedHashMap<>();
//
//                }
//
//            }
//
//        }
//
//        List<Boolean> list_check = new ArrayList<>();
//        for (List<tkb> item : dupllists) {
//
//            boolean result = checkConflictTietBD(item);
//            // nếu kết quả kiểm tra thì xóa ra khỏi mảng môn học hợp lệ cuối cùng
//            if(result == true){
//                // lưu số lượng trường hợp sai đúng
//                list_check.add(result);
//
//                // xóa trong mảng chính
//                for(List<tkb> t : mainlists){
//                    if(t.containsAll(item)){
//                        mainlists.remove(t) ;
//                        break;
//                    }
//                }
//
//            }
//
//
//        }
//
//        System.out.println("Số trường hợp sai trong mảng dupl: "+list_check.size());
//
//
//        // lấy mảng thời khóa biểu hợp lệ để lọc tiếp các điều kiện từ người dùng
//        // mainLists là tổng hợp những list<tkb> ( danh sách tkb) có thể có sau khi thực hiện gen đệ quy
//        // filter something with List<List<tkb>> mainLists
//        //solution1(lst_tkb);
//
//        //==================== tiếp tục thêm đk lọc
//        List<List<tkb>> allMorning = new ArrayList<>();
//        List<String> monMongMuon = new ArrayList<>();
//        monMongMuon.add("841121");
//        monMongMuon.add("841324");
//        monMongMuon.add("841111");
//        // muốn môn ppnc học buổi sáng
//        // nếu sl r = sl môn học đó trong item
//        allMorning = filterSubjectByBuoi(mainlists,monMongMuon,"sáng"); // sáng hoặc chiều

    }
    public static Predicate<tkb> buoinao(String mon,String buoi) {
        if(buoi.equals("sáng")){ //chieu
           return t -> t.getMaMH().equals(mon) && t.getTietBD() <= 5;
        }
        return t -> t.getMaMH().equals(mon) && t.getTietBD() > 5;
    }
    public static List<List<tkb>> filterSubjectByBuoi(List<List<tkb>> main,List<String> monList,String buoi){
        List<List<tkb>> allMorning = new ArrayList<>();
        List<tkb> temp = new ArrayList<>();
        int sum = 0;
        for (int k = 0; k < main.size(); ++k) {
            List<tkb> item = main.get(k);
            // reset value
            sum = 0;
            temp = new ArrayList<>();

            for(String mon : monList) {
                List<tkb> r = item.stream()
                                .filter(buoinao(mon,buoi))
                                .collect(Collectors.toList());
                temp.addAll(r);
                // số lượng của môn truyền vào trong tkb
                long sl = item.stream().filter((t) -> t.getMaMH().equals(mon)).count();
                sum += sl ;
            }
            if(temp.size() == sum){
                allMorning.add(item);

            }

        }
        return allMorning;
    }


    /*
     * Xử lý xung đột tiết bd
     * kiểm tra tiết BD hợp lệ
     * dk trc : cùng thứ -> khác tên môn họ
     * */
    public static boolean checkConflictTietBD(List<tkb> item) {

        for (int i = 0; i < item.size(); i++) {
            for (int j = i + 1; j < item.size(); j++) {

                if(!item.get(i).getTenMH().equals(item.get(j).getTenMH())){
                    // nếu tên môn học này khác môn học kia
                    if ((item.get(i).getTietBD() >= item.get(j).getTietBD() && item.get(i).getTietBD() <= item.get(j).getTietKT()) || (item.get(j).getTietBD() >= item.get(i).getTietBD() && item.get(j).getTietBD() <= item.get(i).getTietKT()))  {
                        // điều kiện tiết bd của môn này bằng với môn kia
                        // hoặc tiết BD môn này trong khoảng của môn kia


                        System.out.println(item.get(i).getTenMH() + " và " + item.get(j).getTenMH() + " trùng thời khóa biểu\n");
                        System.out.println("Tiết BD 1 :" + item.get(i).getTietBD());
                        System.out.println("Tiết KT 1 :" + item.get(i).getTietKT());
                        System.out.println("Tiết BD 2 :" + item.get(j).getTietBD());
                        System.out.println("Tiết KT 2 :" + item.get(j).getTietKT());
                        return true;
                    }
                }else{
                    continue;
                }

            }
        }
        return false;

    }


    // generate cac truong hop theo ma nhom
    public static void generate(LinkedList<LinkedList<tkb>> outerList, String outPut) {
        LinkedList<tkb> list = outerList.get(0);


        for (int i = 0; i < list.size(); ++i) {
            LinkedList<LinkedList<tkb>> newOuter = new LinkedList<LinkedList<tkb>>(outerList);

            newOuter.remove(list);
            tkb str = list.get(i);

            int a = -1;
            for (int k = 0; k < tmp_outer.size(); ++k) {
                for (int j = 0; j < tmp_outer.get(k).size(); ++j) {
                    tmp_inner = tmp_outer.get(k);
                    if (tmp_inner.get(j).equals(str)) {
                        a = k;
                        k = tmp_outer.size();
                        break;
                    }
                }
            }
            if (outerList.size() > 1) {

                generate(newOuter, outPut + a + ";" + i + ";");
            } else {

                truonghopList.add(outPut + a + ";" + i);

                //System.out.println(outPut+str);
            }
        }
    }




    public static void solution1(List<tkb> lst_tkb) {
        List<tkb> kq = new ArrayList<>();
        tkb t = new tkb();
        tkb t1 = new tkb();
        for (int i = 0; i < lst_tkb.size(); ++i) {
            t = lst_tkb.get(i); // dòng trước

            for (int j = i + 1; j < lst_tkb.size(); ++j) {

                t1 = lst_tkb.get(j);

                // nếu tồn tại r
                if (isExistElementMaMH(kq, t1.getMaMH())) {
                    continue;
                } else {

                    // nếu môn học đang duyệt có mã giống với môn tiếp theo
                    if (t.getMaMH().equals(t1.getMaMH())) {

                        if (t.getMaNhom().equals(t1.getMaNhom())) {

                            kq.add(t);
                            kq.add(t1);


                        } else {
                            continue; // bỏ qua
                        }

                    } else {

                        // nếu thứ ko trùng ( ko cùng thứ )
                        if (!t.getThu().equals(t1.getThu())) {
                            kq.add(t1);
                        } else {
                            // kt tietBD
                            if (t1.getTietBD() >= t.getTietBD() && t1.getTietBD() <= t.getTietKT()) {
                                continue;
                            }

                        }


                    }
                }


            }
            for (tkb item : kq) {
                System.out.println(item.toString() + kq.size());
            }

            System.out.println("---------------[[0978--------------------");


        }
        System.out.println("-----------------[[------------------");
        for (tkb item : lst_tkb) {
            System.out.println(item.toString() + lst_tkb.size());
        }
    }

    public static boolean isExistElementMaMH(List<tkb> tkbList, String maMH) {
        for (tkb item : tkbList) {
            if (item.getMaMH().equals(maMH)) {
                return true;
            }
        }
        return false;
    }




    public static List<Object[]> filterByWhere(String whereClause) {
        MonHocDAO monHocDAO = new MonHocDAO();
        List<Object[]> lst = monHocDAO.queryNativeExecute("select  b.thu , m.maMH , m.tenmonhoc ,n.idnhom ,b.sotiet,b.tietbd,b.thuchanh ,b.phong, b.giangvien from monhoc m inner join nhom n on m.id = n.idmonhoc inner join buoi b on b.idnhom = n.id where 1=1  " + whereClause);
        return lst;
    }

    public static List<Object[]> getMaNhomByMH(String whereClause) {
        MonHocDAO monHocDAO = new MonHocDAO();
        List<Object[]> lst = monHocDAO.queryNativeExecute("select   m.maMH , m.tenmonhoc ,n.idnhom from monhoc m inner join nhom n on m.id = n.idmonhoc inner join buoi b on b.idnhom = n.id where 1=1  " + whereClause);
        return lst;
    }

    // kiểm tra tồn tại môn học theo mã môn học
    public static boolean isExistsMonHoc(String maMH) {
        MonHocDAO monHocDAO = new MonHocDAO();
        List<MonHoc> lstMonhoc = monHocDAO.findAll();
        for (MonHoc item : lstMonhoc) {
            if (item.getMaMH().equals(maMH)) {
                return true;
            }
        }
        return false;
    }
    public static List<List<tkb>>  mainProcess(List<String> request){
        Session session = HibernateUtil.getSessionFactory().openSession();
        MonHocDAO monHocDAO = new MonHocDAO();
        NhomDAO nhomDAO = new NhomDAO();
        MonHoc mh1 = monHocDAO.findMaKhoabyMaMH(request.get(request.size()-1));
        List<MonHoc> lstMonhoc = monHocDAO.findbyMaKhoa(mh1.getKhoa());
        //List<Object[]> lstMonhoc1 = monHocDAO.queryNativeExecute("select m.maMH from monhoc m inner join nhom n on m.id = n.idmonhoc");

        // input data
        List<String> subjectWanted = request;

        // tkb
        Map<keyDistinct, tkb> tkb_mon = new LinkedHashMap<>(); /// các môn ko trùng nhau
        List<tkb> lst_tkb = new ArrayList<>();

        // tìm môn học theo mã mh
        for (String item : subjectWanted) {
            MonHoc mh = new MonHoc();
            //mh = monHocDAO.findById(Integer.parseInt(item));
            if (isExistsMonHoc(item)) {
                List<Object[]> data = filterByWhere("and m.maMh = " + item);

                //tkb(String thu,maMH, String tenMH, String maNhom, int sotiet, int tietBD, int tietKT, String phonghoc, String giangvien)
                for (Object[] i : data) {
                    tkb tkb = new tkb(
                            i[0].toString(),
                            i[1].toString(),
                            i[2].toString(),
                            i[3].toString(),
                            Integer.parseInt(i[4].toString()),
                            Integer.parseInt(i[5].toString()),
                            Integer.parseInt(i[4].toString()) + Integer.parseInt(i[5].toString()) - 1,
                            Boolean.parseBoolean(i[6].toString()),
                            i[7].toString(),
                            i[8].toString()


                    );
                    keyDistinct k = new keyDistinct(i[2].toString(), i[3].toString());
                    tkb_mon.put(k, tkb);
                    lst_tkb.add(tkb);
                }
            } else {
                continue;
            }


        }
        //------------------------------------------------- main here
        // tao outerList cho ham generate
        Map<String, String> maNhomAndTenMH = new LinkedHashMap<>();

        LinkedList<LinkedList<tkb>> temp1 = new LinkedList<>();
        LinkedList<tkb> t1 = new LinkedList<>();

        for (String item : subjectWanted) {

            // neu ton tai mon hoc thi duyet
            if (isExistsMonHoc(item)) {
                List<Object[]> data = getMaNhomByMH("and m.maMh = " + item);

                // luu vao hash map de bo trung
                maNhomAndTenMH = new LinkedHashMap<>();
                t1 = new LinkedList<>();

                for (Object[] i : data) {
                    maNhomAndTenMH.put(i[2].toString(), i[1].toString());


                }
                // chuyen cac element cua hashmap vao linkedList
                for (String key : maNhomAndTenMH.keySet()) {
                    t1.add(new tkb(key, maNhomAndTenMH.get(key)));
                    //System.out.println("key: " + key + " value: " + maNhomAndTenMH.get(key));
                }
                temp1.add(t1);
            } else {
                continue;
            }

        }

        // generate ra cac truong hop
        String outPut = "";
        output = new ArrayList<>();
        tmp_outer = temp1;
        generate(temp1, outPut);
        //generate1(temp1, output);


        // show list truong hop
        for (String item : truonghopList) {
            System.out.println(item + " " + truonghopList.size() + "truong hop");
        }

        //
        // 01;04;06;01  vitri+maNhom ; vitri+manhom
        List<List<tkb>> lists = new ArrayList<>();
        List<tkb> tmpItem = new ArrayList<>();
        List<Integer> index_outer = new ArrayList<>();
        List<Integer> index_inner = new ArrayList<>();
        for (String item : truonghopList) {
            String[] lst1 = item.split(";");  // [01,12,..]

            index_outer = new ArrayList<>();
            index_inner = new ArrayList<>();
            for (int i = 0; i < lst1.length; ++i) {      // tmp = 01
                if (i % 2 == 1) { // i
                    index_inner.add(Integer.parseInt(lst1[i]));
                } else {  // a
                    index_outer.add(Integer.parseInt(lst1[i]));
                }
            }
            // duyet index arr
            tmpItem = new ArrayList<>();
            for (int i = 0; i < index_outer.size(); ++i) {
                for (int j = 0; j < index_inner.size(); ++j) {
                    if (i == j) {
                        tkb tkb = temp1.get(index_outer.get(i)).get(index_inner.get(j));
                        tmpItem.add(tkb);
                    }
                }
            }

            lists.add(tmpItem);

        }
        for (List<tkb> item : lists) {
            System.out.println(item.toString() + " " + truonghopList.size() + "truong hop");
        }

        // mảng cuối cùng để thêm dk lọc "lists"
        List<List<tkb>> mainlists = new ArrayList<>();
        List<tkb> mainItem = new ArrayList<>();
        for (List<tkb> item : lists) {
            mainItem = new ArrayList<>();
            for (int i = 0; i < item.size(); ++i) {

                for (tkb tkb : lst_tkb) {
                    if (tkb.getMaNhom().equals(item.get(i).getMaNhom()) && tkb.getTenMH().equals(item.get(i).getTenMH())) {
                        mainItem.add(tkb);
                    }
                }

            }
            mainlists.add(mainItem);

        }

        //====================== lọc từ đây !!!!!!!!!
        List<List<tkb>> dupllists = new ArrayList<>();
        List<tkb> testItem = new ArrayList<>();
        Map<String, String> mapTenMH = new LinkedHashMap<>();


        String thu[] = {"Hai", "Ba", "Tư", "Năm", "Sáu", "Bảy"};
        // xử lý gôm nhóm theo thứ
        for (int k = 0; k < mainlists.size(); ++k) {
            List<tkb> item = mainlists.get(k);
            mapTenMH = new LinkedHashMap<>();

            for (int i = 0; i < thu.length; ++i) {
                String thu_i = thu[i];

                // lọc ra theo thứ trong thu[] đối với "mỗi danh sách trường hợp tkb đã gen"
                List<tkb> r = item.stream()
                        .filter((t) -> t.getThu().equals(thu_i))
                        .collect(Collectors.toList());

                if (r.size() >= 2) {
                    int a = k;
                    // them vao map ten MH để bỏ trùng 2 mh
                    for (tkb t : r) {
                        mapTenMH.put(t.getTenMH(), t.getTietBD() + "");
                    }

                }

                if (mapTenMH.size() >= 2) {
                    dupllists.add(r);
                    mapTenMH = new LinkedHashMap<>();

                }

            }

        }

        List<Boolean> list_check = new ArrayList<>();
        for (List<tkb> item : dupllists) {

            boolean result = checkConflictTietBD(item);
            // nếu kết quả kiểm tra thì xóa ra khỏi mảng môn học hợp lệ cuối cùng
            if(result == true){
                // lưu số lượng trường hợp sai đúng
                list_check.add(result);

                // xóa trong mảng chính
                for(List<tkb> t : mainlists){
                    if(t.containsAll(item)){
                        mainlists.remove(t) ;
                        break;
                    }
                }

            }


        }

        System.out.println("Số trường hợp sai trong mảng dupl: "+list_check.size());


        // lấy mảng thời khóa biểu hợp lệ để lọc tiếp các điều kiện từ người dùng
        // mainLists là tổng hợp những list<tkb> ( danh sách tkb) có thể có sau khi thực hiện gen đệ quy
        // filter something with List<List<tkb>> mainLists
        //solution1(lst_tkb);

        //==================== tiếp tục thêm đk lọc
        List<List<tkb>> allMorning = new ArrayList<>();
        List<String> monMongMuon = new ArrayList<>();
        monMongMuon.add("841121");
        monMongMuon.add("841324");
        monMongMuon.add("841111");
        // muốn môn ppnc học buổi sáng
        // nếu sl r = sl môn học đó trong item
        allMorning = filterSubjectByBuoi(mainlists,monMongMuon,"sáng"); // sáng hoặc chiều
     return mainlists;
    }
}
