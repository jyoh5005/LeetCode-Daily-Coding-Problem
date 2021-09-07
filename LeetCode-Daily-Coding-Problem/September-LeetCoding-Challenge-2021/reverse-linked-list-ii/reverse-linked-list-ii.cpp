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
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        if(left == 1) return reverse1(head, left, right);
        else return reverse2(head, left, right);
    }
    ListNode* reverse1(ListNode* head, int left, int right){
        ListNode* prev = head;
        ListNode* swic = head->next;
        for(; left < right; left++){
            ListNode* nextNode = swic->next;
            swic->next = prev;
            prev = swic;
            swic = nextNode;
        }
        head->next = swic;
        return prev;
    }
    ListNode* reverse2(ListNode* head, int left, int right){
        ListNode* ptr = head;
        for(int i = 2; i < left; i++) ptr = ptr->next;
        ListNode* prev = ptr->next;
        if(prev == nullptr) return head;
        ListNode* swic = prev->next;
        for(; left < right; left++){
            ListNode* nextNode = swic->next;
            swic->next = prev;
            prev = swic;
            swic = nextNode;
        }
        ptr->next->next = swic;
        ptr->next = prev;
        return head;
    }
};