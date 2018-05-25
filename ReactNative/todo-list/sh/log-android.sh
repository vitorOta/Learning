#!/usr/bin/env bash

#export JAVA_HOME=/usr/lib/jvm/default-java

#export ANDROID_SDK_ROOT=$HOME/Android/Sdk
export ANDROID_HOME=$HOME/Android/Sdk

#export PATH=$PATH:$ANDROID_HOME/tools
#export PATH=$PATH:$ANDROID_HOME/platform-tools

$ANDROID_HOME/platform-tools/adb logcat *:S ReactNative:V ReactNativeJS:V BackgroundTask:V