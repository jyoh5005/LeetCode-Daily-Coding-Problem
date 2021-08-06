/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<List<Integer>>();
        Queue<Node> queue = new LinkedList<Node>();
        int bfs_len = 1;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tree_part = new ArrayList<Integer>();
        tree_part.add(root.val);
        result.add(tree_part);
        queue.add(root);
        while(!queue.isEmpty()){
            tree_part = new ArrayList<Integer>();
            for(int i = 0; i < bfs_len; i++){
                for(Node n : queue.poll().children){
                    queue.add(n);
                    tree_part.add(n.val);
                }
            }
            bfs_len = queue.size();
            result.add(tree_part);
        }
        result.remove(result.size()-1);
        return result;
    }
}