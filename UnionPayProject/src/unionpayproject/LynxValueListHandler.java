/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unionpayproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CN085258
 */
public class LynxValueListHandler {
    
    public static List<UnionpayOrderVO> getFormattedRepushOrderList(String valuelist)throws Exception {
        String rowSplitter = "\n";//处理\n分割符
        String colSplitter = "\\\\n"; //处理\\n分割符
        ArrayList<UnionpayOrderVO> rtnOrderList = new ArrayList<UnionpayOrderVO>();
        UnionpayOrderVO upvo;
        String customsReturnString = TestTran110.Test_API110();
        String[] splitOrderRows = customsReturnString.split(rowSplitter);
        String[] splitOrderCols;
        for(int i=0;i<splitOrderRows.length;i++){
            upvo = new UnionpayOrderVO();
            System.out.println("splitOrderLines "+i+" "+splitOrderRows[i]);
            splitOrderCols = splitOrderRows[i].split(colSplitter);
            upvo.setOrderNo(splitOrderCols[2]);
            upvo.setRespCode(splitOrderCols[18]);
            rtnOrderList.add(upvo);
//            System.out.println("test order return valus");
//            for(int j=0;j<splitOrderCols.length;j++){                
//                System.out.println("splitOrderCols "+j+" "+splitOrderCols[j]);
//            }
        }
        System.out.println("get rtnOrderList Content");
        for(int i=0;i<rtnOrderList.size();i++) {
            upvo = (UnionpayOrderVO)rtnOrderList.get(i);
            System.out.println(upvo.toString());
        }
        return rtnOrderList;
    }

    public static void main(String[] args)throws Exception {
        getFormattedRepushOrderList("test values");
    }
}
