//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordList {
    private final HashTable hashTable;

    public WordList(String wordToCheck, String var1, StringHasher checkMethod) throws IOException {
        BufferedReader var3 = new BufferedReader(new FileReader(var1));
        int var4 = Integer.parseInt(var3.readLine());
        this.hashTable = new HashTable((var4 * 3), checkMethod);

        for(int var5 = 0; var5 < var4; ++var5) {
            this.hashTable.add(var3.readLine().trim().toUpperCase());
        }

        var3.close();
    }

    public boolean lookup(String var1) {
        return this.hashTable.lookup(var1.toUpperCase());
    }
}
