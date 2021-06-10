class MyCalendar {
public:
    MyCalendar() {

    }
    
    bool book(int start, int end) {
        for(int i = 0; i < calendar[0].size(); i++){
            if(calendar[0][i] == start || calendar[1][i] == end){
                return false;
            }
            else if(calendar[0][i] < start){
                if(calendar[1][i] > start){
                    return false;
                }
            }
            else if(calendar[0][i] > start){
                if(calendar[0][i] < end){
                    return false;
                }
            }

        }
        calendar[0].push_back(start);
        calendar[1].push_back(end);
        return true;
    }
private:
    vector<int> calendar[2];
};

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar* obj = new MyCalendar();
 * bool param_1 = obj->book(start,end);
 */