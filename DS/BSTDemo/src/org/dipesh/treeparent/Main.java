package org.dipesh.treeparent;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        BSTParent bst = new BSTParent();
        int[] arr = new int[]{12,5,18,2,9,15,19,13,17};
        Arrays.stream(arr).forEach(i -> bst.insertIterative(i));
        bst.inOrderRec().stream().forEach(i -> System.out.print(i + " "));
        System.out.println();

        bst.postOrderRec().stream().forEach(i -> System.out.print(i + " "));
        System.out.println();

        bst.postOrderIterative().stream().forEach(i -> System.out.print(i + " "));
        System.out.println();

    }
}
