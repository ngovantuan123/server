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
        LinkedList<String> list = outerList.get(0);

        for(int i=0;i< list.size();++i) {
            String str = list.get(i);
            LinkedList<LinkedList<String>> newOuter = new LinkedList<LinkedList<String>>(outerList);
            newOuter.remove(list);



            int a = -1;
            outer: for(int k=0;k<tmp_outer.size();++k){

                tmp_inner = tmp_outer.get(k);
                for(int j=0;j<tmp_inner.size();++j){

                    if(tmp_inner.get(j).equals(str)) {
                        a = k;

                        break outer;
                    }
                }
            }

            if(outerList.size() > 1) {




                generate(newOuter,  outPut+a+"="+i);
            } else {

                kq.add(outPut+ a+"+"+i);
                //System.out.println(outPut+str);
            }
        }
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