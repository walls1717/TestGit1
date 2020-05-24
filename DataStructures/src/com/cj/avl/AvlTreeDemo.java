package com.cj.avl;

public class AvlTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        //创建AVLTree对象
        AVLTree avlTree = new AVLTree();
        //添加节点
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("平衡处理：");
        System.out.println("树的高度：" + avlTree.getRoot().height());
        System.out.println("树的左子树高度：" + avlTree.getRoot().leftHeight());
        System.out.println("树的右子树高度：" + avlTree.getRoot().rightHeight());
        System.out.println("当前的根节点：" + avlTree.getRoot());
        System.out.println("当前节点的左子节点：" + avlTree.getRoot().right.right);
    }
}

