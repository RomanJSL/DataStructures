import java.nio.charset.StandardCharsets;

public class HashTable {

    private class pair{
        protected String key;
        protected String value;
        protected int hash;
        protected pair next;
    }

    private pair[] table;
    private int size;
    private final int hashseed = 7;


    public HashTable(int size){
        table = new pair[size];
        this.size = 0;
    }
    public HashTable(){
        table = new pair[100];
        this.size = 0;
    }
    public void set(String key, String value){
        pair kv = new pair();
        kv.key = key;
        kv.value = value;
        kv.hash = hash(key);

        if(table[kv.hash]==null){
            table[kv.hash]=kv;
            return;
        }else{
            pair temp =  table[kv.hash];
            if(temp.key == key){
                temp.value = value;
                return;
            }
            while(temp.next!=null){
                temp = temp.next;
                if(temp.key == key){
                    temp.value = value;
                    return;
                }
            }
            temp.next = kv;
            return;
        }
    }
    public String get(String key){
        int hashkey = hash(key);
        pair temp = table[hashkey];

        if(temp==null){
            return null;
        }else if(temp.key.equals(key)){
            return temp.value;
        }else{
            while(temp.next!=null){
                temp = temp.next;
                if(temp.key.equals(key)){
                    return temp.value;
                }
            }
            if(temp.key.equals(key)){
                return temp.value;
            }
        }

        return null;
    }

    public String remove(String key){
        int hashkey = hash(key);
        pair temp = table[hashkey];
        if(temp==null){
            return null;
        }else if(temp.key.equals(key)){
            String value = temp.value;
            table[hashkey] = temp.next;
            return value;
        }else{
            while(temp.next!=null){
                if(temp.next.key.equals(key)){
                    String value = temp.next.value;
                    temp.next = temp.next.next;
                    return value;
                }
                temp = temp.next;
            }

        }

        return null;
    }

    private int hash(String string){
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        int hash = hashseed;
        for(int i = 0; i < bytes.length; i++){
            hash += (53^i)*bytes[i];
        }
        hash = hash%table.length;
        return hash;
    }


}
