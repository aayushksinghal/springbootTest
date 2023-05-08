package scaler;

import java.util.HashMap;

public class LRUCache {

    class DoublyLinkList{
        int key;
        String value;
        DoublyLinkList prev;
        DoublyLinkList next;

        public DoublyLinkList( int key, String value, DoublyLinkList prev, DoublyLinkList next){
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    DoublyLinkList head;
    DoublyLinkList tail;
    int size = 10;
    HashMap<Integer, DoublyLinkList> map = new HashMap<>();

    public static void main(String[] args){
        LRUCache cache = new LRUCache();
        cache.put(1,"Aayush1");
        cache.put(2,"Aayush2");
        cache.put(3,"Aayush3");
        cache.put(4,"Aayush4");
        cache.put(5,"Aayush5");
        cache.put(6,"Aayush6");
        cache.put(7,"Aayush7");
        cache.put(8,"Aayush8");
        cache.put(9,"Aayush9");
        cache.put(10,"Aayush10");
        cache.put(11,"Aayush11");
        cache.put(12,"Aayush12");
        cache.put(13,"Aayush13");
        cache.put(14,"Aayush14");

        System.out.println("For 3 - " + cache.find(3));
        System.out.println("For 6 - " + cache.find(6));

    }

    public void put(int key, String value){
        DoublyLinkList node = new DoublyLinkList(key,value,null,null);
        if(map.size() == 0){
            head =  node;
            tail = head;
            map.put(key,node);
        }
        else {
            if(map.containsKey(key)){
                removeFromList(map.get(key));
                map.remove(key);
            }
            addAtHead(node);
        }
    }

    public String find(int key){
        if(map.containsKey(key)){
            DoublyLinkList node = map.get(key);
            if(node != head){
                removeFromList(node);
                addAtHead(node);
            }
            return map.get(key).value;
        }
        return "";
    }

    private void removeFromList(DoublyLinkList node) {
        DoublyLinkList prev = node.prev;
        node.next.prev = prev;
        prev.next = node.next;
    }


    public void addAtHead(DoublyLinkList node ){
        if(size <= map.size()) {
            removeFromTail();
        }
        head.prev = node;
        node.next = head;
        head = node;
        map.put(node.key, node);
    }

    private void removeFromTail() {
        map.remove(tail.key);
        tail = tail.prev;
        tail.next = null;
    }


}
