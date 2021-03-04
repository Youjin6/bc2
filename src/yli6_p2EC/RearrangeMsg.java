package yli6_p2EC;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeMsg {
    private ArrayList<MessageDecoder> msgList;
    private String[][] TwoDList;


    public void setMsgList(ArrayList<MessageDecoder> msgList) {
        this.msgList = msgList;

    }

    public ArrayList<MessageDecoder> getMsgList() {
        return msgList;
    }

    public void Rearrange() {
        String[] messages = new String[msgList.size()];
        String[][] list = new String[msgList.size()][];

        System.out.println(msgList);
        for (int i = 0; i < msgList.size(); i++) {
            messages[i] = String.valueOf(msgList.get(i));

        }
//
//        for (int j = 0; j < messages.length; j++) {
//            String[] s = messages[j].split(" ");
//
//            for (int k = 0; k < s.length; k++) {
//                System.out.println(s[k]);
//            }
//        }

        for (int i = 0; i < messages.length; i++) {

        }






    }
}
