/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(k == 1){
            return head;
        }
        head = reverseLinkedList(head, k);
        ListNode* ptr = head;
        int count = 1;
        while(check(ptr, k)){
            if(count < k){
                count++;
                ptr = ptr->next;
            }
            else{
                ptr->next = reverseLinkedList(ptr->next, k);
                ptr = ptr->next;
                count = 1;
            }
        }
        return head;
    }
    ListNode* reverseLinkedList(ListNode* head, int k){
        ListNode* prev = head;
        ListNode* cur = head->next;
        ListNode* temp;
        for(; k > 1; k--){
            temp = cur->next;
            cur->next = prev;
            prev = cur;
            cur = temp;
        }
        head->next = cur;
        return prev;
    }
    bool check(ListNode* head, int k){
        for(; k > 0; k--){
            if(head->next == nullptr){
                return false;
            }
            head = head->next;
        }
        return true;
    }
};