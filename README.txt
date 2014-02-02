whoMailJavaDaemon



(Please put these files on the same directory.)
javamail.jar
lib/javax.mail.jar
whoMailD.sh
whoMailMain.sh


(Install example) for Ubuntu

sudo su

cp -f whoMailD /etc/init.d/whoMailD
chmod +x /etc/init.d/whoMailD
cd /etc/rcS.d
ln -s ../init.d/whoMailD S99whoMailD



(Usage)
/etc/init.d/whoMailD start

