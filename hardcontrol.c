#include<stdio.h>
#include<stdlib.h>
#include<jni.h>

 

jint ledOpen(JNIEnv * env , jobject obj )
{

	return 0;
}


void ledClose(JNIEnv * env , jobject obj )
{

}

jint ledCtl(JNIEnv * env , jobject obj, jint which,jint status )
{

	return 0;
}

static const JNINativeMethod nm[]=
{
	{ "ledOpen",  "()I", (void*)ledOpen },
	{ "ledClose",  "()V", (void*)ledClose },
	{ "ledCtl",  "(II)I", (void*)ledCtl },

};
JNI_OnLoad(JavaVM *jvm, void *reserved)
{
	JNIEnv *env;
	jclass cls;
	
	if ((*jvm)->GetEnv(jvm, (void **)&env, JNI_VERSION_1_2)) {
		return JNI_ERR; /* JNI version not supported */
	}
	
	cls = (*env)->FindClass(env, "com/example/administrator/hardlibrary/LedControl");
	if (cls == NULL) {
		return JNI_ERR;
	}

	if( (*env)->RegisterNatives(env, cls, nm, sizeof(nm)) < 0 )
	{
		return JNI_ERR;
	}
		
	
	return JNI_VERSION_1_2;
}

