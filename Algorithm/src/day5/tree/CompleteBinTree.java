package day5.tree;

import java.util.Arrays;
import java.util.Scanner;

public class CompleteBinTree {
    
    static char[] nodes;
    static int lastIndex, SIZE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SIZE = sc.nextInt();
        nodes = new char[SIZE+1];
        lastIndex = SIZE;
        
        for (int i = 0; i < SIZE; i++) {
            nodes[i+1] = (char)('A' + i); // 1번 인덱스부터 사용
        }
        
        System.out.println(Arrays.toString(nodes));
        
        getChild(1);
        getChild(5);
        
        getParent(10);
        getParent(1);
    }
    
    private static void getChild(int currIndex) {
        int left = 2*currIndex; // 왼쪽 노드
        int right = 2*currIndex + 1; // 오른쪽 노드
        if (left <= lastIndex) System.out.println("왼쪽 노드 : " + nodes[left]);
        if (right <= lastIndex) System.out.println("오른쪽 노드 : " + nodes[right]);
    }
    
    private static void getParent(int currIndex) {
        int parent = currIndex / 2;
        if (parent >= 1) System.out.println("부모 노드 : " + nodes[parent]);
        else System.out.println(nodes[currIndex] + " 는 루트 노드 입니다.");
    }

}