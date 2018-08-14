// IBookManager.aidl
package com.example.zr.ipcdemo.aidl;

// Declare any non-default types here with import statements
import com.example.zr.ipcdemo.aidl.Book;
import com.example.zr.ipcdemo.aidl.IOnNewBookArrivedListener;

interface IBookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

            List<Book> getBookList();
            void addBook(in Book book);
            void registerListener(IOnNewBookArrivedListener listener);
            void unregisterListener(IOnNewBookArrivedListener listener);
}
