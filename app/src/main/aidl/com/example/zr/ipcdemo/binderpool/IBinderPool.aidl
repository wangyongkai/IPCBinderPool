// IBinderPool.aidl
package com.example.zr.ipcdemo.binderpool;


interface IBinderPool {
   IBinder queryBinder(int binderCode);
}
