package LeetCode.tree;

class BinaryTree {
    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        }
    }

    public void delNode(int number) {
        if (this.root == null) {
            return;
        }
        if (this.root != null && this.root.getNumber() == number) {
            this.root = null;
            return;
        }
        this.root.preOrderDelNode(number);
    }
}
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        tree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        tree.preOrder();
//        tree.infixOrder();
//        tree.postOrder();
        System.out.println("---------------------------");
        tree.delNode(3);
        tree.preOrder();
    }
}
