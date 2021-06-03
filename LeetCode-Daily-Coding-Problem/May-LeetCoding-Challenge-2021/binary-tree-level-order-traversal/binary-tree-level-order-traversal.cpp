/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if(root == nullptr){
            return result;
        }

        queue<TreeNode*> ptr_queue;
        queue<int> depth_queue;
        
        vector<int>* values;
        TreeNode* ptr;
        int depth = -1;
        
        ptr_queue.push(root);
        depth_queue.push(0);
        
        while(!depth_queue.empty()){
            ptr = ptr_queue.front();
            if(depth + 1 == depth_queue.front()){
                result.push_back(*(new vector<int>));
                depth++;
                values = & result[depth];
            }
            
            ptr_queue.pop();
            depth_queue.pop();
            
            values->push_back(ptr->val);
            
            if(ptr->left != nullptr){
                ptr_queue.push(ptr->left);
                depth_queue.push(depth+1);
            }
            if(ptr->right != nullptr){
                ptr_queue.push(ptr->right);
                depth_queue.push(depth+1);
            }
        }
        return result;
    }
};