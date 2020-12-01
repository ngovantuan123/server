package Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class mtest
{
    public static List<String> kq = new ArrayList<>();
    public static LinkedList<LinkedList<String>> tmp_outer = new LinkedList<>();
    public static List<String> tmp_inner = new ArrayList<>();

    public static void generate(LinkedList<LinkedList<String>> outerList, String outPut) {
        String s ="<html><div style='margin:20px;'><h1> Mạng</h1>";
                String [] t =s.split("<h1>");
        String monhoc = t[1].split("</h1>")[0].trim();
    }


    public static void main(String[] args)
    {
        LinkedList<LinkedList<String>> outerList = new LinkedList<LinkedList<String>>();

        LinkedList<String> list1 = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();
        LinkedList<String> list3 = new LinkedList<String>();

        list1.add("A");
        list1.add("B");

        list2.add("C");
        list2.add("D");



        list3.add("E");
        list3.add("F");

        outerList.add(list1);
        outerList.add(list2);
        outerList.add(list3);


        tmp_outer = outerList;



        //List<String> kq = new ArrayList<>();
        //
        generate(outerList,"");

        for(String item : kq){
            System.out.println(item+" ");
        }
    }
}