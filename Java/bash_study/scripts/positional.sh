#!/bin/bash
# positional.sh
# This script reads 3 positional parameters and prints them out.
POSPAR1="$1"
POSPAR2="$2"
POSPAR3="$3"
echo "$1 is the first positional parameter, \$1."
echo "$2 is the second positional parameter, \$2."
echo "$3 is the third positional parameter, \$3."
echo

echo "The total number of positional parameters is $#."


export JAVA_OPT="
-jar
-XX:-OmitStackTraceInFastThrow
-Xmx4g
-Xms4g
-XX:+PrintGC
-XX:+PrintGCDetails
-XX:+PrintHeapAtGC
-XX:+PrintTenuringDistribution
-XX:+PrintGCTimeStamps
-XX:+PrintGCDateStamps
-XX:+UseConcMarkSweepGC
-XX:CMSFullGCsBeforeCompaction=0
-XX:+UseCMSCompactAtFullCollection
-XX:+ExplicitGCInvokesConcurrent
-XX:CMSInitiatingOccupancyFraction=70
-XX:+UseCMSInitiatingOccupancyOnly
-Xmn1g
-Xss512k
-XX:SurvivorRatio=6
-XX:ReservedCodeCacheSize=64m
-XX:InitialCodeCacheSize=64m
-XX:+HeapDumpOnOutOfMemoryError
-Xloggc:/opt/logs/logs/qdb-trade-center-admin/gclogs/qdb-trade-center-admin.gc.log
-verbose:gc
-XX:+PrintGCDetails
-XX:+PrintGCDateStamps
-XX:+PrintGCTimeStamps
-XX:+UseGCLogFileRotation
-XX:NumberOfGCLogFiles=10
-XX:GCLogFileSize=256M
-Dspring.profiles.active=test"

echo ${JAVA_OPT}
#在某个变量后添加
PATH=PATH:/Users/wh/IdeaProjects/study/Java/bash_study/script
echo ${PATH}

