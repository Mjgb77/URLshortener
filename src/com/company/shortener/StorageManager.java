package com.company.shortener;

import javax.print.DocFlavor;
import java.util.HashMap;

interface StorageManager {

    boolean hasURL(String url);

    int getID(String url);

    int pushURL(String url);

    boolean hasID(int id);

    String getFromID(int id);
}
