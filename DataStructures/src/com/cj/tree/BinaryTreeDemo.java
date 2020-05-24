package com.cj.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        HeroNode node6 = new HeroNode(6, "CJ");
        HeroNode node7 = new HeroNode(7, "豹子头");

        //说明：先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        binaryTree.setRoot(root);

        //测试
//        System.out.println("前序遍历"); //1, 2, 3, 5, 4
//        binaryTree.preOrder();
//        System.out.println("中序遍历"); //2, 1, 5, 3, 4
//        binaryTree.infixOrder();
//        System.out.println("后序遍历"); //2, 5, 4, 3, 1
//        binaryTree.postOrder();
        //前序遍历查找
        /*System.out.println("前序遍历方式");
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if (resNode != null) {
            System.out.printf("找到了，信息为no = %d, name = %s\n", resNode.getNo(), resNode.getName());
        } else {
            System.out.println("没有找到");
        }*/

        /*//中序遍历查找
        System.out.println("中序遍历查找");
        HeroNode resNode = binaryTree.infixOrderSearch(5);
        if (resNode != null) {
            System.out.printf("找到了，信息为no = %d, name = %s\n", resNode.getNo(), resNode.getName());
        } else {
            System.out.println("没有找到");
        }*/

        /*
        //后序遍历查找
        HeroNode resNode = binaryTree.postOrderSearch(2);
        if (resNode != null) {
            System.out.printf("找到了，信息为no = %d, name = %s\n", resNode.getNo(), resNode.getName());
        } else {
            System.out.println("没有找到");
        }

        //测试删除
        System.out.println("删除前，前序遍历");
        binaryTree.preOrder();
        binaryTree.delNode(3);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder();

         */

        binaryTree.postOrder();
    }
}

//定义二叉树
class BinaryTree {
    //表示根节点
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //删除节点
    public void delNode(int no) {
        if (root != null) {
            //如果只有一个root节点，这里需要立即判断root是不是就是要删除的节点
            if (root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("空树不能删除");
        }
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后续遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        if (this.root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        if (this.root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }
}

