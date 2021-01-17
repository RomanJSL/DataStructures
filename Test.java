public class Test {
    public static void main(String args[]){

        System.out.println("---------------------------------------------");
        System.out.println("LinkedList");
        System.out.println("---------------------------------------------");
        MyLinkedList ds = new MyLinkedList();

        System.out.println("LinkedList = " + ds.toString());
        ds.add(1);ds.add(2);ds.add(3);
        ds.add(4);ds.add(5);ds.add(6);


        System.out.println("LinkedList = " + ds.toString());

        System.out.println("Remove index 2 = "+ ds.remove(2));
        System.out.println("Remove start = "+ ds.remove());
        System.out.println("Get index 3 = "+ ds.get(3));
        System.out.println("LinkedList = " + ds.toString());

        System.out.println("Push 99 and 100");ds.push(99);ds.push(100);
        System.out.println("LinkedList = " + ds.toString());

        System.out.println("Pop = "+ds.pop());
        System.out.println("Pop = "+ds.pop());
        System.out.println("LinkedList = " + ds.toString());

        System.out.println("---------------------------------------------");
        System.out.println("ArrayList");
        System.out.println("---------------------------------------------");

        MyArrayList al = new MyArrayList();

        System.out.println("Array list = " + al.toString());
        al.add(1);al.add(2);al.add(3);
        al.add(4);al.add(5);al.add(6);


        System.out.println("Array list = " + al.toString());

        System.out.println("Remove index 2 = "+ al.remove(2));
        System.out.println("Remove from end = "+ al.remove());
        System.out.println("Get index 3 = "+ al.get(3));
        System.out.println("Array list = " + al.toString());

        System.out.println("---------------------------------------------");
        System.out.println("HashTable");
        System.out.println("---------------------------------------------");

        HashTable ht = new HashTable(10);

        ht.set("hello","world");
        System.out.println("Add pair <'hello','world'>");
        ht.set("hi","there");
        System.out.println("Add pair <'hi','there'>");
        ht.set("general","kenobi");
        System.out.println("Add pair <'general','kenobi'>");
        ht.set("the","senate");
        System.out.println("Add pair <'the','senate'>\n");

        System.out.println("get('hello') = "+ht.get("hello"));
        System.out.println("get('hi') = "+ht.get("hi"));
        System.out.println("get('general') = "+ht.get("general"));
        System.out.println("get('the') = "+ht.get("the"));

        System.out.println("\nremove('the') = "+ht.remove("the"));
        System.out.println("get('the') = "+ht.get("the"));

        System.out.println("\nremove('hello') = "+ht.remove("hello"));
        System.out.println("get('hello') = "+ht.get("hello"));
        System.out.println("get('general') = "+ht.get("general"));

    }
}
