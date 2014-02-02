/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javamail;

import static java.lang.System.exit;

/**
 *
 * @author hdm
 */
public class Javamail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println(Integer.toString(args.length));
        if (args.length != 2) {
            System.out.println("Usage:\necho \"mailtext\" | java -cp lib/*.jar -jar javamail.jar \"Title\" \"ToAddress\"");
            exit(1);
        } else {
            int ret = MailTransfer.sendMail(args[0], args[1]);
            exit(ret);
        }
    }
}
