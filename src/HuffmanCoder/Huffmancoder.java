import java.util.*;

class HuffmanCoder{
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    private class Node implements Comparable<Node>{
        Character data;
        int cost;
        Node left;
        Node right;

        public Node(Character data, int cost){
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public HuffmanCoder(String feeder) throws  Exception{
        HashMap<Character, Integer> fmap = new HashMap<>();

        for (int i = 0; i < feeder.length(); i++) {
            char ch = feeder.charAt(i);
            if(fmap.containsKey(ch)){
                int ov = fmap.get(ch);
                ov+=1;
                fmap.put(ch, ov);
            }else{
                fmap.put(ch, 1);
            }
        }
       PriorityQueue<Node> minHeap = new PriorityQueue<>();
       Set<Map.Entry<Character,Integer>> entrySet = fmap.entrySet();
       for(Map.Entry<Character,Integer> entry : entrySet){
        Node node = new Node(entry.getKey(), entry.getValue());
        minHeap.add(node);
       }

       while(minHeap.size() != 1){
            Node first = minHeap.remove();
            Node second = minHeap.remove();
            Node newNode =  new Node('\0',first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;
            minHeap.add(newNode);
       }
       Node ft = minHeap.remove();
       this.encoder = new HashMap<>();
       this.decoder = new HashMap<>();
       this.initEncoderDecoder(ft,"");
    }

     private void initEncoderDecoder(Node node, String osf) {
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            this.encoder.put(node.data,osf);
            this.decoder.put(osf, node.data);
        }
        initEncoderDecoder(node.left, osf + "0");
        initEncoderDecoder(node.right, osf + "1");
    }

    public String encode(String source){
        String ans = "";
        for (int i = 0; i < source.length(); i++) {
            ans = ans + encoder.get(source.charAt(i));
        }
        return ans;
    }

    public String decode(String codedString){
        String key = "";
        String ans = "";
        for (int i = 0; i < codedString.length(); i++) {
            key = key + codedString.charAt(i);
            if(decoder.containsKey(key)){
                ans = ans + decoder.get(key);
                key = "";
            }
        }
        return ans;
    }

    public static void main(String[] args) throws  Exception {
        String str = "abbccda";
        HuffmanCoder hf = new HuffmanCoder(str);
        String cs = hf.encode(str);
        System.out.println(cs);
        String dc = hf.decode(cs);
        System.out.println(dc);
    }
}