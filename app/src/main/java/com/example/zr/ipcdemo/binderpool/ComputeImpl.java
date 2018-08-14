package com.example.zr.ipcdemo.binderpool;

import android.os.RemoteException;

/**
 * Created by netease on 16/4/6.
 */
public class ComputeImpl extends ICompute.Stub {

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

}
