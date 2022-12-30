
#include "native-lib.h"

extern "C" JNIEXPORT jstring JNICALL


Java_ru_fotostrana_socketapp_constant_APIClient_stringFromJNI(
        JNIEnv *env, //default env parameter.
        jobject /* this, activity context. */) {
    std::string hello = "http://157.245.125.183:1203/";
    return env->NewStringUTF(hello.c_str());
}



