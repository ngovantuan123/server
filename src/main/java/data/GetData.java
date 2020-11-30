package data;

import DAO.IMonHocDAO;
import DAO.impl.MonHocDAO;
import Entity.Buoi;
import Entity.MonHoc;
import Entity.Nhom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetData {
    public static void main(String[] args) throws InterruptedException {
        String url = "http://thongtindaotao.sgu.edu.vn";
        //System.setProperty("webdriver.chrome.driver","/Users/tuangh/chromedriver.exe");
       //WebDriver driver = new ChromeDriver();
       // WebDriver driver = new EdgeDriver();

        WebDriver driver = new SafariDriver();
        try {


            // Navigate to URL
            driver.get(url);
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_txtTaiKhoa")).sendKeys("3117410284");
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_txtMatKhau")).sendKeys("tuangh123");
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_btnDangNhap")).click();


            //driver.findElement(By.id("ctl00_menu_lblDangKyMonHoc")).click();
            //driver.findElement(By.id("txtMaMH1")).sendKeys("841307");
            WebElement element = (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_menu_lblDangKyMonHoc")));
            element.click();
            driver.manage().getCookies();
            Select selectDKLoc = new Select((new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.id("selectDKLoc"))));
            selectDKLoc.selectByValue("khoa");
            Select selectKhoa = new Select(driver.findElement(By.id("selectKhoa")));
            selectKhoa.selectByValue("CT");
            Thread.sleep(3000);
            WebElement tbl = (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.id("pnlDSMonhocDK")));
            List<tbl_Monhoc> list = new ArrayList<tbl_Monhoc>();
            //tbl.findElements(By.className("body-table")).size();
            int i = 0;
            for (WebElement e : tbl.findElements(By.tagName("table"))) {
                tbl_Monhoc mh = new tbl_Monhoc();
                if (i != 0) {
                    List<WebElement> wes = e.findElements(By.tagName("td"));
                    mh.setMa(wes.get(1).getText());
                    mh.setTen(wes.get(2).getText());
                    mh.setNhom(wes.get(3).getText());
                    mh.setStc((wes.get(5)).getText());
                    mh.setMaLop(wes.get(7).getText());
                    mh.setSiSo(wes.get(8).getText());

                    //lay thu ra luu vao mang thus
                    List<String> list_thu = new ArrayList<String>();
                    List<WebElement> thus = wes.get(11).findElements(By.tagName("div"));
                    for (int t = 0; t < thus.size(); t++) {
                        if (t % 2 == 0) {
                            list_thu.add(thus.get(t).getText());//lay the div p vi tri chan
                        }
                    }
                    mh.setThu(list_thu);

                    //lay tiet bd
                    List<String> list_tbd = new ArrayList<String>();
                    List<WebElement> tiets = wes.get(12).findElements(By.tagName("div"));
                    for (int t = 0; t < tiets.size(); t++) {
                        if (t % 2 == 0) {
                            list_tbd.add(tiets.get(t).getText());//lay the div p vi tri chan
                        }
                    }
                    mh.setTietBD(list_tbd);

                    //lay so tiet
                    List<String> list_sotiet = new ArrayList<String>();
                    List<WebElement> sotiets = wes.get(13).findElements(By.tagName("div"));
                    for (int t = 0; t < sotiets.size(); t++) {
                        if (t % 2 == 0) {
                            list_sotiet.add(sotiets.get(t).getText());//lay the div p vi tri chan
                        }
                    }
                    mh.setSoTiet(list_sotiet);

                    //lay phong
                    List<String> list_phong = new ArrayList<String>();
                    List<WebElement> phongs = wes.get(14).findElements(By.tagName("div"));
                    for (int t = 0; t < phongs.size(); t++) {
                        if (t % 2 == 0) {
                            list_phong.add(phongs.get(t).getText());//lay the div p vi tri chan
                        }
                    }
                    mh.setPhong(list_phong);

                    //lay giang vien
                    List<String> list_gv = new ArrayList<String>();
                    List<WebElement> gvs = wes.get(15).findElements(By.tagName("div"));
                    for (int t = 0; t < gvs.size(); t++) {
                        if (t % 2 == 0) {
                            list_gv.add(gvs.get(t).getText());//lay the div p vi tri chan
                        }
                    }
                    mh.setGiangVien(list_gv);
                    System.out.println(mh.getMa());

                    list.add(mh);

                    List<String> th = new ArrayList<>();
                    List<WebElement> ths = wes.get(10).findElements(By.tagName("div"));
                    for (int t = 0; t < gvs.size(); t++) {
                        if (t % 2 == 0) {
                            th.add(ths.get(t).getText());//lay the div p vi tri chan
                        }
                    }
                    mh.setThuchanh(th);
                }
                i++;
            }
            //save data

            Map<String, MonHoc> monHocList = new HashMap<String, MonHoc>();//lấy tất cả các monn được mở
            for (int i1 = 0; i1 < list.size(); i1++) {
                MonHoc mh = new MonHoc();
                mh.setMaMH(list.get(i1).getMa());
                mh.setSoTinChi(list.get(i1).getStc());
                mh.setTenMonHoc(list.get(i1).getTen());
                monHocList.put(mh.getMaMH(), mh);
            }
            //lấy các nhóm của từng môn học
            list.forEach(item -> {
                Nhom n = new Nhom();
                n.setIdNhom(Integer.valueOf(item.getNhom()));
                n.setMaLop(item.getMaLop());
                n.setSiSo(Integer.valueOf(item.getSiSo()));
                n.setMonHoc(monHocList.get(item.getMa()));
                monHocList.get(item.getMa()).getNhom().add(n);
            });
            //Lấy từng buổi của từng nhóm
            for (int i4 = 0; i4 < list.size(); i4++) {
                tbl_Monhoc item = list.get(i4);
                MonHoc temp_mh = monHocList.get(item.getMa());
                for (int i5 = 0; i5 < temp_mh.getNhom().size(); i5++) {
                    for (int i3 = 0; i3 < item.getThu().size(); i3++) {
                        Buoi b = new Buoi();
                        b.setThu(item.getThu().get(i3));
                        b.setPhong(item.getPhong().get(i3));
                        b.setTietBD((Integer.valueOf(item.getTietBD().get(i3))));
                        b.setSoTiet(Integer.valueOf(item.getSoTiet().get(i3)));
                        b.setGiangVien(item.getGiangVien().get(i3));
                        boolean thuchanh = false;
                        if(item.getThuchanh().get(i3).equals("*")){
                            thuchanh=true;
                        }
                        b.setThucHanh(thuchanh);
                        //b.setThucHanh();
                        b.setNhom(monHocList.get(item.getMa()).getNhom().get(i5));
                        monHocList.get(item.getMa()).getNhom().get(i5).getBuois().add(b);
                    }
                    i4++;
                    if(i4 >= list.size()){
                        break;
                    }
                    item = list.get(i4);
                }
                i4--;
            }
            IMonHocDAO monHocDAO = new MonHocDAO();
            for(String k : monHocList.keySet()){
                MonHoc mh_save = monHocList.get(k);
                //mh_save.
                monHocDAO.save(mh_save);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Close driver
            driver.quit();
        }
        driver.quit();
    }
}