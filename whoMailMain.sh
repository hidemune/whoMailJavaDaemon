#!/bin/sh -e

echo "起動成功" >> /home/hdm/who.log

#cd `/usr/bin/dirname $0` これをやると他のPGでエラー発生

while (true)
do
  #バッククオートの結果に改行を残すために、ダブルクオートで囲む
  wk="`/usr/bin/who`"
  if [ "${wk}" != "${bk}" ] ; then
    echo "`/usr/bin/who`" | /usr/bin/java -cp /home/hdm/tool/MyJavamail/lib/*.jar -jar /home/hdm/tool/MyJavamail/javamail.jar "Console Access" "tanaka-hidemune@ezweb.ne.jp"
  fi
  bk=${wk}
  sleep 1
done
