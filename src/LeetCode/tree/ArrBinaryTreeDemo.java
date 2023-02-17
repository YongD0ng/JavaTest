package LeetCode.tree;

public class ArrBinaryTreeDemo {

    private int[] arr;

    public ArrBinaryTreeDemo(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(int index) {
        if (this.arr == null || this.arr.length == 0) {
            return;
        }
        if (index < arr.length) {
            System.out.println(arr[index]);
        }
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTreeDemo treeDemo = new ArrBinaryTreeDemo(arr);
        treeDemo.preOrder(0);
    }
}
