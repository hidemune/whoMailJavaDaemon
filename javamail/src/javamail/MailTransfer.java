package javamail;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailTransfer {
    
  public static int sendMail(String title, String to){
    System.out.println();

    String str[] = {"","","","","","","","","",""};
    
    //環境に合わせて設定してください。
    String from = "xxxx@xxx.jp";
    String host = "mail.xxxx.jp";
    String smtphost = "mail.xxxx.jp";

    // SMTPサーバー設定
    Properties props = System.getProperties();
    props.setProperty( "mail.smtp.port", "587"); 
    props.setProperty("mail.smtp.socketFactory.port", "587"); 
    props.put( "mail.smtp.host", smtphost );
    props.setProperty("mail.smtp.auth", "true");
    Session session = Session.getInstance(props, new Authenticator(){ 
    protected PasswordAuthentication getPasswordAuthentication() { 
            String str[] = {"","","","","","","","","",""};

            //環境に合わせて設定してください。絶対に公開しないでください。
            String user = "xxxx@xxxx.jp";
            String pass = "xxxxxxxx";
            
            return new PasswordAuthentication( user, pass ); 
        }
    }); 
    // Get system properties
    Properties properties = System.getProperties();

    // Setup mail server
    properties.setProperty(smtphost, host);
    
    try{
        MimeMessage mimeMessage=new MimeMessage(session);
        // ヘッダ
        //mimeMessage.setHeader("Content-Type","text/plain; charset=iso-2022-jp"); 
        // 送信元メールアドレスと送信者名を指定
        mimeMessage.setFrom(new InternetAddress(from,from,"iso-2022-jp"));
        // 送信先メールアドレスを指定
        mimeMessage.setRecipients(Message.RecipientType.TO,to);
        // メールのタイトルを指定
        mimeMessage.setSubject(title,"iso-2022-jp");
        // メールの内容を指定
        byte b[] = new byte[2048];
        System.in.read(b);
        String honbun = new String(b);
        honbun = honbun.replaceAll("\n", "\r\n");  //linuxの改行をcrlfに変更。
        mimeMessage.setText(honbun, "ISO-2022-JP");
        // メールの形式を指定
        mimeMessage.setHeader("Content-Type","text/plain; charset=iso-2022-jp");
        // 送信日付を指定
        mimeMessage.setSentDate(new Date());
        // 送信します
        Transport.send(mimeMessage);
        return 0;
    }catch(Exception mex){
      System.out.println("\n--Exception handling in javameil.java");
      mex.printStackTrace();
      return 1;
    }
  }
}
