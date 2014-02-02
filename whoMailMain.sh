#!/bin/sh -e

echo "起動成功" >> /home/hdm/who.log

#cd `/usr/bin/dirname $0` これをやると他のPGでエラー発生

while (true)
do
  #バッククオートの結果に改行を残すために、ダブルクオートで囲む
  wk="`/usr/bin/who`"
  if [ "${wk}" != "${bk}" ] ; then
    echo "`/usr/bin/who`" | /usr/bin/java -cp /home/xxxx/lib/*.jar -jar /home/xxxx/javamail.jar "Console Access" "xxxx@xxxx.jp"
  fi
  bk=${wk}
  sleep 1
done
