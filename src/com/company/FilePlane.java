package com.company;

import java.io.IOException;
import java.util.StringTokenizer;

public class FilePlane extends FilePersistence{
    public String []getContentFile() throws IOException{
        String content = readFile();
        StringTokenizer Lines = new StringTokenizer(content, "\n");
        String[] outPut = new String[Lines.countTokens()];
        int cont=0;
        while (Lines.hasMoreTokens()) {
            outPut[cont ++] = Lines.nextToken();
        }
        return outPut;
    }

    public void setContentFile(String...content) throws IOException{
        StringBuilder dump = new StringBuilder();
        for(String line: content) {
            dump.append(line + "\n");
        }
        writeFile(dump.toString());
    }
}
