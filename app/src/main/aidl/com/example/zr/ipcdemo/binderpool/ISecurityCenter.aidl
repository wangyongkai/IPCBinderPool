// ISecurityCenter.aidl
package com.example.zr.ipcdemo.binderpool;

// Declare any non-default types here with import statements

interface ISecurityCenter {
    String encrypt(String content);
    String decrypt(String password);
}
