#include <jni.h>  /* /usr/lib/jvm/java-1.7.0-openjdk-amd64/include/ */
#include <stdio.h>
#include <stdlib.h>



jint c_ledOpen(JNIEnv *env, jobject cls)
{

	
	return 0;
}

void c_ledClose(JNIEnv *env, jobject cls)
{

}

jint c_ledCtl(JNIEnv *env, jobject cls,jint which, jint statu)
{
	return 0;
}


static const JNINativeMethod methods[] = {
	{"ledOpen", "()I", (void *)c_ledOpen},
	{"ledClose", "()V", (void *)c_ledClose},
	{"ledCtl", "(II)I", (void *)c_ledCtl},
};

/* System.loadLibrary */
JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *jvm, void *reserved)
{
	JNIEnv *env;
	jclass cls;

	if ((*jvm)->GetEnv(jvm, (void **)&env, JNI_VERSION_1_4)) {
		return JNI_ERR; /* JNI version not supported */
	}
	cls = (*env)->FindClass(env, "com/example/administrator/hardlibrary/LedControl");
	if (cls == NULL) {
		return JNI_ERR;
	}

	/* 2. map java hello <-->c c_hello */
	if ((*env)->RegisterNatives(env, cls, methods, sizeof(methods)/sizeof(methods[0])) < 0)
		return JNI_ERR;

	return JNI_VERSION_1_4;
}

//complile arm-linux-gcc -fPIC -shared hardcontrol.c -o libhardcontrol.so -I /usr/lib/jvm/java-1.7.0-openjdk-amd64/include/ -nostdlib /work/android-5.0.2/prebuilts/ndk/9/platforms/android-19/arch-arm/usr/lib/libc.so

