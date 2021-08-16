package greedy;
import java.util.HashMap;

/**
 * Huffman coding is a loss-less compresion technique.  It assigns variable-length bit codes to different characters.
 * The Greedy Choice is to assign the least bit length code to the most frequent character.
 * 
 * Algorithm :   Initially, each char is represented by a node whose weight is the characters frequence in the string we are trying to compress.
 *              Take the 2 nodes with the smallest weight and combine their weight to create a new node to replace the original 2 where the weight 
 *              of the new node is the sum of the original 2. The process continues until all nodes are combined into a binary tree. When traversing
 *              the binary tree down to the leafs (characters from the original string), a move left correspondes to a 0 and a move right correspondes 
 *              to a 1. The end result of one traversal would be a sequence of binary bits (codeword), where each codeword is uniqure to the character.
 * Evaluation:  It is required that no codeword is a prefix of another, thus binary tree structure is essential.
 */
public class HuffmanCoding{

    public static void algorithm(String s){
        HashMap<String, HuffmanNode> store = new HashMap<String, HuffmanNode>();

        // calculate frequency
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i); 
            HuffmanNode value = store.get(""+c);
            if (value == null){
                HuffmanNode newNode = new HuffmanNode(c, 1);
                store.put(""+c, newNode);
            }
            else{
                int freq = value.getWeight();
                value.setWeight(freq+1);
                store.put(""+c, value);
            }
        }

        // convert hashmap to array
        HuffmanNode[] nodes = store.values().toArray(new HuffmanNode[0]);
        String[] characters = (String[]) store.keySet().toArray(new String[0]);

        // sort the array in order of increasing node weight
        sort(nodes);

        // algorithm
        HuffmanNode root = new HuffmanNode('-', 0);
        root.setRight(nodes[0]);
        root.setLeft(nodes[1]);
        int weight = root.getLeft().getWeight() + root.getRight().getWeight();
        root.setWeight(weight);
        int currentIndex = 2;
        while(currentIndex < nodes.length){
            HuffmanNode temp = new HuffmanNode('-', 0);
            temp.setRight(root);
            temp.setLeft(nodes[currentIndex++]);
            int tempWeight = root.getLeft().getWeight() + root.getRight().getWeight();
            temp.setWeight(tempWeight);
            root = temp;
        }
        
        // convert to an array 
        int len = characters.length;
        CharData[] data = new CharData[len];
        for(int i = 0; i < len; i++){
            char c = characters[i].charAt(0);
            CharData temp = new CharData(c);
            data[i] = temp;
        }
        
        //traverse the nodes
        traversal(root, data, "");

        // create a hashMap with key corresponding to characters and value corresponding to its sequence
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for(int i = 0; i < data.length; i++){
            System.out.println("" + data[i].getChar() + ": " + data[i].getSequence());
            hashMap.put(""+data[i].getChar(), data[i].getSequence());
        }

        // display the sequence
        System.out.print("Solution: ");
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            String temp = "" + c;
            String charSeq = hashMap.get(temp);
            System.out.print(charSeq + " ");
        }
        System.out.println(" ");

    }

    private static void sort(HuffmanNode[] arr){
        int n = arr.length-1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // if the weight of the huffman node at index j is greater than at index j+1, swap them
                if(arr[j].getWeight() > arr[j+1].getWeight()){
                    // swap the elements
                    HuffmanNode temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * 
     * @param node current node down the tree
     * @param data array for all characters and paths. By the end all indexes a=will contain a path as arrays are passed by reference.
     * @param path keeps track of the path down the tree
     */
    private static void traversal(HuffmanNode node, CharData[] data, String path){
        // if at a leaf
        if(node.getLeft() == null && node.getRight() == null){
            // set the path to the char
            for(int  i = 0; i < data.length; i++){
                if(data[i].getChar() == node.getChar()){
                    data[i].setSeq(path);
                }
            }
            return;
        }

        traversal(node.getLeft(), data, path+"0");
        traversal(node.getRight(), data, path+"1");
    }

    public static void main(String[] args){
        algorithm("AABACDACA");
    }
}

class HuffmanNode{
    private Integer weight;
    private char c;
    private HuffmanNode left;
    private HuffmanNode right;

    HuffmanNode(char c, Integer weight){
        this.weight = weight;
        this.c = c;
        this.right = null;
        this.left = null;
    }

    public void setWeight(Integer weight){this.weight = weight;}
    public void setChar(char c){this.c = c;}
    public void setLeft(HuffmanNode left){this.left = left;}
    public void setRight(HuffmanNode right){this.right = right;}

    public Integer getWeight(){return this.weight;}
    public char getChar(){return this.c;}
    public HuffmanNode getLeft(){return this.left;}
    public HuffmanNode getRight(){return this.right;}
}

class CharData{
    private char c;
    private String seq;

    CharData(char c){
        this.c = c;
        this.seq = "";
    }

    public void setSeq(String s){this.seq = s;}

    public char getChar(){return this.c;}
    public String getSequence(){return this.seq;}
}