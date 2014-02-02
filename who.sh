#!/bin/bash

cd `dirname $0`

while (true)
do
  #clear
  wk=`who`
  if [ "${wk}" != "${bk}" ] ; then
    echo `who` | java -jar javamail.jar "コンソールに動きがありました" "tanaka-hidemune@ezweb.ne.jp"

    echo ${wk} >> /home/hdm/who.log
    echo "" >> /home/hdm/who.log
  fi
  bk=${wk}
  who
  date +"%Y/%m/%d"
  date +"%I:%M:%S"
  sleep 10
done
