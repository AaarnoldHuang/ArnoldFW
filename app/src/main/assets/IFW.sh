#!/bin/bash
file_name=$2
item_name=$3
str1="<rules>\n<activity block=\"true\" log=\"false\">\n""$item_name"" />\n</activity>"
str2="<rules>\n<service block=\"true\" log=\"false\">\n""$item_name"" />\n</service>"
str4="</rules>"
while getopts ":ab:" optname
  do
    case "$optname" in
      "a")
        echo "Activity"
         a=1
        ;;
      "b")
        echo "Broadcast"
         a=2
        ;;
      "s")
        echo "Service"
         a=3
        ;;
    esac
  done
ls -l|grep "$file_name"
    r=$? &&
    if [ $r == 1 ]; then
        touch /data/system/ifw/$file_name
            #exit 1
#        elif [ $r == 0 ]; then
            #exit 0
    fi
if [ $a == 1 ]
then
    echo -e $str1 >> /data/system/ifw/$file_name
elif [ $a == 2 ]
then
    echo -e $str2 >> /data/system/ifw/$file_name
fi

echo $str4 >> /dataa/system/ifw/$file_name
