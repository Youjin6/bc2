package yli6_p2EC;

import java.util.ArrayList;

/**
 * This rearrangeMsg class implements a function of combine multiple messages
 * into a plain text.
 *
 * @author youjin
 * @version 1.0
 */
public class RearrangeMsg {
    // store multiple messageDecoder objects
    private ArrayList<MessageDecoder> msgList;

    // set messageDecoder value
    public void setMsgList(ArrayList<MessageDecoder> msgList) {
        this.msgList = msgList;
    }

    /**
     * Rearrange the messages into one plain text
     */
    public void Rearrange() {
        // A String list to store the messages
        String[] messages = new String[msgList.size()];

        // A two dimensional array to store each subarray
        String[][] list = new String[msgList.size()][];

        // Gets each message
        for (int i = 0; i < msgList.size(); i++) {
            messages[i] = String.valueOf(msgList.get(i));
        }

        // Splits a single message by space
        for (int i = 0; i < messages.length; i++) {
            list[i] = messages[i].split(" ");
        }

        // Gets the max length of the messages
        int maxSize = list[0].length;
        for (String[] strings : list) {
            if (strings.length > maxSize) {
                maxSize = strings.length;
            }
        }

        // Prints out the plain text
        System.out.print("\nPlain text: ");
        for (int j = 0; j < maxSize; j++) {
            for (String[] strings : list) {
                if (strings.length <= j) {
                    continue;
                }
                System.out.print(strings[j] + " ");
            }
            System.out.print("");
        }
        System.out.println();
    }
}
