public class problem8 {
    public int count;
    private static class Node
    {
        Node left,right;
        int val;

        Node(int val)
        {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    private static Node createTree()
    {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(0);
        root.right.left = new Node(1);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(1);
        root.right.right = new Node(0);

        return root;
    }
    public int countUnivalveSubtree(Node root)
    {
        this.count=0;
        helper(root,count);
        return this.count;
    }

    private boolean helper(Node root,int count)
    {
        if(root == null)
            return true;
        boolean leftVal = helper(root.left,count);
        boolean rightVal = helper(root.right,count);

        if(leftVal && rightVal)
        {
            if((root.left != null && root.left.val != root.val) || (root.right != null && root.right.val != root.val))
                return false;
                    
            this.count++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        problem8 p= new problem8();
        Node root = createTree();
        System.out.println(p.countUnivalveSubtree(root));
    }
}
