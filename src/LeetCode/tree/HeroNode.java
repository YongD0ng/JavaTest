package LeetCode.tree;

public class HeroNode {
    private int number;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        // 递归左子树 前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历

    public void infixOrder() {
        // 递归左子树 前序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        // 递归左子树 前序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNode preOrderSearch(int number) {
        if (this.number == number) {
            return this;
        }
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.preOrderSearch(number);
        }
        if (res != null) {
            return res;
        }
        if (this.right != null) {
            res = this.right.preOrderSearch(number);
        }
        if (res != null) {
            return res;
        }
        return res;
    }


    public boolean preOrderDelNode(int number) {
        if (this.left != null && this.left.number == number) {
            this.left = null;
            return true;
        }
        if (this.right != null && this.right.number == number) {
            this.right = null;
            return true;
        }
        boolean res = false;
        if (this.left != null) {
            res = this.left.preOrderDelNode(number);
            return res;
        }

        if (this.right != null) {
            res = this.right.preOrderDelNode(number);
            return res;
        }
        return false;
    }
}
