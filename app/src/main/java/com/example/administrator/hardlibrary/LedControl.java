package com.example.administrator.hardlibrary;

public class LedControl
{
    public static native int ledOpen( );
    public static native void ledClose( );
    public static native int ledCtl( int which, int status );

    static
    {
        try {
            System.loadLibrary("hardcontrol");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
